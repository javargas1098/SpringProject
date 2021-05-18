package com.example.test.services.impl;

import com.example.test.entities.*;
import com.example.test.dtos.CharacterDTO;
import com.example.test.dtos.EpisodeDTO;
import com.example.test.dtos.LocationDTO;
import com.example.test.entities.Character;
import com.example.test.repositories.CharacterRepository;
import com.example.test.repositories.EpisodeCharacterRepository;
import com.example.test.repositories.EpisodeRepository;
import com.example.test.repositories.LocationRepository;
import com.example.test.services.EpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    private final CharacterRepository characterRepository;
    private final EpisodeCharacterRepository episodeCharacterRepository;
    private final EpisodeRepository episodeRepository;
    private final LocationRepository locationRepository;
    private final RestTemplate restTemplate;

    private final String uri = "https://rickandmortyapi.com/api/episode";

    public EpisodeServiceImpl(CharacterRepository characterRepository, EpisodeCharacterRepository episodeCharacterRepository, EpisodeRepository episodeRepository, LocationRepository locationRepository, RestTemplate restTemplate) {
        this.characterRepository = characterRepository;
        this.episodeCharacterRepository = episodeCharacterRepository;
        this.episodeRepository = episodeRepository;
        this.locationRepository = locationRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public CompletableFuture<ResponseEntity<Episode>> consulta(int numero) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Episode episode = new Episode();
                List<Character> characters = new LinkedList<>();
                EpisodeDTO episodeDTO = restTemplate.getForObject("https://rickandmortyapi.com/api/episode" + "/" + numero, EpisodeDTO.class);
                episode.setEpisodeName(episodeDTO.getName());
                episodeDTO.getCharacters().forEach(chac -> {
                    Character character = new Character();
                    Location location = new Location();
                    EpisodeCharacterPk episodeCharacterPk = new EpisodeCharacterPk();
                    EpisodeCharacter episodeCharacter = new EpisodeCharacter();
                    CharacterDTO characterDTO = restTemplate.getForObject(chac, CharacterDTO.class);
                    LocationDTO locationDTO = restTemplate.getForObject(characterDTO.getLocation().getUrl(), LocationDTO.class);
                    character.setId(characterDTO.getId());
                    character.setName(characterDTO.getName());
                    character.setSpecies(characterDTO.getSpecies());
                    character.setImage(characterDTO.getImage());
                    character.setGender(characterDTO.getGender());
                    location.setId(locationDTO.getId());
                    location.setName(locationDTO.getName());
                    location.setDimension(locationDTO.getDimension());
                    location.setType(locationDTO.getType());

                    if (!locationRepository.findById(location.getId()).isPresent()) locationRepository.save(location);
                    character.setLocation(location);
                    if (!characterRepository.findById(character.getId()).isPresent())
                        characterRepository.save(character);
                    characters.add(character);
                    episodeCharacterPk.setEpisode(numero);
                    episodeCharacterPk.setCharacter(characterDTO.getId());
                    episodeCharacter.setEpisodeCharacterPk(episodeCharacterPk);
                    if (!episodeCharacterRepository.findById(episodeCharacter.getEpisodeCharacterPk()).isPresent())
                        episodeCharacterRepository.save(episodeCharacter);

                });
                episode.setId(numero);
                episode.setEpisodeName(episodeDTO.getName());
                episode.setCharacters(characters);
                if (!episodeRepository.findById(numero).isPresent()) episodeRepository.save(episode);
                return new ResponseEntity<>(episode, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });

    }
}

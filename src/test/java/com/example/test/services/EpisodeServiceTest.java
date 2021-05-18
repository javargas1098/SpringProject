package com.example.test.services;

import com.example.test.entities.Character;
import com.example.test.entities.Episode;
import com.example.test.entities.EpisodeCharacter;
import com.example.test.entities.Location;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(MockitoJUnitRunner.class)
public class EpisodeServiceTest {

    private static final Integer NUMBER = 28;

    private static final String EPISODE_NAME = "The Ricklantis Mixup";
    private static final String DIMENSION = "Replacement Dimension";
    private static final String CHARACTER_NAME = "Morty Smith";



    @InjectMocks
    private Episode episodeMock;
    private Location locationMock;
    private Character characterMock;
    private EpisodeCharacter episodeCharacterMock;


    @Before
    public void inicializa() {
        episodeMock = new Episode();
        locationMock = new Location();
        characterMock = new Character();

        episodeMock.setEpisodeName(EPISODE_NAME);
        locationMock.setDimension(DIMENSION);
        characterMock.setName(CHARACTER_NAME);

    }

    @Test
    public void testEpisodes() throws ExecutionException, InterruptedException, URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/episodes?id=28";
        URI uri = new URI(baseUrl);
        Episode result = restTemplate.getForObject(uri, Episode.class);
        assertNotNull(result);
        assertEquals(episodeMock.getEpisodeName(), result.getEpisodeName());
        assertEquals(characterMock.getName(), result.getCharacters().get(1).getName());
        assertEquals(locationMock.getDimension(), result.getCharacters().get(1).getLocation().getDimension());
    }
}

package com.example.test.repositories;

import com.example.test.entities.EpisodeCharacter;
import com.example.test.entities.EpisodeCharacterPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeCharacterRepository extends JpaRepository<EpisodeCharacter, EpisodeCharacterPk> {
}

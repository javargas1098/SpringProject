package com.example.test.entities;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "episode_characters")
@Data
public class EpisodeCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    EpisodeCharacterPk episodeCharacterPk;
}

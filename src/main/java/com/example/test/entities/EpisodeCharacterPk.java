package com.example.test.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
public class EpisodeCharacterPk implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "episode_id ", insertable = false, updatable = false, nullable = false)
    private Integer episode;

    @Column(name = "character_id", insertable = false, updatable = false, nullable = false)
    private Integer character;

    public EpisodeCharacterPk() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EpisodeCharacterPk)) return false;
        EpisodeCharacterPk that = (EpisodeCharacterPk) o;
        return Objects.equals(episode, that.episode) && Objects.equals(character, that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(episode, character);
    }
}

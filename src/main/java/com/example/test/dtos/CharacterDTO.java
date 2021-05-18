package com.example.test.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CharacterDTO {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private LocationCharacterDTO location;
    private String image;
}

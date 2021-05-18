package com.example.test.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {
    private Integer id;
    private String name;
    private String type;
    private String dimension;
}

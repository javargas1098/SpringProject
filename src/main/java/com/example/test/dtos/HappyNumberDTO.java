package com.example.test.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HappyNumberDTO {
    private Integer number;
    private  Boolean isHappy;
}

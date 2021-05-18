package com.example.test.dtos;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RequestDTO {
    @NotNull(message = "Los lista no puede ser nula")
    List<@Valid Integer> numbers;


}

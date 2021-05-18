package com.example.test.services;

import com.example.test.dtos.RespondSumDTO;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface AdditionService {
    CompletableFuture<ResponseEntity<RespondSumDTO>> calculate(Integer number);
}

package com.example.test.services;

import com.example.test.dtos.HappyNumberDTO;
import com.example.test.dtos.RequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface HappyNumberService {
    CompletableFuture<ResponseEntity<List<HappyNumberDTO>>> calculate(RequestDTO numbers);
}

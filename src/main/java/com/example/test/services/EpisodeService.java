package com.example.test.services;

import com.example.test.entities.Episode;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface EpisodeService {
    CompletableFuture<ResponseEntity<Episode>> consulta(int numero);
}

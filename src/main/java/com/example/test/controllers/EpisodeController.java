package com.example.test.controllers;

import com.example.test.configs.AsyncConfiguration;
import com.example.test.entities.Episode;
import com.example.test.services.impl.EpisodeServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/episodes")
@Api("Episodes Project")
public class EpisodeController {

    private  final EpisodeServiceImpl episodeService;

    public EpisodeController(EpisodeServiceImpl episodeService) {
        this.episodeService = episodeService;
    }

    @Async(value = AsyncConfiguration.NOMBRE_ASINCRONO)
    @GetMapping()
    public CompletableFuture<ResponseEntity<Episode>> getData(@RequestParam Integer id) {

        return episodeService.consulta(id);
    }
}

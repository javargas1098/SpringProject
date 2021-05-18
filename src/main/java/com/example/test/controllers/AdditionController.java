package com.example.test.controllers;

import com.example.test.configs.AsyncConfiguration;
import com.example.test.dtos.RespondSumDTO;
import com.example.test.services.impl.AdditionServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/sums")
@Api("Addition project")
public class AdditionController {

    private final AdditionServiceImpl additionService;

    public AdditionController(AdditionServiceImpl additionService) {
        this.additionService = additionService;
    }

    @Async(value = AsyncConfiguration.NOMBRE_ASINCRONO)
    @GetMapping()
    public CompletableFuture<ResponseEntity<RespondSumDTO>> happy(@RequestParam Integer number) {
        return additionService.calculate(number);
    }
}

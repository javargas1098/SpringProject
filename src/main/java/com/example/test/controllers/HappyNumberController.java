package com.example.test.controllers;

import com.example.test.configs.AsyncConfiguration;
import com.example.test.dtos.RequestDTO;
import com.example.test.dtos.HappyNumberDTO;
import com.example.test.services.impl.HappyNumberServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/numbers")
@Api("Happy Number Project")
public class HappyNumberController {

    private final HappyNumberServiceImpl happynumberservice;

    public HappyNumberController(HappyNumberServiceImpl happynumberservice) {
        this.happynumberservice = happynumberservice;
    }

    @Async(value = AsyncConfiguration.NOMBRE_ASINCRONO)
    @GetMapping()
    public CompletableFuture<ResponseEntity<List<HappyNumberDTO>>> happy(@Valid @RequestBody RequestDTO numbers) {
        return happynumberservice.calculate(numbers);

    }
}

package com.example.test.services.impl;


import com.example.test.dtos.RespondSumDTO;
import com.example.test.services.AdditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AdditionServiceImpl implements AdditionService {

    @Override
    public CompletableFuture<ResponseEntity<RespondSumDTO>> calculate(Integer number) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int sum = 0;
                RespondSumDTO respondSumDTO = new RespondSumDTO();
                for (int i = 0; i <= number; i++) {
                    sum += i;
                    respondSumDTO.setResult(sum);
                }
                return new ResponseEntity<>(respondSumDTO, HttpStatus.OK);
            } catch (Exception e) {

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        });
    }
}

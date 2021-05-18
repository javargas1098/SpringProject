package com.example.test.services.impl;

import com.example.test.dtos.RequestDTO;
import com.example.test.dtos.HappyNumberDTO;
import com.example.test.services.HappyNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
public class HappyNumberServiceImpl implements HappyNumberService {

    private final Set<Integer> set = new HashSet<>();

    @Override
    public CompletableFuture<ResponseEntity<List<HappyNumberDTO>>> calculate(RequestDTO numbers) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<HappyNumberDTO> happyNumberDTOS = new LinkedList<>();
                numbers.getNumbers().forEach(number -> {
                    HappyNumberDTO happyNumberDTO = new HappyNumberDTO();
                    boolean flag = isHappy(number);
                    happyNumberDTO.setNumber(number);
                    happyNumberDTO.setIsHappy(flag);
                    happyNumberDTOS.add(happyNumberDTO);
                });
                return new ResponseEntity<>(happyNumberDTOS, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        });

    }

    private boolean isHappy(int number) {
        if (number == 1)
            return true;
        String cadena = String.valueOf(number);
        int temp = 0;
        for (int i = 0; i <= cadena.length() - 1; i++) {
            // valido que no sea negativo
            temp += Math.pow(cadena.charAt(i) - '0', 2);
        }
        // verificar si entro en un buqle
        if (set.contains(temp))
            return false;
        set.add(temp);
        return isHappy(temp);
    }
}

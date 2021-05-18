package com.example.test.services;

import com.example.test.dtos.RespondSumDTO;
import com.example.test.services.impl.AdditionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AditionServiceTest {
    private static final Integer NUMBER = 7;
    private static final Integer NUMBER2 = 5;
    private static final Integer NUMBER_RTA = 15;
    private static final Integer NUMBER2_RTA2 = 28;

    @InjectMocks
    AdditionServiceImpl additionService;
    RespondSumDTO respondSumDTO;
    RespondSumDTO respondSumDTO2;

    @Before
    public void initialize() {

        respondSumDTO = new RespondSumDTO();
        respondSumDTO2 = new RespondSumDTO();

        respondSumDTO.setResult(NUMBER_RTA);
        respondSumDTO2.setResult(NUMBER2_RTA2);
    }

    @Test
    public void testHappy() throws ExecutionException, InterruptedException {
        CompletableFuture<ResponseEntity<RespondSumDTO>> returned = additionService.calculate(NUMBER);
        CompletableFuture<ResponseEntity<RespondSumDTO>> returned2 = additionService.calculate(NUMBER2);
        assertNotNull(returned);
        assertNotNull(returned2);
        assertEquals(respondSumDTO.getResult(), returned2.get().getBody().getResult());
        assertEquals(respondSumDTO2.getResult(), returned.get().getBody().getResult());

    }
}

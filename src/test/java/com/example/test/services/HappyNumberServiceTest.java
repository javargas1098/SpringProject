package com.example.test.services;


import com.example.test.dtos.HappyNumberDTO;
import com.example.test.dtos.RequestDTO;
import com.example.test.services.impl.HappyNumberServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class HappyNumberServiceTest {

    private static final Integer NUMBER = 7;
    private static final Integer NUMBER2 = 9;

    @InjectMocks
    HappyNumberServiceImpl happyNumberService;
    RequestDTO requestDTO;
    List<HappyNumberDTO> happyNumberDTOsmock;
    HappyNumberDTO happyNumberDTO1mock;
    HappyNumberDTO happyNumberDTO2mock;

    @Before
    public void initialize() {
        happyNumberDTOsmock = new LinkedList<>();
        happyNumberDTO1mock = new HappyNumberDTO();
        happyNumberDTO2mock = new HappyNumberDTO();
        requestDTO = new RequestDTO();
        List<Integer> list = new LinkedList<>();
        list.add(NUMBER);
        list.add(NUMBER2);
        requestDTO.setNumbers(list);
        happyNumberDTO1mock.setNumber(NUMBER);
        happyNumberDTO1mock.setIsHappy(Boolean.TRUE);

        happyNumberDTO2mock.setNumber(NUMBER2);
        happyNumberDTO2mock.setIsHappy(Boolean.FALSE);

        happyNumberDTOsmock.add(happyNumberDTO1mock);
        happyNumberDTOsmock.add(happyNumberDTO2mock);
    }

    @Test
    public void testHappyNumber() throws ExecutionException, InterruptedException {
        CompletableFuture<ResponseEntity<List<HappyNumberDTO>>> returned = happyNumberService.calculate(requestDTO);
        assertNotNull(returned);
        assertEquals(happyNumberDTOsmock.get(0).getNumber(), returned.get().getBody().get(0).getNumber());
        assertEquals(happyNumberDTOsmock.get(0).getIsHappy(), returned.get().getBody().get(0).getIsHappy());
        assertEquals(happyNumberDTOsmock.get(1).getNumber(), returned.get().getBody().get(1).getNumber());
        assertEquals(happyNumberDTOsmock.get(1).getIsHappy(), returned.get().getBody().get(1).getIsHappy());
    }


}

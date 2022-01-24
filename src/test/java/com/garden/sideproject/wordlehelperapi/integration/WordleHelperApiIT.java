package com.garden.sideproject.wordlehelperapi.integration;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordleHelperApiIT extends AbstractIntegarationTest {

    @Test
    void testIsValidWord() {
        stubForIsValidWord();

        //assertEquals(HttpStatus.OK, callIsValidWord().getStatusCode());

        testWordFeignClient();
    }
}

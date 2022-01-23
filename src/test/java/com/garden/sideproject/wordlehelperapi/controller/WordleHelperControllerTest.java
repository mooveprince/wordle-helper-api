package com.garden.sideproject.wordlehelperapi.controller;

import com.garden.sideproject.wordlehelperapi.model.ValidWord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WordleHelperControllerTest {

    @InjectMocks
    private WordleHelperController ctrl;

    @Test
    void testIsValidWord() {
        ResponseEntity<ValidWord> response = ctrl.isValidWord();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
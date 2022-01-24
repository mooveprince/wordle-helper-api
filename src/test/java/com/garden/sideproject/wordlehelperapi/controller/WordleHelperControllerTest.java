package com.garden.sideproject.wordlehelperapi.controller;

import com.garden.sideproject.wordlehelperapi.model.ValidWord;
import com.garden.sideproject.wordlehelperapi.service.WordleHelperService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WordleHelperControllerTest {

    @InjectMocks
    private WordleHelperController ctrl;

    @Mock
    WordleHelperService service;

    @Test
    void testIsValidWord() {

        ValidWord validWord = new ValidWord(true);
        when(service.isValidWord(any(String.class))).thenReturn(validWord);

        ResponseEntity<ValidWord> response = ctrl.isValidWord("TEST");

        assertEquals(validWord, response.getBody());
    }
}
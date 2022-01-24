package com.garden.sideproject.wordlehelperapi.controller;

import com.garden.sideproject.wordlehelperapi.model.ValidWord;
import com.garden.sideproject.wordlehelperapi.service.WordleHelperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WordleHelperController.basePath)
@Slf4j
public class WordleHelperController {

    final static String version = "/v1";
    final static String apiPath = "/wordle-helper/";
    final static String basePath = version + apiPath;

    @Autowired
    private WordleHelperService service;

    @GetMapping("/is-word/{word}")
    public ResponseEntity<ValidWord> isValidWord(@PathVariable String word) {
        log.info("Checking validity for " + word);
        return ResponseEntity.ok(service.isValidWord(word));
    }
}

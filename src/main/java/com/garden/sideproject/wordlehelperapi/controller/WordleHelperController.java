package com.garden.sideproject.wordlehelperapi.controller;

import com.garden.sideproject.wordlehelperapi.model.ValidWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WordleHelperController.basePath)
@Slf4j
public class WordleHelperController {

    final static String version = "/v1";
    final static String apiPath = "/wordle-helper/";
    final static String basePath = version + apiPath;

    @GetMapping("/is-word")
    public ResponseEntity<ValidWord> isValidWord() {
        log.info("Inside the controller");
        return ResponseEntity.ok(ValidWord.builder().valid(false).error(null).build());
    }
}

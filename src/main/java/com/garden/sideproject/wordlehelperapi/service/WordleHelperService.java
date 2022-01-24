package com.garden.sideproject.wordlehelperapi.service;

import com.garden.sideproject.wordlehelperapi.client.WordFeignClient;
import com.garden.sideproject.wordlehelperapi.model.ValidWord;
import com.garden.sideproject.wordlehelperapi.model.WordDefResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WordleHelperService {

    @Autowired
    WordFeignClient client;

    public ValidWord isValidWord (String word) {
        log.info("Make call using feign client for " + word);
        WordDefResponse response = client.isValidWord();

        if (response != null) {
            return ValidWord.builder().valid(true).build();
        }

        return ValidWord.builder().valid(false).build();
    }
}

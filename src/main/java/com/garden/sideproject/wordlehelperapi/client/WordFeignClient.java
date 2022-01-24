package com.garden.sideproject.wordlehelperapi.client;

import com.garden.sideproject.wordlehelperapi.model.WordDefResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="word-api", url="${word.api.url}")
public interface WordFeignClient {

    @RequestMapping(value="/is-valid", method = RequestMethod.GET)
    public WordDefResponse isValidWord();
}

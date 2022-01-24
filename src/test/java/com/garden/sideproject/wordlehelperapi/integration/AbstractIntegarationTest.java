package com.garden.sideproject.wordlehelperapi.integration;

import com.garden.sideproject.wordlehelperapi.client.WordFeignClient;
import com.garden.sideproject.wordlehelperapi.model.ValidWord;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ContextConfiguration(initializers = WireMockInitializer.class)
@AutoConfigureWireMock(port = 0)
@Slf4j
abstract class AbstractIntegarationTest {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    protected TestRestTemplate template;

    @LocalServerPort
    private Integer port;

    @Autowired
    WordFeignClient client;

    protected static String LOCAL_HOST = "http://localhost:";
    protected static String IS_A_WORD_ENDPOINT = "/v1/wordle-helper/is-word/aaaa";
    protected static final String IS_A_VALID_WORD_ENDPOINT = "/is-valid";

    @AfterEach
    public void afterEach() {
        this.wireMockServer.resetAll();
    }

    protected void stubForIsValidWord() {
        log.info("Stub is for " + IS_A_VALID_WORD_ENDPOINT);
        this.wireMockServer.stubFor(
                WireMock.get(WireMock.urlPathMatching(IS_A_VALID_WORD_ENDPOINT))
                        .willReturn(aResponse()
                                .withStatus(HttpStatus.OK.value())
                                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                                .withBodyFile("words/response-for-is-valid-word.json")
                        )
        );
    }

    protected ResponseEntity<ValidWord> callIsValidWord() {
        String url = LOCAL_HOST + port + IS_A_WORD_ENDPOINT;
        log.info("Making request to " + url);
        return template.getForEntity(LOCAL_HOST + port + IS_A_WORD_ENDPOINT, ValidWord.class);
    }

    protected void testWordFeignClient() {
        client.isValidWord();
    }
}

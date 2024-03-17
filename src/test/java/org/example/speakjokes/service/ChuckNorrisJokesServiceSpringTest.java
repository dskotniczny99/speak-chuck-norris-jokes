package org.example.speakjokes.service;

import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ChuckNorrisJokesServiceSpringTest {

    @Autowired
    private ChuckNorrisJokesService chuckNorrisJokesService;


    @Test
    void randomJoke() {

        // given && when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();

        // then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse,"Response is null");
    }

    @Test
    void getResponse() throws IOException {

        // given && when
        String url = "https://api.chucknorris.io/jokes/random";
        final String response = chuckNorrisJokesService.getResponse(url);

        // then
        Assertions.assertNotNull(response, "Response in null");
    }
}
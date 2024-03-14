package org.example.speakjokes.controller;

import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuckNorrisJokesControllerSpringTest {

    @Autowired
    private ChuckNorrisJokesController chuckNorrisJokesController;

    @Test
    void randomJoke() {
        // given && when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesController.randomJoke();

        // then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "Response in null");
    }
}
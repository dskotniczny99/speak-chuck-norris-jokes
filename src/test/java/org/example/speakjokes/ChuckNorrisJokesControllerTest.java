package org.example.speakjokes;

import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.service.ChuckNorrisJokesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChuckNorrisJokesControllerTest {

    @Test
    void randomJoke() {

        // given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();
        ChuckNorrisJokesController chuckNorrisJokesController = new ChuckNorrisJokesController(service);

        // when
        ChuckNorrisJokesApiResponse response = chuckNorrisJokesController.randomJoke();

        // then
        Assertions.assertNotNull(response,"Response in null");
    }
}
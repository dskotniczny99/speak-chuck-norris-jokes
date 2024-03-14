package org.example.speakjokes.service;


import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ChuckNorrisJokesServiceTest {

    @Test
    void run() throws IOException {

        // given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();
        final String url = "https://api.chucknorris.io/jokes/random";

        // when
        final String response = service.getResponse(url);

        // then
        Assertions.assertNotNull(response, "response in null");
    }

    @Test
    void convert() {

        // given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();

        // when
        final ChuckNorrisJokesApiResponse response = service.convert("""
                {
                "icon_url" : "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
                "id" : "DfNJKCAWTV6ARaxCxhkwhg",
                "url" : "",
                "value" : "Chuck Norris can win a gunfight without firing a shot. And without a gun."
                }""".trim());

        // then
        Assertions.assertNotNull(response, "response in null");

    }

    @Test
    void randomJoke() {

        // given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();

        // when
        final ChuckNorrisJokesApiResponse response = service.randomJoke();

        // then
        Assertions.assertNotNull(response, "response in null");

    }
}
package org.example.speakjokes.service;


import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.repository.JokesRepository;
import org.example.speakjokes.repository.entity.JokesEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ChuckNorrisJokesServiceTest {

    @Test
    void run() throws IOException {

        // given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService(null);
        final String url = "https://api.chucknorris.io/jokes/random";

        // when
        final String response = service.getResponse(url);

        // then
        Assertions.assertNotNull(response, "response in null");
    }

    @Test
    void convert() {

        // given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService(null);

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
        final JokesRepository jokesRepository = jokeEntity -> jokeEntity;

        // given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService(jokesRepository);

        // when
        final ChuckNorrisJokesApiResponse response = service.randomJoke();

        // then
        Assertions.assertNotNull(response, "response is null");
        Assertions.assertNotNull(response.getValue(), "joke value is null");
        Assertions.assertFalse(response.getValue().isEmpty(), "joke value is empty");
    }
}
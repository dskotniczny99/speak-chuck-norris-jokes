package org.example.speakjokes.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@AllArgsConstructor
@Slf4j
public class SpeakJokeService {


    private final ChuckNorrisJokesService chuckNorrisJokesService;
    private final VoiceRssService voiceRssService;

    public boolean speakJoke() {
        log.info("speakJoke()");
        final ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        final String joke = chuckNorrisJokesApiResponse.getValue();

        final boolean spoken = voiceRssService.speakJoke(joke);

        log.info("speakJoke(...) = " + spoken);
        return spoken;
    }

}

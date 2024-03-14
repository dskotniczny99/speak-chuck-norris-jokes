package org.example.speakjokes.service;

import lombok.AllArgsConstructor;
import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;

import java.util.logging.Logger;

@AllArgsConstructor
public class SpeakJokeService {

    private final Logger log = Logger.getLogger(SpeakJokeService.class.getName());
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

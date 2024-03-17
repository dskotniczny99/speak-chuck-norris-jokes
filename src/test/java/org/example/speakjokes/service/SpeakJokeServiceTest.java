package org.example.speakjokes.service;

import org.example.speakjokes.repository.JokesRepository;
import org.example.speakjokes.repository.entity.JokesEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeakJokeServiceTest {

    @Test
    void speakJoke() {

        // given
        JokesRepository jokesRepository = jokeEntity -> jokeEntity;
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService(jokesRepository);

        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);

        SpeakJokeService speakJokeService = new SpeakJokeService(chuckNorrisJokesService, voiceRssService);

        // when
        boolean spoken = speakJokeService.speakJoke();

        // then
        Assertions.assertTrue(spoken,"joke not spoken");
    }
}
package org.example.speakjokes.service;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class AudioPlayServiceTest {

    @Test
    void play() {

        // given
        AudioPlayService audioPlayService = new AudioPlayService();
        final InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("test-joke.wav");

        // when
        audioPlayService.play(inputStream);

        // then
    }
}
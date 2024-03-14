package org.example.speakjokes.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class VoiceRssServiceTest {

    @Test
    void speakJoke() throws IOException {

        // given
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService service = new VoiceRssService(audioPlayService);

        // when
        final boolean spoken = service.speakJoke("Hello Java !");

        // then
        Assertions.assertTrue(spoken, "not spoken");

    }
}
package org.example.speakjokes.controller;

import lombok.AllArgsConstructor;
import org.example.speakjokes.service.VoiceRssService;

import java.io.IOException;
import java.util.logging.Logger;

@AllArgsConstructor
public class VoiceRssController {

    private final Logger log = Logger.getLogger(VoiceRssController.class.getName());
    private final VoiceRssService voiceRssService;

    public boolean play(String textToVoice) {
        return voiceRssService.speakJoke(textToVoice);
    }

}

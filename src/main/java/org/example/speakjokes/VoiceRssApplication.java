package org.example.speakjokes;

import org.example.speakjokes.controller.VoiceRssController;
import org.example.speakjokes.service.AudioPlayService;
import org.example.speakjokes.service.VoiceRssService;

import java.io.IOException;

public class VoiceRssApplication {
    public static void main(String[] args) {
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        VoiceRssController voiceRssController = new VoiceRssController(voiceRssService);

        boolean played = voiceRssController.play("Hello joke!");

    }
}

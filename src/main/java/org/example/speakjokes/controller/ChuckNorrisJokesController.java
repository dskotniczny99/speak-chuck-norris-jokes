package org.example.speakjokes.controller;

import lombok.AllArgsConstructor;
import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.service.ChuckNorrisJokesService;
import org.example.speakjokes.service.VoiceRssService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@AllArgsConstructor
@Controller
@RequestMapping("/jokes")
public class ChuckNorrisJokesController {

    private final ChuckNorrisJokesService chuckNorrisJokesService;
    private final VoiceRssService voiceRssService;

    @GetMapping
    public String jokeView() {
        return "jokes";
    }

    @PostMapping
    public String joke(ModelMap modelMap) {
        ChuckNorrisJokesApiResponse apiResponse = chuckNorrisJokesService.randomJoke();
        modelMap.addAttribute("joke", apiResponse.getValue());
        new Thread(() -> voiceRssService.speakJoke(apiResponse.getValue())).start();
        return "jokes";
    }

}

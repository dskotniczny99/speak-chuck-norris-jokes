package org.example.speakjokes.controller;

import lombok.AllArgsConstructor;
import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.service.ChuckNorrisJokesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@AllArgsConstructor
@Controller
@RequestMapping("/jokes")
public class ChuckNorrisJokesController {

    private final ChuckNorrisJokesService chuckNorrisJokesService;


    public ChuckNorrisJokesApiResponse randomJoke() {
        return chuckNorrisJokesService.randomJoke();
    }
}

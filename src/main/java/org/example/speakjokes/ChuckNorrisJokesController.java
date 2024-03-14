package org.example.speakjokes;

import lombok.AllArgsConstructor;
import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.service.ChuckNorrisJokesService;

import java.util.logging.Logger;

@AllArgsConstructor
public class ChuckNorrisJokesController {

    private final Logger log = Logger.getLogger(ChuckNorrisJokesController.class.getName());

    private final ChuckNorrisJokesService chuckNorrisJokesService;

    public ChuckNorrisJokesApiResponse randomJoke() {
        return chuckNorrisJokesService.randomJoke();
    }
}

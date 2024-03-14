package org.example.speakjokes;

import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.controller.ChuckNorrisJokesController;
import org.example.speakjokes.service.ChuckNorrisJokesService;

public class ChuckNorrisJokesApplication {
    public static void main(String[] args) {
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();
        ChuckNorrisJokesController controller = new ChuckNorrisJokesController(service);

        ChuckNorrisJokesApiResponse response = controller.randomJoke();
        String joke = response.getValue();
        // System.out.println(joke);
    }
}

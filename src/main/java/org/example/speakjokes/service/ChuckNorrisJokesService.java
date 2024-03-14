package org.example.speakjokes.service;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChuckNorrisJokesService {

    private static final String API_URL = "https://api.chucknorris.io/jokes/random";
    private final Logger log = Logger.getLogger(ChuckNorrisJokesService.class.getName());
    private final OkHttpClient client = new OkHttpClient();

    public ChuckNorrisJokesApiResponse randomJoke() {
        log.info("Random joke: ");
        try {
            String responseBody = getResponse(API_URL);
            final ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = convert(responseBody);
            log.info("randomJoke: " + chuckNorrisJokesApiResponse);
            return chuckNorrisJokesApiResponse;
        } catch (IOException exception) {
            log.log(Level.SEVERE, "Unable to connect with external server", exception);
        }
        log.info("Random joke: " + null);
        return null;
    }


    public String getResponse(String url) throws IOException {
        log.info("url: " + url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            String body = response.body().string();
            log.info("run: " + body);
            return body;
        }
    }

    public ChuckNorrisJokesApiResponse convert(String body) {
        log.info("convert: " + body);
        Gson gson = new Gson();
        final ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = gson.fromJson(body, ChuckNorrisJokesApiResponse.class);
        log.info("covert: " + chuckNorrisJokesApiResponse);
        return chuckNorrisJokesApiResponse;
    }

}
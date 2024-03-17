package org.example.speakjokes.service;


import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.repository.JokesRepository;
import org.example.speakjokes.repository.entity.JokesEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
@Slf4j

public class ChuckNorrisJokesService {

    private static final String API_URL = "https://api.chucknorris.io/jokes/random";
    private final OkHttpClient client = new OkHttpClient();

    private final JokesRepository jokesRepository;

    public ChuckNorrisJokesApiResponse randomJoke() {
        log.info("Random joke: ");
        try {
            String responseBody = getResponse(API_URL);
            final ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = convert(responseBody);
            String joke = chuckNorrisJokesApiResponse.getValue();
            if (joke.length() > 255) {
                String subJoke = joke.substring(0, 255);
                JokesEntity jokeEntity = new JokesEntity(subJoke);
                jokesRepository.save(jokeEntity);
            }else{
                JokesEntity jokeEntity = new JokesEntity(joke);
                jokesRepository.save(jokeEntity);
            }
            return chuckNorrisJokesApiResponse;
        } catch (IOException exception) {
            log.error("Unable to connect with external server", exception);
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

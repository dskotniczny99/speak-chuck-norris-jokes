package org.example.speakjokes.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;


@Slf4j
public class VoiceRssService {

    private OkHttpClient client;
    private final AudioPlayService audioPlayService;

    public VoiceRssService(AudioPlayService audioPlayService) {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        this.audioPlayService = audioPlayService;
    }

    public boolean speakJoke(String textToSpeak){
        log.info("speakJoke()");

        final HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("api.voicerss.org")
                .addQueryParameter("key", "dab6f65a50944e6ca7e60fe43198e6f6")
                .addQueryParameter("hl", "en-us")
                .addQueryParameter("src", textToSpeak)
                .build();

        final Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            log.info(String.valueOf(response));
            final ResponseBody responseBody = response.body();
            if (responseBody != null) {
                InputStream inputStream = new ByteArrayInputStream(responseBody.bytes());
                audioPlayService.play(inputStream);
                return true;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("speakJoke(...) " + false);
        return false;
    }

}

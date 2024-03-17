package org.example.speakjokes.repository;

import org.example.speakjokes.repository.entity.JokesEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JokesRepositoryTest {

    @Autowired
    private JokesRepository jokesRepository;

    @Test
    void saveJoke() {

        // given && when
        JokesEntity jokeEntity = new JokesEntity();
        JokesEntity savedJokeEntity = jokesRepository.save(jokeEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedJokeEntity,"savedJokeEntity is null"),
                () -> Assertions.assertNotNull(savedJokeEntity.getId(),"savedJokeEntity id is null")

        );
    }
}
package org.example.speakjokes.repository;

import org.example.speakjokes.repository.entity.JokesEntity;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface JokesRepository extends Repository<JokesEntity,Long> {
    JokesEntity save(JokesEntity jokeEntity);
}

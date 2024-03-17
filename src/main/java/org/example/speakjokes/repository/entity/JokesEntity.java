package org.example.speakjokes.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jokes")
public class JokesEntity {

    public JokesEntity(String joke) {
        this.joke = joke;
    }

    public JokesEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String joke;



}

package com.sakila.database.demo.FilmActor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="film_actor")
public class FilmActor {
    //attributes
    @Id
    @Column(name = "actor_id")
    private int actorId;
    @Column(name = "film_id")
    private int filmId;

    //constructor
    public FilmActor() {
    }

    //getters and setters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "filmId=" + filmId +
                ", actorId=" + actorId +
                '}';
    }
}

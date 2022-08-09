package com.sakila.database.demo.Film;

import javax.persistence.*;

/*
    Contains only some columns of film information needed when an actor list contains films they have been in.
 */
@Entity
@Table(name="film")
public class FilmInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")
    private int filmId;

    @Column(name="title")
    private String title;

    @Column(name="release_year")
    private Integer releaseYear;

    //constructors
    public FilmInfo() {
    }

    public FilmInfo(int filmId, String title, Integer releaseYear) {
        this.filmId = filmId;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    //getters and setters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "FilmInfo{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
package com.sakila.database.demo.film;
import javax.persistence.*;

//Contains only some columns of film information needed when an actor list contains films they have been in.
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

    @Column(name="score")
    private Double score;

    @Column(name="score_count")
    private Long scoreCount;

    //constructors
    public FilmInfo() {
        //empty constructor for reading and creating repo
    }

    //getters and setters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(Long scoreCount) {
        this.scoreCount = scoreCount;
    }

    @Override
    public String toString() {
        return "FilmInfo{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", score=" + score +
                ", scoreCount=" + scoreCount +
                '}';
    }
}

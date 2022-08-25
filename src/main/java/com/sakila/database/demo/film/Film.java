package com.sakila.database.demo.film;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sakila.database.demo.actor.Actor;
import com.sakila.database.demo.category.Category;
import com.sakila.database.demo.language.Language;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

//class to deal with the actor objects withdrawn from the actor database.
@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;
    //connect films to actor
    @JsonIgnore
    @ManyToMany(mappedBy = "films")
    List<Actor> actor = new ArrayList<>();
    // Attributes
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="release_year")
    private Integer releaseYear;
    @Column(name="language_id")
    private Integer languageId;
    //join each film to show its language in the film object
    @ManyToOne
    @JoinColumn(name="language_id", nullable=false, insertable = false, updatable = false)
    private Language language;
    @Column(name="rental_duration")
    private Integer rentalDuration;
    @Column(name="rental_rate")
    private BigDecimal rentalRate;
    @Column(name="length")
    private Integer length;
    @Column(name="replacement_cost")
    private BigDecimal replacementCost;
    @Column(name="rating")
    private String rating;
    @Column(name="special_features")
    private String specialFeatures;
    //two new columns to keep track of score and score submitted for a film to work out an average
    @Column(name="score")
    private Double score;
    @Column(name="score_count")
    private Long scoreCount;
    @Column(name="score_total")
    private Long scoreTotal;
    //new columns to keep schedule and how many tickets have been reserved
    @Column(name="tickets_reserved")
    private Integer ticketsReserved;
    //new column for the time of the next showing H:M:S
    @Column(name="next_showing")
    private Time nextShowing;

    //join each film to show its category in the film object
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> filmCategory = new ArrayList<>();

    //empty constructor
    public Film() {
        //empty constructor for reading and creating repo
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public List<Category> getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(List<Category> filmCategory) {
        this.filmCategory = filmCategory;
    }

    public List<Actor> getActor() {
        return actor;
    }

    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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

    public Long getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Long scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public Integer getTicketsReserved() {
        return ticketsReserved;
    }

    public void setTicketsReserved(Integer ticketsReserved) {
        this.ticketsReserved = ticketsReserved;
    }

    public Time getNextShowing() {
        return nextShowing;
    }

    public void setNextShowing(Time nextShowing) {
        this.nextShowing = nextShowing;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", languageId=" + languageId +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating='" + rating + '\'' +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", score=" + score +
                ", scoreCount=" + scoreCount +
                ", scoreTotal=" + scoreTotal +
                ", ticketsReserved=" + ticketsReserved +
                ", nextShowing=" + nextShowing +
                '}';
    }
}

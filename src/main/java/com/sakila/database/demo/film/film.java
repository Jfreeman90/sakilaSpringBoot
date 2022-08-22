package com.sakila.database.demo.film;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sakila.database.demo.category.category;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//class to deal with the actor objects withdrawn from the actor database.
@Entity
@Table(name="film")
public class film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;
    //connect films to actor
    @JsonIgnore
    @ManyToMany(mappedBy = "films")
    List<com.sakila.database.demo.actor.actor> actor = new ArrayList<>();
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
    private com.sakila.database.demo.language.language language;
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

    //join each film to show its category in the film object
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<category> filmCategory = new ArrayList<>();

    //constructor for a film with all values.
    public film(String title, String description, Integer releaseYear,
                Integer languageId, Integer rentalDuration,
                BigDecimal rentalRate, Integer length, BigDecimal replacementCost, String rating,
                String specialFeatures, long scoreTotal, long scoreCount) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.scoreTotal=scoreTotal;
        this.scoreCount=scoreCount;
        this.score= ((double) scoreTotal / scoreCount);
    }

    //empty constructor
    public film() {}

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

    public List<category> getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(List<category> filmCategory) {
        this.filmCategory = filmCategory;
    }

    public List<com.sakila.database.demo.actor.actor> getActor() {
        return actor;
    }

    public void setActor(List<com.sakila.database.demo.actor.actor> actor) {
        this.actor = actor;
    }

    public com.sakila.database.demo.language.language getLanguage() {
        return language;
    }

    public void setLanguage(com.sakila.database.demo.language.language language) {
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

    @Override
    public String toString() {
        return "Film{" +
                "film_id=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating='" + rating + '\'' +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", score=" + score +
                ", scoreCount=" + scoreCount +
                ", scoreTotal=" + scoreTotal +
                '}';
    }
}
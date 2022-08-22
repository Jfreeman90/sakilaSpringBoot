package com.sakila.database.demo.category;
import javax.persistence.*;

@Entity
@Table(name="film_category")
public class filmCategory {
    @Id
    @Column(name = "film_id")
    private int filmId;
    @Column(name="category_id")
    private int categoryId;
    //constructor
    public filmCategory() {}

    //getters and setters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "filmId=" + filmId +
                ", categoryId=" + categoryId +
                '}';
    }
}

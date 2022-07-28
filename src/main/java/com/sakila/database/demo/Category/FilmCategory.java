package com.sakila.database.demo.Category;

import com.sakila.database.demo.Film.Film;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name="film_category")
public class FilmCategory {
    @Id
    @Column(name = "film_id")
    private int filmId;

    @Column(name="category_id")
    private int categoryId;

    public FilmCategory() {}

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

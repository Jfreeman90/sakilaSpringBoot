package com.sakila.database.demo.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sakila.database.demo.film.film;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
public class category {
    //table id found at this particular column
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    //attributes
    @Column(name="name")
    private String name;

    //connect category to films
    @JsonIgnore
    @ManyToMany(mappedBy = "filmCategory")
    List<film> films = new ArrayList<>();

    //empty constructor
    public category() {}

    //constructor to make a new category name
    public category(String name) {
        this.name = name;
    }

    //getters and setters
    public int getCategoryId() {return categoryId;}

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<film> getFilms() {
        return films;
    }

    public void setFilms(List<film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}

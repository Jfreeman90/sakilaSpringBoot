package com.sakila.database.demo.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sakila.database.demo.Film.Film;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
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
    List<Film> films = new ArrayList<>();

    //empty constructor
    public Category() {}

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

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
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

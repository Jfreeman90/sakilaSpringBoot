package com.sakila.database.demo.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sakila.database.demo.film.Film;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    public Category() {
        //empty constructor for reading and creating repo
    }

    //constructor to make a new category name
    public Category(String name) {
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

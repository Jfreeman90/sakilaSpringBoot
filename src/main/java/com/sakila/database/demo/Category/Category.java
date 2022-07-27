package com.sakila.database.demo.Category;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name="category")
public class Category {
    //table id found at this particular column
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    //attributes
    private String name;


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

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.sakila.database.demo.Language;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sakila.database.demo.Film.Film;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="language")
public class Language {
    //table id found at this particular column
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;

    //attributes
    @Column(name="name")
    private String name;


    //Constructor
    public Language() {
    }

    public Language(String name) {
        this.name = name;
    }

    //getters and setters

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", name='" + name + '\'' +
                '}';
    }
}

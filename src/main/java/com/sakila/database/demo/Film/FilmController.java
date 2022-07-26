package com.sakila.database.demo.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/films")
public class FilmController {

    public FilmRepository filmRepository;

    @Autowired
    public void FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
}


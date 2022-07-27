package com.sakila.database.demo.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/films")
public class FilmController {

    //connect the class to the correct table in the database
    public FilmRepository filmRepository;
    @Autowired
    public void FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    //Get request for all films
    @GetMapping("/all")
    public @ResponseBody
    Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    //Get request for a specific film based on the id
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Film> getFilmById(@PathVariable(name="id") int id) {
        return filmRepository.findById(id);
    }


    //Get request for a specific film using a request paramater instead of a fixed url look up.
    @GetMapping("/filmID")
    public @ResponseBody Optional<Film> filmById(@RequestParam int id){
        return filmRepository.findById(id);
    }
}


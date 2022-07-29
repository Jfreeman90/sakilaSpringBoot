package com.sakila.database.demo.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    //get film details from title
    @GetMapping("/film/{title}")
    public @ResponseBody
    List<Film> getFilmByTitle(@PathVariable(name="title") String title){
        return filmRepository.findByTitleIgnoreCase(title);
    }

    //get film details from title
    @GetMapping("/film")
    public @ResponseBody
    List<Film> filmByTitle(@RequestParam String title){
        return filmRepository.findByTitleIgnoreCase(title);
    }

    //get film details from a query that matches a particular string
    @GetMapping("/find_containing")
    public @ResponseBody
    List<Film> findTitlesContaining(@RequestParam String titleString){
        return filmRepository.findByTitleContainingIgnoreCase(titleString);
    }

    /* -------ACTORS ARENT LINKED TO FILMS YET----------
    //get film details from a query that uses an actors first name
    @GetMapping("/film_with_actor_firstname")
    public @ResponseBody
    List<Film> findFilmsWithActorFirstName(@RequestParam String firstname){
        return filmRepository.findByActor_FirstName(firstname);
    }

     */


    // get films by category using request param
    @GetMapping("/get_by_category")
    public @ResponseBody
    List<Film> getFilmsByCategory(@RequestParam String category) {
        return filmRepository.findByFilmCategory_Name(category);
    }

    // get films by category using url entry
    @GetMapping("/category/{category}")
    public @ResponseBody
    List<Film> getFilmsByCategoryUrl(@PathVariable(name="category")  String category) {
        return filmRepository.findByFilmCategory_Name(category);
    }

    // get films by category using request param
    @GetMapping("/get_by_language")
    public @ResponseBody
    List<Film> getFilmsByLanguage(@RequestParam String language) {
        return filmRepository.findByLanguage_Name(language);
    }

    //add film

    //Delete a film from the film table based on id
    @DeleteMapping("/delete/{id}")
    public @ResponseBody
    String deleteActorById(@PathVariable(name="id") int id){
        filmRepository.deleteById(id);
        return "deleted";
    }

    //update film details

}


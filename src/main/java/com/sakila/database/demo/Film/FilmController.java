package com.sakila.database.demo.Film;

import com.sakila.database.demo.Actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    //add a rating score to a film id
    @PatchMapping(path = "/update_score", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Film> updateFilmWithNewScore(@RequestParam int id, @RequestParam long newScore) {
        //check the score submitted is in a valid range of 1-10
        if (newScore>0 && newScore<=10) {
            try {
                Film film = filmRepository.findById(id).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with this id."));
                assert film != null;
                //set new total score for the film
                long newTotal=film.getScoreTotal() + newScore;
                film.setScoreTotal(newTotal);
                //set new total counts
                long newTotalScoresSubmitted=film.getScoreCount() + 1L;
                film.setScoreCount(newTotalScoresSubmitted);
                //set new average rounded to 2.dp.
                double average= (double) (newTotal/newTotalScoresSubmitted);
                film.setScore(Math.round(average* 100.0) / 100.0);
                //save film after all values updates
                return new ResponseEntity<>(filmRepository.save(film), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            //return error score submitted isnt between 1-10
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}


package com.sakila.database.demo.FilmActor;
import com.sakila.database.demo.Category.FilmCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/filmactor")
public class FilmActorController {
    //connect the class to the correct table in the database
    public FilmActorRepository filmActorRepository;
    @Autowired
    public void FilmActorController(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }

    //Get request for all film ids and actor ids
    @GetMapping("/all")
    public @ResponseBody
    Iterable<FilmActor> getAllFilmsAndActor() {
        return filmActorRepository.findAll();
    }


    /*Get request for all films found by an actor id
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<FilmActor> getFilmsByActorId(@PathVariable(name="id") int id) {
        return filmActorRepository.findById(id);
    }

     */

}

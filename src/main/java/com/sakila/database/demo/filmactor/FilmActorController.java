package com.sakila.database.demo.filmactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/filmactor")
public class FilmActorController {
    //connect the class to the correct table in the database
    private FilmActorRepository filmActorRepository;
    @Autowired
    public void filmActorControllerWired(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }
    //Get request for all film ids and actor ids
    @GetMapping("/all")
    public @ResponseBody
    Iterable<FilmActor> getAllFilmsAndActor() {
        return filmActorRepository.findAll();
    }
}

package com.sakila.database.demo.Category;
import com.sakila.database.demo.Film.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/filmcategory")
public class FilmCategoryController {

    //connect the class to the correct table in the database
    public FilmCategoryRepository filmCategoryRepository;
    @Autowired
    public void FilmCategoryController(FilmCategoryRepository filmCategoryRepository) {
        this.filmCategoryRepository = filmCategoryRepository;
    }

    //Get request for all filmids and categories id
    @GetMapping("/all")
    public @ResponseBody
    Iterable<FilmCategory> getAllFilmsAndCats() {
        return filmCategoryRepository.findAll();
    }

    //Get request for a specific film based on the id
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<FilmCategory> getFilmAndCatsById(@PathVariable(name="id") int id) {
        return filmCategoryRepository.findById(id);
    }

    //Get request for a specific film using a request paramater instead of a fixed url look up.
    @GetMapping("/filmID")
    public @ResponseBody Optional<FilmCategory> filmById(@RequestParam int id){
        return filmCategoryRepository.findById(id);
    }


}

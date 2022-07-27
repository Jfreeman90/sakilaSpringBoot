package com.sakila.database.demo.Category;

import com.sakila.database.demo.Film.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/category")
public class CategoryController {
    public CategoryRepository categoryRepository;
    @Autowired
    public void CategoryController(CategoryRepository categoryRepository){this.categoryRepository=categoryRepository;}

    //get all categories
    @GetMapping("/all")
    public @ResponseBody
    Iterable<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    //get a category from its id via a url
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Category> getCategoryById(@PathVariable(name="id") int id) {
        return categoryRepository.findById(id);
    }

    //Get request for a specific film using a request paramater instead of a fixed url look up.
    @GetMapping("/categoryID")
    public @ResponseBody Optional<Category> categoryId(@RequestParam int id){
        return categoryRepository.findById(id);
    }

}

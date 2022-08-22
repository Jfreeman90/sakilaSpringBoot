package com.sakila.database.demo.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/category")
public class categoryController {
    public CategoryRepository categoryRepository;
    @Autowired
    public void categoryControllerWired(CategoryRepository categoryRepository){this.categoryRepository=categoryRepository;}

    //get all categories
    @GetMapping("/all")
    public @ResponseBody
    Iterable<category> getAllCategories(){
        return categoryRepository.findAll();
    }

    //get a category from its id via a url
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<category> getCategoryById(@PathVariable(name="id") int id) {
        return categoryRepository.findById(id);
    }

    //Get request for a specific film using a request paramater instead of a fixed url look up.
    @GetMapping("/categoryID")
    public @ResponseBody
    Optional<category> categoryId(@RequestParam int id){
        return categoryRepository.findById(id);
    }

    //Get request to view specific category by entering category name in the url
    @GetMapping("/cat/{name}")
    public @ResponseBody
    List<category> categoryName(@PathVariable(name="name") String name){
        return categoryRepository.findByName(name);
    }

    //Get request to view specific category by entering category name using req paramters
    @GetMapping("/category")
    public @ResponseBody
    List<category> categoryNameReq(@RequestParam String name){
        return categoryRepository.findByName(name);
    }

    //Post request create a new category and add it to the database
    @PostMapping("/add")
    public @ResponseBody
    String addNewCategory(@RequestParam String name){
        category category = new category(name);
        categoryRepository.save(category);
        return "Saved";
    }

    //Delete a category from the category table based on id
    @DeleteMapping("/delete/id/{id}")
    public @ResponseBody
    String deleteCategoryById(@PathVariable(name="id") int id){
        categoryRepository.deleteById(id);
        return "deleted";
    }

    //update a current category to a new name by using its ID
    @PatchMapping(path = "/update/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<category> updateActorSecondNameReq(@RequestParam int id, @RequestParam String name) {
        try {
            category category = categoryRepository.findById(id).
                    orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Category exists with this id"));
            assert category != null;
            category.setName(name);
            return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

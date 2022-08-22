package com.sakila.database.demo.language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/language")
public class languageController {
    public LanguageRepository languageRepository;
    @Autowired
    public void languageControllerWired(LanguageRepository languageRepository){
        this.languageRepository=languageRepository;
    }
    //get all languages
    @GetMapping("/all")
    public @ResponseBody
    Iterable<language> getAllLanguages(){
        return languageRepository.findAll();
    }
    //get a language from its id via a url
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<language> getLanguageById(@PathVariable(name="id") int id) {
        return languageRepository.findById(id);
    }
    //Get request to view specific category by entering category name using req parameters
    @GetMapping("/language")
    public @ResponseBody
    List<language> languageNameReq(@RequestParam String name) {
        return languageRepository.findByName(name);
    }
    //Post request create a new language and add it to the database with a time stamp
    @PostMapping("/add")
    public @ResponseBody
    String addNewLanguage(@RequestParam String name){
        language language = new language(name);
        languageRepository.save(language);
        return "Saved";
    }
    //Delete a language from the language table based on id
    @DeleteMapping("/delete/id/{id}")
    public @ResponseBody
    String deleteLanguageById(@PathVariable(name="id") int id){
        languageRepository.deleteById(id);
        return "deleted";
    }
}

package com.sakila.database.demo.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/actors")
public class ActorController {

    public ActorRepository actorRepository;

    @Autowired
    public void ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    //Get request for all actors
    @GetMapping("/all")
    public @ResponseBody
    Iterable<Actor> getAllActors() {
        return actorRepository.findAll();
    }


    //Post request to add new actor to the actor table
    @PostMapping("/add/{first_name}_{last_name}")
    public @ResponseBody
    String addNewActor(@PathVariable(name="first_name") String first_name, @PathVariable(name="last_name") String last_name){
        Actor actor = new Actor(first_name, last_name);
        actorRepository.save(actor);
        return "Saved";
    }

    //Get request for a specific actor based on the id
    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Actor> getActorById(@PathVariable(name="id") int id) {
        return actorRepository.findById(id);
    }

    //Get request for a specific actor using a request paramater instead of a fixed url look up.
    @GetMapping("/actorID")
    public @ResponseBody Optional<Actor> actorById(@RequestParam int id){
        return actorRepository.findById(id);
    }

    //Get request to return actor details based on name
    @GetMapping("/firstname/{first_name}")
    public @ResponseBody
    List<Actor> getActorByFirstName(@PathVariable(name="first_name") String firstname) {
        return actorRepository.findByFirstName(firstname.toUpperCase());
    }

    //Delete an actor from the actor table based on id
    @DeleteMapping("/delete/{id}")
    public @ResponseBody
    String deleteActorById(@PathVariable(name="id") int id){
        actorRepository.deleteById(id);
        return "deleted";
    }

    //update actor
}

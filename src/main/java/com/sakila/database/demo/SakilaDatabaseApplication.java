package com.sakila.database.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("sakila")
public class SakilaDatabaseApplication {

	@Autowired
	public ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SakilaDatabaseApplication.class, args);
	}

	public SakilaDatabaseApplication(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	//Post request to add new actor to the actor table
	@PostMapping("/actors/add/{first_name}_{last_name}")
	public @ResponseBody
	String addNewActor(@PathVariable(name="first_name") String first_name, @PathVariable(name="last_name") String last_name){
		Actor actor = new Actor(first_name, last_name);
		actorRepository.save(actor);
		return "Saved";
	}

	//Get request for all actors
	@GetMapping("/actors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	//Get request for a specific actor based on the id
	@GetMapping("/actors/{id}")
	public @ResponseBody
	Optional<Actor> getActorById(@PathVariable(name="id") int id) {
		return actorRepository.findById(id);
	}

	//delete an actor from the actor table based on id
	@DeleteMapping("/actors/delete/{id}")
	public @ResponseBody
	String deleteActorById(@PathVariable(name="id") int id){
		actorRepository.deleteById(id);
		return "deleted";
	}

}

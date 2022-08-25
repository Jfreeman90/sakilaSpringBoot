package com.sakila.database.demo.actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/actors")
public class ActorController {

    private ActorRepository actorRepository;
    @Autowired
    public void actorControllerWired(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    //Get request for all actors
    @GetMapping("/all")
    public @ResponseBody
    Iterable<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    //Post request to add new actor to the actor table
    @PostMapping("/add/{firstName}_{lastName}")
    public @ResponseBody
    String addNewActor(@PathVariable(name="firstName") String firstName, @PathVariable(name="lastName") String lastName){
        Actor actor = new Actor(firstName, lastName);
        actorRepository.save(actor);
        return "Saved";
    }

    //Post request to add new actor to the actor table using request params
    @PostMapping("/add_actor")
    public @ResponseBody
    String addNewActorReq(@RequestParam String firstName, @RequestParam String lastName){
        Actor actor = new Actor(firstName, lastName);
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
    @GetMapping("/firstname/{firstName}")
    public @ResponseBody
    List<Actor> getActorByFirstName(@PathVariable(name="firstName") String firstName) {
        return actorRepository.findByFirstName(firstName.toUpperCase());
    }

    //Get request to return actor details if the first names contain a partial string
    @GetMapping("/firstname_search")
    public @ResponseBody
    List<Actor> getActorByPartialFirstName(@RequestParam String partialFirstName) {
        return actorRepository.findByFirstNameContainingIgnoreCase(partialFirstName);
    }

    //Get request to return actor details if the last names contain a partial string
    @GetMapping("/lastname_search")
    public @ResponseBody
    List<Actor> getActorByPartialLastName(@RequestParam String partialLastName) {
        return actorRepository.findByLastNameContainingIgnoreCase(partialLastName);
    }


    // get actor from first and last name by using the url
    @GetMapping("/name/{firstname}_{lastname}")
    public @ResponseBody
    List<Actor> getActorByFirstLastNameURL(@PathVariable(name="firstname")  String firstname, @PathVariable(name="lastname") String lastname) {
        return actorRepository.findByFirstNameAndLastName(firstname, lastname);
    }

    // get actor from first and last name by using a parameter request
    @GetMapping("/actorname")
    public @ResponseBody
    List<Actor> getActorByFirstLastName(@RequestParam String firstname, @RequestParam String lastname) {
        return actorRepository.findByFirstNameAndLastName(firstname, lastname);
    }

    //get actors that were in a film title
    @GetMapping("/find_actors_in_film")
    public @ResponseBody
    Iterable<Actor> findActorsInFilm(@RequestParam String title){
        return actorRepository.findByFilms_Title(title);
    }

    //get actors that were in a film by id
    @GetMapping("/actors_in_film")
    public @ResponseBody
    Iterable<Actor> findActorsInFilmId(@RequestParam int id){
        return actorRepository.findByFilms_filmId(id);
    }

    //Delete an actor from the actor table based on id
    @DeleteMapping("/delete/{id}")
    public @ResponseBody
    String deleteActorById(@PathVariable(name="id") int id){
        actorRepository.deleteById(id);
        return "deleted";
    }

    private static final String noActorError="No Actor exists with this id.";
    //update actor first name by ID input first name using url
    @PatchMapping(path = "/update/firstname/{id}/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> updateActorFirstName(@PathVariable int id, @PathVariable String firstname) {
        try {
            Actor actor = actorRepository.findById(id).
                                             orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, noActorError));
            assert actor != null;
            actor.setFirstName(firstname);
            return new ResponseEntity<>(actorRepository.save(actor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update actor first name by ID input first name by sending requests params
    @PatchMapping(path = "/update/first_name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> updateActorFirstNameReq(@RequestParam int id, @RequestParam String firstname) {
        try {
            Actor actor = actorRepository.findById(id).
                                            orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, noActorError));
            assert actor != null;
            actor.setFirstName(firstname);
            return new ResponseEntity<>(actorRepository.save(actor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update actor last name by ID input first name using url
    @PatchMapping(path = "/update/lastname/{id}/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> updateActorSecondName(@PathVariable int id, @PathVariable String lastname) {
        try {
            Actor actor = actorRepository.findById(id).
                                             orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, noActorError));
            assert actor != null;
            actor.setLastName(lastname);
            return new ResponseEntity<>(actorRepository.save(actor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update actor last name by ID input first by sending a request with params
    @PatchMapping(path = "/update/last_name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> updateActorSecondNameReq(@RequestParam int id, @RequestParam String lastname) {
        try {
            Actor actor = actorRepository.findById(id).
                                            orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, noActorError));
            assert actor != null;
            actor.setLastName(lastname);
            return new ResponseEntity<>(actorRepository.save(actor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update an actors first and last name by ID using request params
    @PatchMapping(path = "/update/fullname", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> updateActorFullNameReq(@RequestParam int id, @RequestParam String firstname, @RequestParam String lastname) {
        try {
            Actor actor = actorRepository.findById(id).
                                            orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, noActorError));
            assert actor != null;
            actor.setFirstName(firstname);
            actor.setLastName(lastname);
            return new ResponseEntity<>(actorRepository.save(actor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

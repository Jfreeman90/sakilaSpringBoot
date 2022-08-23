package com.sakila.database.demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path="/users")
public class UserController {
    //create object and wire to sql database 'user'
    public UserRepository userRepository;
    @Autowired
    public void userControllerWired(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    //get all of the users details on record
    @GetMapping("/all")
    public @ResponseBody
    Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    //get user from id
    @GetMapping("/id")
    public @ResponseBody UserDTO userById(@RequestParam int id){
        //find the user in the database
        User user = userRepository.findById(id).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No User exists with this id."));
        //create and populate the DTO object with user information
        UserDTO userDto=new UserDTO();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.getActive());
        return userDto;
    }

    //get user from username
    @GetMapping("/user")
    public @ResponseBody User userByUsername(@RequestParam String username){
        //find the user in the database
        return userRepository.findByUsername(username);
    }
    //get user from email
    @GetMapping("/email")
    public @ResponseBody UserDTO userByEmail(@RequestParam String email){
        //find the user in the database
        User user = userRepository.findByEmail(email);
        //create and populate the DTO object with user information
        UserDTO userDto=new UserDTO();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.getActive());
        return userDto;
    }
    //add a new user
    @PostMapping("/add")
    public @ResponseBody
    void addNewUser(@RequestParam String email, @RequestParam String username, @RequestParam String password){
        //logic to check email and username isn't already used
        if (!userRepository.existsByEmail(email) && !userRepository.existsByUsername(username) ) {
            //create and save user because email and username dont already exist
            User user = new User(email, username, password);
            userRepository.save(user);
        }
    }
    //delete a user by user id
    @DeleteMapping("/delete")
    public @ResponseBody
    void deleteUserById(@RequestParam int id){
        userRepository.deleteById(id);
    }

    //update a users password by searching for the username and changing the password
    @PatchMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updatePassword(@RequestParam String username, @RequestParam String newPassW) {
        try {
            User user = userRepository.findByUsername(username);
            assert user != null;
            user.setPassword(newPassW);
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

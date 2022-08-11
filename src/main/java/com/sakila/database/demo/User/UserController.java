package com.sakila.database.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/users")
public class UserController {
    //create object and wire to sql database 'user'
    public UserRepository userRepository;
    @Autowired
    public void UserController(UserRepository userRepository){
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
    public @ResponseBody UserDTO UserById(@RequestParam int id){
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
    public @ResponseBody UserDTO UserByUsername(@RequestParam String username){
        //find the user in the database
        User user = userRepository.findByUsername(username);
        //create and populate the DTO object with user information
        UserDTO userDto=new UserDTO();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.getActive());
        return userDto;
    }

    //get user from email
    @GetMapping("/email")
    public @ResponseBody UserDTO UserByEmail(@RequestParam String email){
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
    String addNewUser(@RequestParam String email, @RequestParam String username, @RequestParam String password){
        //logic to check email and username isn't already used
        if (!userRepository.existsByEmail(email) & !userRepository.existsByUsername(username) ) {
            //create and save user because email and username dont already exist
            User user = new User(email, username, password);
            userRepository.save(user);
        }
        else {
            //username or email already in use so dont create a new user and just return a list of users already in the database
            return "saved";
        }
        //logic to check password passes all rules (length - capitals - symbols)

        return "saved";
    }

    //delete a user by user id
    @DeleteMapping("/delete")
    public @ResponseBody
    String deleteUserById(@RequestParam int id){
        userRepository.deleteById(id);
        return "deleted";
    }
}

package com.sakila.database.demo;

import com.sakila.database.demo.Actor.Actor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorNameStepdefs {
    //create the variables that will be needed to store
    private String firstName;
    private String lastName;
    private Actor actor;

    @Given("the actor name is James Bean")
    public void the_actor_name_is_James_Bean(){
        firstName="JAMES";
        lastName="BEAN";
    }

    @When("I create a new actor called James Bean")
    public void I_create_a_new_actor_called_James_Bean(){
        actor= new Actor(firstName,lastName);
    }

    @Then("I should be get James bean from the getter")
    public void I_should_be_get_James_bean_from_the_getter(){
        assertEquals("JAMES", actor.getFirstName());
        assertEquals("BEAN",actor.getLastName());
    }
}

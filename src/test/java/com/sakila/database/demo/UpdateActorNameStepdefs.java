package com.sakila.database.demo;

import com.sakila.database.demo.actor.Actor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateActorNameStepdefs {
    //create the variables that will be needed
    private Actor jamesBean;
    private Actor richardCrane;

    @Given("the actors original name is James Bean")
    public void the_actors_original_name_is_James_Bean(){
        jamesBean= new Actor("JAMES","BEAN");
    }

    @When ("I change the first name to Harry")
    public void I_change_the_first_name_to_Harry(){
        jamesBean.setFirstName("HARRY");
    }

    @Then("I should be get Harry Bean from the first and last name getter")
    public void I_should_be_get_Harry_Bean_from_the_first_and_last_name_getter(){
        assertEquals("HARRY", jamesBean.getFirstName());
        assertEquals("BEAN",jamesBean.getLastName());
    }

    @Given("the actors original name is Richard Crane")
    public void the_actors_original_name_is_Richard_Crane(){
        richardCrane= new Actor("RICHARD","CRANE");
    }

    @When("I change the second name to Reid")
    public void I_change_the_second_name_to_Reid(){
        richardCrane.setLastName("REID");
    }

    @Then("I should be get Richard Reid from the first and last name getter")
    public void I_should_be_get_Richard_Reid_from_the_first_and_last_name_getter(){
        assertEquals("RICHARD", richardCrane.getFirstName());
        assertEquals("REID",richardCrane.getLastName());
    }


}

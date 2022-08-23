package com.sakila.database.demo;


import com.sakila.database.demo.category.Category;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateCategoryNameStepdefs {
    //create the variables that will be needed
    private Category category;

    @Given("the original category is XXX")
    public void the_original_category_is_XXX(){
        category= new Category("XXX");
    }

    @When("I change the category to Adult")
    public void I_change_the_category_to_Adult(){
        category.setName("Adult");
    }

    @Then("I should be get Adult from the category getter")
    public void I_should_be_get_Adult_from_the_category_getter(){
        assertEquals("Adult", category.getName());
    }
}

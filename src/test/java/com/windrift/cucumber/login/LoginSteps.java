package com.windrift.cucumber.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by gary on 8/09/14.
 */
public class LoginSteps {

    @Given("^a normal user$")
    public void createNormalUser() {
        Assert.assertTrue(true);
    }

    @When("^login$")
    public void login() {
        Assert.assertTrue(true);
    }

    @Then("^should show user detail page$")
    public void showUserDetail() {
        Assert.assertTrue(true);
    }

}

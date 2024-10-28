package com.otmane.Tondeuse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class ValiderLesDirections {

    Boolean directionValid;

    @Given("la direction est {string}")
    public void laDirectionEst(String d) {

        try {
            Direction.valueOf(d);
            directionValid = true;

        } catch (Exception e) {
            directionValid = false;
        }
    }

    @Then("la direction est au status {string}")
    public void laDirectionEstAuStatus(String arg0) {
        Assertions.assertEquals(Boolean.valueOf(arg0), directionValid);
    }


}

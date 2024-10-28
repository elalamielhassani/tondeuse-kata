package com.otmane.Tondeuse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ValidierConfigurationInitialTondeuse {
    Tondeuse tondeuse;
    Position coinSupieur;

    @Given("une tondeuse avec l'id {}")
    public void uneTondeuseAvecLId(String id) {
        tondeuse = new Tondeuse();
        tondeuse.setId(id);
    }

    @When("les coordonnées initiales de la tondeuse sont valid")
    public void lesCoordonneesInitialesDeLaTondeuseSontValid() {
        coinSupieur = new Position();
        coinSupieur.setX(5);
        coinSupieur.setY(5);
        Position positionInitial = new Position();
        positionInitial.setX(2);
        positionInitial.setY(2);
        tondeuse.setPosition(positionInitial);
        Assertions.assertTrue(tondeuse.isPositionValid(coinSupieur));
    }

    @When("les coordonnées initiales de la tondeuse sont invalid")
    public void lesCoordonneesInitialesDeLaTondeuseSontInvalid() {
        coinSupieur = new Position();
        coinSupieur.setX(5);
        coinSupieur.setY(5);
        Position positionInitial = new Position();
        positionInitial.setX(2);
        positionInitial.setY(10);
        tondeuse.setPosition(positionInitial);
        Assertions.assertFalse(tondeuse.isPositionValid(coinSupieur));
    }

    @And("la direction initiale est valid")
    public void laDirectionInitialeEstValid() {
        tondeuse.setDirection(Direction.N);
        Assertions.assertTrue(tondeuse.isDirectionValid());

    }

    @When("la direction initiale est invalid")
    public void la_direction_initiale_est_invalid() {
        Assertions.assertFalse(tondeuse.isDirectionValid());
    }

    @Then("la configuration est valid")
    public void laConfigurationEstValid() {
        Assertions.assertTrue(tondeuse.isInitialConfValid(coinSupieur));
    }

    @Then("la configuration est invalid")
    public void laConfigurationEstInvalid() {
        Assertions.assertFalse(tondeuse.isInitialConfValid(coinSupieur));
    }

}

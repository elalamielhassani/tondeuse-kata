package com.otmane.Tondeuse.features;

import com.otmane.Tondeuse.entities.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class DefinirLaSurfaceDeLaPelouse {
    Position coinSupieur;

    @Given("le coin supérieur est en x={int} et y={int}")
    public void leCoinSuperieurEstEnXEtY(int x, int y) {
        coinSupieur = new Position();
        coinSupieur.setX(x);
        coinSupieur.setY(y);
    }

    @Then("la position est valid")
    public void laPositionEstValid() {
        Assertions.assertTrue(coinSupieur.isValid());
    }

    @Then("la position est invalid")
    public void la_position_est_invalid() {
        Assertions.assertFalse(coinSupieur.isValid());
    }

}

package com.otmane.Tondeuse.features;

import com.otmane.Tondeuse.entities.Tondeuse;
import com.otmane.Tondeuse.enums.Commande;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ValiderLeComportementDesListesDeCommandes {
    Tondeuse tondeuse;
    String commande;


    @Given("La file de commande est vide")
    public void laFileDeCommandeEstVide() {
        tondeuse = new Tondeuse();
    }

    @When("j'ajoute {string} dans la file")
    public void jAjouteDansLaFile(String commande) {
        Commande commande1 = Commande.valueOf(commande);
        tondeuse.getCommandes().add(commande1);

    }

    @Then("la file contient {int} éléments")
    public void laFileContientElements(int arg0) {
        Assertions.assertEquals(arg0, tondeuse.getCommandes().size());
    }

    @When("je retire un élément de la file")
    public void jeRetireUnElementDeLaFile() {
        commande = tondeuse.getCommandes().poll().name();
    }

    @Then("l'élément retiré est {string}")
    public void lElementRetireEst(String arg0) {
        Assertions.assertEquals(arg0, commande);

    }

    @And("le premier élément de la file est {string}")
    public void lePremierElementDeLaFileEst(String arg0) {
        Assertions.assertEquals(arg0, tondeuse.getCommandes().element().name());
    }

    @Then("la file est vide")
    public void laFileEstVide() {
        Assertions.assertEquals(0, tondeuse.getCommandes().size());
    }
}

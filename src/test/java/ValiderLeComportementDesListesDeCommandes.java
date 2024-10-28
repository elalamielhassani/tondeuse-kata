import com.otmane.Tondeuse.Tondeuse;
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
        tondeuse.getCommandes().add(commande);

    }

    @Then("la file contient {int} éléments")
    public void laFileContientElements(int arg0) {
        Assertions.assertEquals(arg0, tondeuse.getCommandes().size());
    }

    @When("je retire un élément de la file")
    public void jeRetireUnElementDeLaFile() {
        commande = tondeuse.getCommandes().poll();
    }

    @Then("l'élément retiré est {string}")
    public void lElementRetireEst(String arg0) {
        Assertions.assertEquals(arg0, commande);

    }

    @And("le premier élément de la file est {string}")
    public void lePremierElementDeLaFileEst(String arg0) {
        Assertions.assertEquals(arg0, tondeuse.getCommandes().element());
    }

    @Then("la file est vide")
    public void laFileEstVide() {
        Assertions.assertEquals(0, tondeuse.getCommandes().size());
    }
}

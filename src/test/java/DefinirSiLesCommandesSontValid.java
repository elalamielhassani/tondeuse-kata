import com.otmane.Tondeuse.enums.Commande;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class DefinirSiLesCommandesSontValid {

    Boolean isValid;

    @Given("la commande est {string}")
    public void laCommandeEst(String valeur) {
        try {
            Commande.valueOf(valeur);
            isValid = true;

        } catch (Exception e) {
            isValid = false;
        }
    }

    @Then("la commande est au status {string}")
    public void laCommandeEstAuStatus(String status) {
        Assertions.assertEquals(Boolean.valueOf(status), isValid);
    }
}

import com.otmane.Tondeuse.Position;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DefinirLaSurfaceDeLaPelouse {
    Position coinSupieur;

    @When("le coin supérieur est en x={int} et y={int}")
    public void leCoinSupérieurEstEnXEtY(int x, int y) {
        coinSupieur = new Position();
        coinSupieur.setX(x);
        coinSupieur.setY(y);

    }

    @Then("les coordonées du coin supérieur droit sont valid")
    public void lesCoordonéesDuCoinSupérieurDroitSontValid() {
        Assertions.assertTrue(coinSupieur.isValid());
    }

    @Then("les coordonées du coin supérieur droit sont invalid")
    public void lesCoordonéesDuCoinSupérieurDroitSontInvalid() {
        Assertions.assertFalse(coinSupieur.isValid());
    }
}

import com.otmane.Tondeuse.enums.Commande;
import com.otmane.Tondeuse.enums.Direction;
import com.otmane.Tondeuse.Position;
import com.otmane.Tondeuse.Tondeuse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DeplacementDeLaTandeuse {
    Tondeuse tondeuse;
    @Given("la tondeuse est orientée vers {string}")
    public void laTondeuseEstOrienteeVers(String arg0) {
        tondeuse =  new Tondeuse();
        tondeuse.setDirection(Direction.valueOf(arg0));
    }

    @When("la tondeuse reçoit la commande {string}")
    public void laTondeuseRecoitLaCommande(String arg0) {
        Commande commande = Commande.valueOf(arg0);
        tondeuse.apply(commande);
    }

    @Then("la nouvelle orientation de la tondeuse est {string}")
    public void laNouvelleOrientationDeLaTondeuseEst(String arg0) {
        Assertions.assertEquals(Direction.valueOf(arg0), tondeuse.getDirection());

    }

    @And("la position de la tondeuse est en x={int} et y={int}")
    public void laPositionDeLaTondeuseEstEnXEtY(int x, int y) {
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        tondeuse.setPosition(position);
    }

    @And("la nouvelle position de la tondeuse est x={int} et y={int}")
    public void laNouvellePositionDeLaTondeuseEstXEtY(int x, int y) {
        Assertions.assertEquals(x, tondeuse.getPosition().getX());
        Assertions.assertEquals(y, tondeuse.getPosition().getY());
    }
}

package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static junit.framework.TestCase.assertTrue;

public class BombermanSteps {
    @Then("^I am a bomberman$")
    public void iAmABomberman() {
        assertTrue(true);
    }
}

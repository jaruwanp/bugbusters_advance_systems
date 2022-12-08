package step_definitions;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import utils.BrowserUtils;
import utils.CucumberLogUtils;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        BrowserUtils.getDriver();
        CucumberLogUtils.initScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        CucumberLogUtils.logFail("Scenario failed", true);
        BrowserUtils.quitDriver();
    }
}

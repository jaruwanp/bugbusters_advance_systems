package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.Map;


public class HomeSteps implements CommonPage {
    HomePage page;

    public HomeSteps() {
        page = new HomePage();

    }

    @Given("I open url of homepage")
    public void i_open_url_of_homepage() {
        BrowserUtils.getDriver();
    }


    @Then("Verify title of the homepage should be {string}")
    public void verifyHeaderTextIs(String headerTitle) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), headerTitle);
    }

//--------------------------------

    @When("I click menu {string}")
    public void iClickMenu(String menuBtn) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT,menuBtn))
        ));
    }
    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT,button)))
        );
    }

    @Then("I Verify button {string} is enabled")
    public void iVerifyButtonIsEnabled(String button) {
        BrowserUtils.isEnabled(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT,button)))
        );
    }

    @When("I click  {string}")
    public void iClick(String langMenuBtn) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT,langMenuBtn)))
        );
    }

    @Then("Verify button {string} is enabled")
    public void verifyButtonIsEnabled(String langBtn) {
        BrowserUtils.isEnabled(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT,langBtn)))
        );
    }


    @When("I click button {string}")
    public void iClickButton(String button) {
        BrowserUtils.click(page.langBtn);
    }

    @When("I click button English")
    public void iClickButtonEnglish() {
        BrowserUtils.click(page.langBtn);
    }

    @When("I click top menu {string}")
    public void iClickTopMenu(String navMenuBtn) {
        WebElement element;

    }
}

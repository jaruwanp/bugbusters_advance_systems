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


    @Then("Verify button {string} is display")
    public void verifyButtonIsDisplay(String navTopBtn) {
        WebElement element = null;

        switch (navTopBtn){
            case "English":
            case"Spanish":
            case"French":
                element = page.langBtn;
                BrowserUtils.click(element);
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_LINKTEXT,navTopBtn).isDisplayed());
                break;
            default:
                element = BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS,navTopBtn)));
                BrowserUtils.assertTrue(BrowserUtils.isDisplayed(element));
                break;
        }
    }
    @Then("Verify button {string} is enable")
    public void verifyButtonIsEnable(String navBtn) {
        WebElement elelment;
        switch (navBtn) {
            case "English":
            case "Spanish":
            case "French":
                elelment = page.langBtn;
                BrowserUtils.click(elelment);
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_LINKTEXT, navBtn).isEnabled());
                break;
            default:
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_LINKTEXT, navBtn).isEnabled());
        }
    }

    @When("I click top menu {string}")
    public void iClickTopMenu(String navMenuBtn) {
        WebElement element;

    }
}


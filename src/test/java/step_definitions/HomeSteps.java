package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

public class HomeSteps implements CommonPage {
    HomePage page;
    public HomeSteps() {
        page = new HomePage();

    }
    @Given("I open url of homepage")
    public void iOpenUrlOfHomepage() {
        BrowserUtils.getDriver();
    }

    @Then("Verify header text is {string}")
    public void verifyHeaderTextIs(String headerTxt) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), headerTxt);
    }

    @Then("Verify {string} is displayed")
    public void verifyIsDisplayed(String text) {
        WebElement element;

        switch (text) {
            case "https://facebook.com":
            case "https://twitter.com":
            case "https://skype.com":
            case "https://linkedin.com":
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_FOOTERLINKHREF, text).isDisplayed());
                break;
            default:
                element = getElementByXpath(XPATH_TEMPLATE_TEXT_CONTAINS, text);
                BrowserUtils.assertTrue(BrowserUtils.isDisplayed(element));
                break;
        }
    }

    @And("Verify {string} matches to related {string}")
    public void verifyMatchesToRelated(String button, String url) {
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_FOOTERLINKHREF, button));
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }
}

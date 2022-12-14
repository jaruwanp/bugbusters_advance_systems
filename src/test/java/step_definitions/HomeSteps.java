package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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

    @Then("Verify address line one is {string}")
    public void verify_address_line_one_is(String addressOne) {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.addressLineOne), addressOne);
    }
    @Then("Verify address line two is {string}")
    public void verify_address_line_two_is(String addressTwo) {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.addressLineTwo), addressTwo);
    }
    @Then("Verify phone number is {string}")
    public void verify_phone_number_is(String phone) {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.phoneNumber), phone);
    }
    @Then("Verify social media button {string} is displayed")
    public void verify_social_media_button_is_displayed(String socialBtns) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_HREF, socialBtns)
        )));
    }
    @When("When I click {string}")
    public void whenIClick(String icon) {
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_HREF, icon));
    }
    @Then("Verify destination of related social media has URL as {string}")
    public void verifyDestinationOfRelatedSocialMediaHasURLAs(String url) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }
    @Then("Verify {string} is displayed")
    public void verify_is_displayed(String joinNow) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_HREF,joinNow)
        )));
    }
    @Then("Verify {string} is enable")
    public void verify_is_enable(String joinNow) {
        BrowserUtils.isEnabled(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_HREF,joinNow)
        )));
    }
    @When("I click {string}")
    public void i_click(String joinNow) {
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_HREF,joinNow));
    }
    @Then("Verify destination window has URL as {string}")
    public void verify_destination_window_has_url_as(String url) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }
}

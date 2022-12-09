package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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


}

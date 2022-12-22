package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import pages.DivisionPage;
import utils.BrowserUtils;
import utils.CucumberLogUtils;

public class DivisionSteps {
    DivisionPage page = new DivisionPage();
    @Then("verify address and phone number are displayed")
    public void verifyAddressAndPhoneNumberAreDisplayed() {
        BrowserUtils.isDisplayed(page.divisionAddress);
        BrowserUtils.isDisplayed(page.divisionPhone);
        JavascriptExecutor js = (JavascriptExecutor) (BrowserUtils.getDriver());
        js.executeScript("window.scrollBy(100,-300)");
        CucumberLogUtils.logInfo("\n" + page.divisionAddress.getText() + "\n" +
                "Phone Number: " + page.divisionPhone.getText(), true);

    }
}

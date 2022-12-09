package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.GeneralNavBarPage;
import pages.HomePage;
import utils.BrowserUtils;

public class GeneralNavBarSteps implements CommonPage {

    GeneralNavBarPage page;
    public GeneralNavBarSteps() {page = new GeneralNavBarPage(); }


    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT,button)))
        );
    }
}

//    HomePage page;
//    public HomeSteps() {
//        page = new HomePage();
//    }

//    @Then("Verify button {string} is displayed")
//    public void verifyButtonIsDisplayed(String arg0) {
//    }

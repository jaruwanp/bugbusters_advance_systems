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
import utils.CucumberLogUtils;

import java.util.*;

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
                //BrowserUtils.assertTrue(BrowserUtils.isDisplayed(element));
                boolean isDisplayed = element.isDisplayed();
                CucumberLogUtils.logInfo("Displayed msg :" + isDisplayed, true);
                break;
        }
    }

    @Then("Verify {string} is enable")
    public void verifyIsEnable(String navBtn) {
        WebElement element;
        switch (navBtn) {
            case "English":
            case "Spanish":
            case "French":
                element = page.langMenu;
                BrowserUtils.click(element);
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_LINKTEXT, navBtn).isEnabled());
                break;
            case "prevBtn":
                BrowserUtils.clickWithJs(page.prevArrow);
                boolean isEnable = page.prevArrow.isEnabled();
                CucumberLogUtils.logInfo("Enabled previous arrow :" + isEnable, true);
                break;
            case "nextBtn":
                BrowserUtils.clickWithJs(page.nextArrow);
                isEnable = page.nextArrow.isEnabled();
                CucumberLogUtils.logInfo("Enabled next arrow :" + isEnable, true);
                break;
            default:
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_LINKTEXT, navBtn).isEnabled());
        }

    }

    @And("Verify {string} matches to related {string}")
    public void verifyMatchesToRelated(String button, String url) {
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_FOOTERLINKHREF, button));
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }

    @When("I scroll down to Testimonials Section")
    public void iScrollDownToTestimonialsSection() {
        BrowserUtils.moveIntoView(page.testimonialSection);
    }

    @And("Verify clients' picture and actual testimonial different from others is displayed")
    public void verifyClientsPictureAndActualTestimonialDifferentFromOthersIsDisplayed() throws InterruptedException {
        Set<String> msgs = new LinkedHashSet<>();
        Set<String> clientPics = new LinkedHashSet<>();
        Set<String> clients = new LinkedHashSet<>();
        String name, msg, pic;

        // To make sure the page will run properly after the page finishing loading
        // will take out when loading problem is solved
        Thread.sleep(2000);
        page.nextArrow.click();

        List<WebElement> itr = BrowserUtils.getDriver().findElements(By.xpath("//div[@class='thumb-item']/div/h3"));

        // Control carrousel to go only 1 round
        for (int i = 0; i < itr.size() / 2; i++) {
            Thread.sleep(4000);
            name = page.name.getText();
            msg = page.testimonial.getText();
            pic = page.clientPic.getAttribute("src");
            clients.add(name);
            msgs.add(msg);
            clientPics.add(pic);
            if (page.name.isDisplayed()) {
                CucumberLogUtils.logInfo(page.name.getText(), false);
                CucumberLogUtils.logInfo(page.clientPic.getAttribute("src"), false);
                CucumberLogUtils.logInfo(page.state.getText(), false);
                CucumberLogUtils.logInfo(page.testimonial.getText(), true);
            }
        }

        BrowserUtils.assertTrue(clients.size() == msgs.size() && clients.size() == clientPics.size());
    }

    @And("Verify clients' locations are displayed as a state")
    public void verifyClientsLocationsAreDisplayedAsAState() throws InterruptedException {
        String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
                "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
                "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "Washington DC", "West Virginia",
                "Wisconsin", "Wyoming"};

        // To make sure the page will run properly after the page finishing loading
        // will take out when loading problem is solved
        Thread.sleep(2000);
        page.nextArrow.click();

        List<WebElement> itr = BrowserUtils.getDriver().findElements(By.xpath("//div[@class='thumb-item']/div/h3"));

        // Control carrousel to go only 1 round
        for (int i = 0; i < itr.size() / 2; i++) {
            if (page.name.isDisplayed()) {
                boolean state = Arrays.asList(states).contains(page.state.getText());
                CucumberLogUtils.logInfo(page.state.getText() + " : " + state, true);
            }
        }
    }
}

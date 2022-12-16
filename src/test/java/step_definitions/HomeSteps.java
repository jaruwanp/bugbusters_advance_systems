package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            case "prevBtn":
                BrowserUtils.clickWithJs(page.prevArrow);
                BrowserUtils.assertTrue(BrowserUtils.isEnabled(page.prevArrow));
                break;
            case "nextBtn":
                BrowserUtils.clickWithJs(page.nextArrow);
                BrowserUtils.assertTrue(BrowserUtils.isEnabled(page.nextArrow));
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

    @When("I scroll down to Testimonials Section")
    public void iScrollDownToTestimonialsSection() {
        BrowserUtils.moveIntoView(page.testimonialSection);
    }

    @And("Verify following clients' picture and actual testimonial different from others is displayed")
    public void verifyFollowingClientsPictureAndActualTestimonialDifferentFromOthersIsDisplayed(List<String> clients) throws InterruptedException {
        Set<String> msgs = new HashSet<>();
        Set<String> clientPics = new HashSet<>();

        for (String e : clients) {
            Thread.sleep(5000);
            getElementByXpath(XPATH_TEMPLATE_TEXT, e).isDisplayed();
            msgs.add(BrowserUtils.getText(page.testimonial));
            clientPics.add(page.clientPic.getAttribute("src"));
        }
        System.out.println(msgs.size());
        System.out.println(clientPics.size());

        BrowserUtils.assertTrue(clients.size() == msgs.size());
        BrowserUtils.assertTrue(clients.size() == clientPics.size());

    }

    @And("Verify following clients' location is displayed as a state")
    public void verifyFollowingClientsLocationIsDisplayedAsAState(List<String> clients) throws InterruptedException {
        String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
                "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
                "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "Washington DC", "West Virginia",
                "Wisconsin", "Wyoming"};
        for (String e : clients) {
            Thread.sleep(5000);
            getElementByXpath(XPATH_TEMPLATE_TEXT, e).isDisplayed();
            BrowserUtils.assertTrue(Arrays.asList(states).contains(page.state.getText()));
        }
    }
}

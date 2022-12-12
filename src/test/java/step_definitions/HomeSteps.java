package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.CucumberLogUtils;

import java.util.List;
import java.util.Map;


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
    public void verifyIsDisplayed(String txt) {
        WebElement element = null;

        switch (txt) {
            case "10090 Main Street Fairfax, VA, USA":
                element = page.address;
                BrowserUtils.assertTrue(BrowserUtils.isDisplayed(element));
                break;
            case "English":
            case "Spanish":
            case "French":
                element = page.langMenu;
                BrowserUtils.click(element);
                BrowserUtils.assertEquals(getElementByXpath(XPATH_TEMPLATE_LINKTEXT, txt).getText(), txt);
                break;
            case "Address: 10090 Main St, Fairfax, VA":
            case "Phone: +1 703-831-3217":
            case "Email: Info@advancesystems.us":
            case "Mon to Sat: 9.00 am to 5:00 pm":
                element = page.contactInfo;
                BrowserUtils.assertTrue((BrowserUtils.isDisplayed(element)));
                break;
            case "Leadership Development":
            case "Capability Building":
            case "Rewards & Benefits":
            case "Employee & Employer Relations":
            case "Excellent Customer Service":
                break;
            case "Join Now":
                element = page.joinNow;
                BrowserUtils.assertTrue(BrowserUtils.isDisplayed(element));
                break;
            case "Home":
            case "About Us":
            case "Services":
            case "Clients":
            case "Join Us":
            case "Contact Us":
                element = page.navBar2;
                BrowserUtils.assertTrue(BrowserUtils.isDisplayed(element));
                break;
            case "https://facebook.com":
            case "https://twitter.com":
            case "https://skype.com":
            case "https://linkedin.com":
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_FOOTERLINKHREF, txt).isDisplayed());
                break;
            default:
                element = BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, txt)));
                BrowserUtils.assertTrue(BrowserUtils.isDisplayed(element));
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
            case "Join Now":
                element = page.joinNow;
                BrowserUtils.click(element);
                break;
            default:
                BrowserUtils.assertTrue(getElementByXpath(XPATH_TEMPLATE_LINKTEXT, navBtn).isEnabled());
        }
    }

//    @Then("Verify webpage navigate to url page")
//    public void verifyWebpageNavigateToUrlPage() {
//        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(),
//                "https://tla-batch-6.github.io/advance-systems-test-b6/joinUs.html");
//
//    }

    @Then("Verify destination window as url as {string}")
    public void verifyDestinationWindowAsUrlAs(String url) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }

//    @When("I scroll down")
//    public void iScrollDown() {
//        Actions a = new Actions(BrowserUtils.getDriver());
//        for (int i = 0; i < 7 ; i++) {
//            a.sendKeys(Keys.PAGE_DOWN)  ;
//        }
//        a.build().perform();
    //   }

    @Then("verify {string} is displayed when scroll down")
    public void verifyIsDisplayedWhenScrollDown(String navBar2) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.getDriver(); // jsexecutor is for behavior of mouse and keyboard
        js.executeScript("window.scrollBy(0,1000)");
        BrowserUtils.isDisplayed(getElementByXpath(XPATH_TEMPLATE_NAV_LINK_TEXT, navBar2));
    }

    @Then("Verify {string} navigate to window as url as {string}")
    public void verifyNavigateToWindowAsUrlAs(String navBar2, String url) {
        // BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_NAV_LINK_TEXT, navBar2)))); >> long version of line below
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_NAV_LINK_TEXT, navBar2)); // commonPage template
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }

    @Then("Verify {string} icon is displayed")
    public void verifyIconIsDisplayed(String socialMediaTop) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_HREF, socialMediaTop)
        )));
    }

    @When("I click {string}")
    public void iClick(String link) {
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_HREF, link));
    }

    @And("Verify {string} link to window as url as {string}")
    public void verifyLinkToWindowAsUrlAs(String socialMediaBtn, String url) {
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_FOOTERLINKHREF, socialMediaBtn));
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }

    @And("Verify {string} direct to window as url as {string}")
    public void verifyDirectToWindowAsUrlAs(String socialMediaTop, String url) {
        BrowserUtils.click(getElementByXpath(XPATH_TEMPLATE_HREF, socialMediaTop));
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), url);
    }
    //------------------- Jaruwan -------------------
    @Then("Verify the content in the Parallax will be dynamically changed every {string} seconds")
    public void verifyTheContentInTheParallaxWillBeDynamicallyChangedEvery(String second) throws InterruptedException {
        int sec = Integer.valueOf(second);
        String path,content1,content2;
        path="//div[@id='rev_slider_one']";

        int refresh_in_millis = sec * 1000;
        Thread.sleep(2000);

        System.out.println(sec);
        Thread.sleep(refresh_in_millis);

        content1 = BrowserUtils.getDriver().findElement(By.xpath(path)).getText();
        //System.out.println("content1=" + content1);
        //writeElementInfo(driver.findElement(By.xpath(path)));


        Thread.sleep(refresh_in_millis);
        content2 = BrowserUtils.getDriver().findElement(By.xpath(path)).getText();
        System.out.println("content2=" + content2);
        Thread.sleep(1000);
        CucumberLogUtils.logInfo("Refresh : " + second + " seconds",false);
        CucumberLogUtils.logInfo("Content(1) :" + content1,true);

        CucumberLogUtils.logInfo("Content(2) :" + content2,true);

        BrowserUtils.assertFalse(content1.equals(content2));

    }

    @When("I click a button {string}")
    public void iClickAButton(String button) {
        WebElement element;
        switch (button) {
            case "NUll":
                element=null;
                break;
            default:
                element = getElementByXpath(XPATH_TEMPLATE_BUTTON, button);
        }
        BrowserUtils.click(element);
    }


    @And("I click a LinkText {string}")
    public void iClickALinkText(String button) {
        CucumberLogUtils.logInfo("Clicked button : " + button, false);
        //System.out.println("==>" +button);
        switch (button){
            case "Read More(1)":
                page.btnReadMore1.click();
                break;
            case "Read More(2)":
                page.btnReadMore2.click();
                break;
            default:
                getElementByXpath(XPATH_TEMPLATE_LINKTEXT,button).click();
        }

    }

    @Then("Verify that the button will take user to {string} Page")
    public void verifyThatTheButtonWillTakeUserToPage(String pageName) {

        BrowserUtils.assertTrue(BrowserUtils.getDriver().getTitle().toLowerCase().contains(pageName.toLowerCase()));
    }

    @And("I wait for a header {string} to be presented")
    public void iWaitForAHeaderToPresent(String header) {

        String path = "//h2[normalize-space()='" + header.replace(" - ","")+ "']";
        CucumberLogUtils.logInfo("Wait for visibility of header : " + header + "<br>" + path, false);
        //  System.out.println(path);
        WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(),50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

    }

    @When("I scroll down to the footer of the homepage")
    public void iScrollDownToTheFooterOfTheHomepage() {

        BrowserUtils.moveIntoView(page.webFooter);
        BrowserUtils.sleep(1000);

    }


    @Then("Verify the following links that will contain its title")
    public void verifyTheFollowingLinksWillTakeUserToCorrespondingPagesThatContainsItSTitle(Map<String,String> map) {

        String title,expectTitle;
        Boolean result=false;
        for (String key:map.keySet()){
            page.getQuickLinkText(key).click();
            title = BrowserUtils.getDriver().getTitle();
            expectTitle = map.get(key);
            result =  title.toLowerCase().contains(expectTitle.toLowerCase());
            CucumberLogUtils.logInfo("Result=" + result + ", Link Text: " + key + " | Expect title contains : " + expectTitle + " | Actual Title: " + title,false);
            Assert.assertTrue(result);

            // BrowserUtils.assertTrue(title.toLowerCase().contains(expectTitle.toLowerCase()));
            BrowserUtils.getDriver().get(ConfigReader.readProperty("url"));
            BrowserUtils.moveIntoView(page.webFooter);

        }

    }

    @Then("Verify that the list of the following company names display in one row")
    public void verifyThatTheListOfTheFollowingCompanyNamesDisplayInOneRow(Map<String,String> map) {
        String imgUrl;

        for (String key: map.keySet()){
            imgUrl = map.get(key);
            CucumberLogUtils.logInfo("Company: " + key + ", img=" + imgUrl,false);
            Assert.assertTrue(page.getCompanyImage(imgUrl).size() >0);
        }

    }

    @When("I scroll down to the section {string}")
    public void iScrollDownToTheSection(String headerText) {
        BrowserUtils.moveIntoView(BrowserUtils.getDriver().findElement(By.xpath("//h2[text()='" + headerText+ "']")));
    }

    @Then("Verify the {string} displayed above the picture of the writer {string}")
    public void verifyTheDisplayedAboveThePictureOfTheWriter(String message, String person) {
    }

//------------------- End of Jaruwan -------------------
}



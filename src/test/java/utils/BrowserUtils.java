package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    private BrowserUtils() {

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver("chrome");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static void initializeDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigReader.readProperty("url"));
    }

    public static void waitForElementClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForTxtToBePresent(WebElement element, String txt) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(element, txt));
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void moveIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);", element);
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 2; i++) {
            try {
                if (i % 2 == 0) {
                    js.executeScript("argument[0].setAttribute('style', argument[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                    //TODO: apply report screenshot here
                    CucumberLogUtils.logInfo(element.toString(),Boolean.getBoolean(ConfigReader.readProperty("takeScreenshot")));
                } else {
                    sleep(600);
                    js.executeScript("argument[0].setAttibute('style', argument[1]);", element, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendKeys(WebElement element, String inputText) {
        //TODO: apply report -> logInfo("Entered the text ", element);
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        element.sendKeys(inputText);
    }

    public static String getText(WebElement element) {
        //TODO: apply report -> logInfo("Retrieved the text ", element);
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        return element.getText();
    }

    public static void click(WebElement element) {
        //TODO: apply report -> logInfo("clicked the button ", element);
        waitForElementClickability(element);
        moveIntoView(element);
        highlightElement(element);
        element.click();
    }

    public static void assertEquals(String actual, String expected) {
        //TODO: apply report -> logInfo("Expected: " + expected);
        //TODO: apply report -> logInfo("Actual: " + actual);
        Assert.assertEquals(expected, actual);
    }

    public static void assertFalse(boolean result) {
        //TODO: apply report -> logInfo("Expected: " + result);
        Assert.assertFalse(result);
    }

    public static void assertTrue(boolean result) {
        //TODO: apply report -> logInfo("Expected: " + result);
        Assert.assertTrue(result);
    }

    public static boolean isDisplayed(WebElement element) {
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        return element.isDisplayed();
    }

    public static boolean isEnabled(WebElement element) {
        waitForElementClickability(element);
        moveIntoView(element);
        highlightElement(element);
        return element.isEnabled();
    }

    public static boolean isDisabled(WebElement element) {
        moveIntoView(element);
        highlightElement(element);

        if (element.isEnabled()) {
            return false;
        } else {
            return true;
        }
    }

    public static void switchToNewWindow() {
        for (String each : driver.getWindowHandles()) {
            if (!each.equals(driver.getWindowHandle())) {
                driver.switchTo().window(each);
            }
        }
    }

    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}

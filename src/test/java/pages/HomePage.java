package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//i[text()='10090 Main Street']")
    public WebElement addressLineOne;

    @FindBy(xpath = "//strong[text()='Fairfax, VA, USA']")
    public WebElement addressLineTwo;

    @FindBy(xpath = "//strong[text()='+1 703-831-3217']")
    public WebElement phoneNumber;

}

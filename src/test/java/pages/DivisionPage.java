package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class DivisionPage {
    public DivisionPage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(tagName = "h1")
    public WebElement divisionTitle;

    @FindBy(xpath = "//div[@class='info-box-three']")
    public WebElement divisionAddress;

    @FindBy(xpath = "//div[@class='info-box-three'][2]")
    public WebElement divisionPhone;
}
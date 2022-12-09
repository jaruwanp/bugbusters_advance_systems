package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class GeneralNavBarPage {

    public GeneralNavBarPage() {
        PageFactory.initElements(BrowserUtils.getDriver(),this);}

        @FindBy(xpath = "//div/ul[@class='topbar-menu']")
        public WebElement button;

        @FindBy (xpath = "//li/a[@id='dropdownMenu1']")
        public WebElement languange;



}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//form[@class='form-inline']/*[last()]")
    public WebElement newDashboard;



    @FindBy(xpath = "//div/ul[@class='topbar-menu']")
    public WebElement menuBtn;

    @FindBy (id = "dropdownMenu1")
    public WebElement langBtn;







}

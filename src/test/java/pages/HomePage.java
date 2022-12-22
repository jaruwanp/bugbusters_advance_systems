package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//section[contains(@class,'testimonial')]")
    public WebElement testimonialSection;

    @FindBy(xpath = "//span[@class='icon-arrows']")
    public WebElement prevArrow;

    @FindBy(xpath = "//span[contains(@class,'right_arrow')]")
    public WebElement nextArrow;

    @FindBy(xpath = "//div[@class='owl-item active']//div[@class='text']")
    public WebElement testimonial;

    @FindBy(xpath = "//div[@class='owl-item active']//div[@class='designation']")
    public WebElement state;

    @FindBy(xpath = "//div[@class='owl-item active']//h3")
    public WebElement name;

    @FindBy(xpath = "//div[@class='owl-item active']//figure[@class='thumb-box']/img")
    public WebElement clientPic;

    @FindBy(id = "dropdownMenu1")
    public WebElement langMenu;

    @FindBy(xpath = "//div[@data-target='html']")
    public WebElement upArrowbtn;

    @FindBy(tagName = "header")
    public WebElement header;

    @FindBy(xpath = "//div[@class='text']/p")
    public WebElement mainTxt;

}

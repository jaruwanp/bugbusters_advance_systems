package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.CucumberLogUtils;

import java.util.List;

public class HomePage {

    public HomePage(){

        PageFactory.initElements(BrowserUtils.getDriver(), this);

    }

    @FindBy(xpath = "//div[@class='info-box-one']/ul")
    public WebElement address;

    @FindBy(id = "dropdownMenu1")
    public WebElement langMenu;

    @FindBy(xpath = "//footer/div[1]/div/div/div[1]")
    public WebElement contactInfo;

    @FindBy(xpath = "//div[@class='flex-box']/div")
    public WebElement fiveBoxTxt;

    @FindBy(xpath = "//a[text()='Join Now']")
    public WebElement joinNow;

    @FindBy(xpath = "/html/body/div[1]/header/div[4]/div/div[2]")
    public WebElement navBar2;

    //------------------- Jaruwan -------------------
    @FindBy(xpath = "(//a[text()='Read More'])[1]")
    public WebElement btnReadMore1;

    @FindBy(xpath = "(//a[text()='Read More'])[2]")
    public WebElement btnReadMore2;

    @FindBy(xpath ="//div[@class='footer-copyright']")
    public WebElement webFooter;

    ////div[@class='owl-item active']

    @FindBy(xpath = "(//div[@class='owl-stage'])[3]/div/div/img")
    public List<WebElement> companyImagesList;

    @FindBy(xpath = "//span[@class='right_arrow icon-arrows']")
    public WebElement arrowNext;

    @FindBy(xpath = "//span[@class='right_arrow icon-arrows']")
    public WebElement arrowPrev;

    @FindBy(xpath = "//div[@class='thumb-item']/figure")
    public List<WebElement> testimonialFigures;

    //div[@class='thumb-item']/div/h3[text()='Mark Cameron']
    @FindBy(xpath = "//div[@class='thumb-item']/div/h3")
    public List<WebElement> testimonialNames;

    @FindBy(xpath = "//div[@class='testimonial-block-one']/div/div")
    public List<WebElement> testimonialMessages;



    public WebElement getQuickLinkText(String text){
        return  BrowserUtils.getDriver().findElement(
                By.xpath("(//div[@class='inner'])[2]//ul/li//a[text()='" + text + "']"));
    }
    public List<WebElement> getCompanyImage(String img){
        WebElement element;
        String path ="(//div[@class='owl-stage'])[3]/div/div/img[@src='images/clients/" + img+ "']";
        CucumberLogUtils.logInfo(path,false);
        return BrowserUtils.getDriver().findElements(By.xpath(path));
    }

    @FindBy(xpath = "//div[@class='text']/p")
    public WebElement mainTxt;



//(//div[@class='inner'])[2]//ul/li//a

    //------------------- end of Jaruwan -------------------
}

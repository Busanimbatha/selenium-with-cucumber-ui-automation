package pages;

import com.utils.TestBase;
import com.utils.WebCommands;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends TestBase {
    @FindBy(xpath = "//img[@alt='Takealot']")
    private WebElement imgLogo;
    @FindBy(id = "nav_item_359")
    private WebElement linkLoadShedding;
    @FindBy(xpath = "//img[@alt='UPS']")
    private WebElement linkUPS;
    @FindBy(xpath = "(//h1[normalize-space()='Loadshedding'])[1]")
    private WebElement headingLoadshedding;

    public WebCommands webCommands;
    public LandingPage(WebDriver driver) {
        super(driver);
        webCommands = new WebCommands();
    }
    public void verifyLogo(){
        Assert.assertTrue(imgLogo.isDisplayed());
    }
    public void clickLoadSheddingLink(){
        webCommands.click(linkLoadShedding,"Loadshedding link");
    }

}

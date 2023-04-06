package pages;

import com.utils.TestBase;
import com.utils.WebCommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends TestBase {

    @FindBy(xpath = "//img[@alt='UPS']")
    private WebElement linkUPS;

    @FindBy(xpath = "(//h1[normalize-space()='Loadshedding'])[1]")
    private WebElement headingLoadshedding;
    @FindBy(xpath = "(//a[@class='product-anchor sponsored product-card-module_product-anchor_TUCBV'])[1]")
    private WebElement productLink;
    @FindBy(xpath = "(//li[@class='price product-card-module_price_zVU6d']/span)[1]")
    private WebElement productPrice;

    public WebCommands webCommands;
    public ProductPage(WebDriver driver) {
        super(driver);
        webCommands = new WebCommands();
    }

    public void VerifyLoadSheddingTitle(){
        webCommands.verifyPageTitle(headingLoadshedding,"Loadshedding","loadshedding heading ");
    }
    public void clickUpsLink(){
        webCommands.click(linkUPS,"UPS link");
    }
    public void clickProduct() {
        webCommands.click(productLink,"Product link");
    }
    public String getProductName(){
        return webCommands.getAttributeText(productLink,"title");
    }
    public String getProductPrice(){
        return webCommands.getText(productPrice);
    }

}

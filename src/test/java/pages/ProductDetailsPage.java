package pages;

import com.utils.TestBase;
import com.utils.WebCommands;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ProductDetailsPage extends TestBase {

    @FindBy(xpath = "(//a[normalize-space()='Add to Cart'])[1]")
    private WebElement btnAddToCart;
    @FindBy(xpath = "(//button[@class='button checkout-now dark'])[1]")
    private WebElement btnGoToCart;
    @FindBy(xpath = "(//span[@class='drawer-screen-module_one-line_3dnN0'])[1]")
    private WebElement addedToCartTitle;

    @FindBy(xpath = "//div[@class='cell auto']/h1")
    private WebElement pdProductName;

    @FindBy(xpath = "//div[@class='buybox-module_price_2YUFa']/span")
    private WebElement pdPproductPrice;
    public WebCommands webCommands;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        webCommands = new WebCommands();
    }

    public void verifyProductDetails(String productName, String productPrice) {
        verifyProductName(productName);
        verifyProductPrice(productPrice);
    }

    public void clickAddToCartButton() {
        webCommands.click(btnAddToCart, "Add to cart button");
    }

    public void clickGoToCartButton() {
        webCommands.click(btnGoToCart, "Go to cart button");
    }


    public void verifyProductName(String productName) {
        String shopCartProductName = webCommands.getText(pdProductName);
        if (productName.equalsIgnoreCase(shopCartProductName)) {
            System.out.println("The product name matches with the expected product name");
            Assert.assertEquals(productName, shopCartProductName);
        } else {
            System.out.println("The product name does not match with the expected product name");
            Assert.assertFalse(true);
        }
    }

    public void verifyProductPrice(String productPrice) {
        String cartPrice = webCommands.getText(pdPproductPrice);
        if (productPrice.equalsIgnoreCase(cartPrice)) {
            System.out.println("The product price matches with the expected product price");
            Assert.assertEquals(productPrice, cartPrice);
        } else {
            System.out.println(productPrice + "The product price does not matches with the expected product price" + cartPrice);
            Assert.assertFalse(true);
        }
    }

    public void switchToNewOpenedBrowserTab(){
        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(1));
    }

    public void switchToParentBrowserTab(){
        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(0));
    }

}

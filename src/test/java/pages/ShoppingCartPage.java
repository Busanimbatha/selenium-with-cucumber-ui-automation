package pages;

import com.utils.TestBase;
import com.utils.WebCommands;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends TestBase {

    @FindBy(xpath = "(//h1[normalize-space()='Shopping Cart'])[1]")
    private WebElement headingShoppingCart;
    @FindBy(xpath = "//h3[@class='cart-item-module_item-title_1M9cq']")
    private WebElement cartProductName;
    @FindBy(xpath = "(//div[@class='cart-item-module_total_hR9wF']/span)[1]")
    private WebElement cartProductPrice;
    @FindBy(xpath = "(//div/p[@class='cart-summary-module_cart-summary-items-cost_2gFl4']/span)[1]")
    private WebElement totalPrice;
    @FindBy(xpath = "(//select[@id='cart-item_undefined'])[1]")
    private WebElement cartQuantity;
    @FindBy(xpath = "//button[@class='button clear remove-item']")
    private WebElement btnRemove;



    public WebCommands webCommands;
    private ProductPage productpage;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        webCommands = new WebCommands();
        productpage = new ProductPage(driver);
    }

    public void verifyProductName(String productName) {
            String shopCartProductName = webCommands.getText(cartProductName);
            if (productName.equalsIgnoreCase(shopCartProductName)) {
                System.out.println("The product name matches with the expected product name on cart page");
                Assert.assertEquals(productName, shopCartProductName);
            } else {
                System.out.println("The product name does not match with the expected product name on cart page");
                Assert.assertFalse(true);
            }
    }

    public void verifyProductPrice(String productPrice) {
        String cartPrice = webCommands.getText(cartProductPrice);
        if (productPrice.equalsIgnoreCase(cartPrice)) {
            System.out.println("The product price matches with the expected product price on cart page");
            Assert.assertEquals(productPrice, cartPrice);
        } else {
            Assert.assertFalse(true);
            System.out.println("The product price does not matches with the expected product price");
        }
}
    public void verifyTotalPrice() {
        float totalPricee = Float.parseFloat(webCommands.getText(totalPrice).substring(2).trim().replace(',', '.'));
        if (totalPricee >= 1.00) {
            Assert.assertTrue(true);
            System.out.println("You total price is " + totalPricee + " for added product(s)");
        } else {
            System.out.println("You total price " + totalPricee + " is less than the expected total price");
            Assert.assertFalse(true);

        }
    }

    public void verifyProductQuantity() {
        int quantity = Integer.parseInt(webCommands.getSelectedOptionValue(cartQuantity).trim());
        if (quantity >= 1) {
            Assert.assertTrue(true);
            System.out.println("You have " + quantity + " quantity for this product");
        } else {
            Assert.assertFalse(true);
            System.out.println("You quantity " + quantity + " is less than the expected quantity");
        }
    }
public void clickRemoveItemToCart(){
    webCommands.click(btnRemove, "Remove button");
}

}

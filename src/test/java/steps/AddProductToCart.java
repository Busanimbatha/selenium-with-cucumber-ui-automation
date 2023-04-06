package steps;

import com.utils.WebCommands;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.ProductDetailsPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

import static com.utils.Config.WEB_BROWSER;
import static com.utils.TestBase.driver;
import static com.utils.TestBase.initializeBrowser;

public class AddProductToCart {
    LandingPage landingpage;
    ProductPage productpage;
    ProductDetailsPage productdetailspage ;
    ShoppingCartPage shoppingcartpage;

    private String productName = null;
    private String productPrice = null;
    public static WebCommands webCommands;
    public AddProductToCart() {
        webCommands = new WebCommands();
    }
    @Before
    public static void setup() {
        initializeBrowser(WEB_BROWSER);
    }
    @BeforeStep
    public void initializeObjects() {
        landingpage =new LandingPage(driver);
        productdetailspage =new ProductDetailsPage(driver);
        productpage =new ProductPage(driver);
        shoppingcartpage =new ShoppingCartPage(driver);
    }

    @Given("I have browsed the product")
    public void iHaveBrowsedTheProduct() {
        landingpage.verifyLogo();
        landingpage.clickLoadSheddingLink();
        productpage.VerifyLoadSheddingTitle();
        productpage.clickUpsLink();
        productName = productpage.getProductName();
        productPrice = productpage.getProductPrice();
    }

    @And("I am on a product detail page")
    public void iAmOnAProductDetailPage() throws InterruptedException {;
        productpage.clickProduct();
        productdetailspage.switchToNewOpenedBrowserTab();
        productdetailspage.verifyProductDetails(productName,productPrice);
    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        productdetailspage.clickAddToCartButton();
    }

    @And("I click on go to cart button")
    public void iClickOnGoToCartButton() {
        productdetailspage.clickGoToCartButton();
    }

    @Then("the product should be successfully added to my shopping cart")
    public void theProductShouldBeSuccessfullyAddedToMyShoppingCart() {
        shoppingcartpage.verifyProductName(productName);
        shoppingcartpage.verifyProductPrice(productPrice);
        shoppingcartpage.verifyProductQuantity();
        shoppingcartpage.verifyTotalPrice();
        shoppingcartpage.clickRemoveItemToCart();
        webCommands.closeBrowser();
        productdetailspage.switchToParentBrowserTab();
    }

    @After
    public static void tearDown() {
        webCommands.sleep(1000);//delay before closing a browser
        webCommands.closeBrowser();
    }
}

package com.utils;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.utils.TestBase.driver;

public class WebCommands {
    public void sendKeys(WebElement element,String value,String elementName){
        element.clear();
        element.sendKeys(value);
        System.out.println("Entered '" + value + " 'on " + elementName + " input");
    }
    public void click(WebElement element,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        System.out.println("Clicked on " + elementName);
    }
    public void verifyPageTitle(WebElement element,String expectedTitle,String elementName){
        if (getText(element).equalsIgnoreCase(expectedTitle))
        {
            System.out.println(getText(element) + " heading matches with the expected heading " + expectedTitle);
            Assert.isTrue(true,"");
        }
        else{
            System.out.println("" + elementName);
            Assert.isTrue(false,"");
        }
    }

    public String getSelectedOptionValue(WebElement element){
        Select dropdown = new Select(element);
        return dropdown.getFirstSelectedOption().getText();
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }
    public String getText(WebElement element){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (element.getText() == ""){
            sleep(1500);
        }
        return element.getText();
    }
    public String getAttributeText(WebElement element,String attributeName){
        return element.getAttribute(attributeName);
    }
    public void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeBrowser(){
        driver.close();
    }
    public void quitBrowser(){
        driver.quit();;
    }
}

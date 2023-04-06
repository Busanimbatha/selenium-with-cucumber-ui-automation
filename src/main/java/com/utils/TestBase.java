package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import static com.utils.Config.BASE_URL;

public class TestBase {
    public static WebDriver driver;
    public TestBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static WebDriver initializeBrowser(String browserName) {
        ;
        switch (browserName.toLowerCase()){
            case "chrome":
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.addArguments("incognito");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeoptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--private");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Please specify the browser");
                break;
        }
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return driver;
    }

}

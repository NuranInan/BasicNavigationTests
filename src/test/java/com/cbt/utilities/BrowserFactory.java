package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public  class BrowserFactory {

    /**
     * Create class BrowserFactory under utilities package.
     * Create a public static method getDriver which takes a string argument.
     * If you are using Windows, and if the String argument is `safari`, return null.
     * If you are using Mac, and if the String argument is `edge`, return null.
     *
     * @return webdriver object
     */
       /* public static WebDriver getDriver(String browserName){
            if(browserName.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }else{
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();*/
    public static WebDriver getDriver(String browserName) {
        if (browserName.equalsIgnoreCase("edge")) {
            return null;
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().version("79").setup();
            WebDriver driver = new ChromeDriver();
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            return new FirefoxDriver();
        } else {

            return new SafariDriver();
        }
    }
}










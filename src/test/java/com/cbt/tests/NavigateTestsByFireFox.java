package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateTestsByFireFox {
    public static void main(String[] args) throws InterruptedException {


        BrowserFactory.getDriver("firefox");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.mozilla.org");
        String actual = driver.getTitle();
        System.out.println(actual);
        StringUtility.verifyEquals("Firefox", actual);
        Thread.sleep(3000);


        driver.get("https://www.etsy.com");
        String actual1 = driver.getTitle();
        System.out.println(actual1);
        StringUtility.verifyEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", actual1);
        Thread.sleep(3000);

        driver.navigate().back();
        StringUtility.verifyEquals("Firefox", actual);
        Thread.sleep(3000);

        driver.navigate().forward();
        StringUtility.verifyEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", actual1);

        driver.quit();
    }
}



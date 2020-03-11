package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) throws InterruptedException {
        testChrome();
        Thread.sleep(1000);
        testFireFox();
        Thread.sleep(1000);

        testSafari();
    }

    public static void testChrome(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        driver.manage().window().maximize();

        String titleGoogle = driver.getTitle();
        driver.get("http://etsy.com");
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        String titleGogogle2= driver.getTitle();

        driver.navigate().forward();
        String titleEtsy2 = driver.getTitle();

        StringUtility.verifyEquals(titleGoogle,titleGogogle2);
        StringUtility.verifyEquals(titleEtsy,titleEtsy2);





        driver.quit();
    }

    public static void testFireFox(){
        WebDriver driver = BrowserFactory.getDriver("Firefox");

        driver.get("http://google.com");
        driver.manage().window().maximize();

        String titleGoogle = driver.getTitle();
        driver.get("http://etsy.com");
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        String titleGogogle2= driver.getTitle();

        driver.navigate().forward();
        String titleEtsy2= driver.getTitle();

        StringUtility.verifyEquals(titleGoogle,titleGogogle2);
        StringUtility.verifyEquals(titleEtsy,titleEtsy2);






        driver.quit();

    }
    public static void testSafari(){

        WebDriver driver = BrowserFactory.getDriver("Safari");
        driver.get("http://google.com");
        driver.manage().window().maximize();

        String titleGoogle = driver.getTitle();
        driver.get("http://etsy.com");
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        String titleGogogle2= driver.getTitle();

        driver.navigate().forward();
        String titleEtsy2= driver.getTitle();

        StringUtility.verifyEquals(titleGoogle,titleGogogle2);
        StringUtility.verifyEquals(titleEtsy,titleEtsy2);








        driver.quit();
    }
}
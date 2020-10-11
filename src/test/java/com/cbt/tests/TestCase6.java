package com.cbt.tests;

import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 {

    private WebDriver driver;

    private String URL = "http://www.tempmailaddress.com/";
    private By emailBy = By.className("animace");
    private By passwordBy = By.id("hesloGen");
    private String URL2 = "https://practice-cybertekschool.herokuapp.com";
    private By signUpBy = By.xpath("//a[contains(text(),'Sign Up For Mailing List')]");
    private By fullNameBy = By.name("full_name");
    private By emailBy2 = By.name("email");
    private By signUpBy2 = By.xpath("//button[@name='wooden_spoon']");
    private By mailAnswer = By.xpath("//td[text()='Thanks for subscribing to practice.cybertekschool.com!']");
    private By mailRead = By.cssSelector("#odesilatel");



    @Test(description = "Tc#6")
    public void subscription(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        String email= driver.findElement(emailBy).getText();
        BrowserUtils.wait(3);
        System.out.println(email);
        String password= driver.findElement(passwordBy).getText();
        System.out.println(password);
        BrowserUtils.wait(3);


        driver.get(URL2);
        BrowserUtils.wait(3);
        driver.findElement(fullNameBy).sendKeys("Patrick White");
        driver.findElement(emailBy2).sendKeys(email);
        BrowserUtils.wait(3);
        driver.findElement(signUpBy2).click();

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();

        Assert.assertEquals(actual, expected);




        driver.get(URL);
        BrowserUtils.wait(3);
        driver.findElement(mailAnswer).click();

        BrowserUtils.wait(3);
        String expected1 ="do-not-reply@practice.cybertekschool.com";

        String actual1 = driver.findElement(mailRead).getText();
        BrowserUtils.wait(5);

        Assert.assertEquals(actual1, expected1);

        driver.quit();
    }
}

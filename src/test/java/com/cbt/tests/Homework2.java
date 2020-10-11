package com.cbt.tests;


import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Homework2 {


    private String URL = "http://practice.cybertekschool.com/registration_form";

    private WebDriver driver;
    //private By dateOfBirthBy = By.xpath("//input[@placeholder='MM/DD/YYYY']");
    private By dateOfBirthBy = By.name("birthday");
    //languages
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");


    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");


    //sign up button
    private By signUpBy = By.id("wooden_spoon");

    @Test(description = "TC#1")
    public void registrationFormBirthday() throws InterruptedException {
        driver.findElement(dateOfBirthBy).sendKeys("01");
        Thread.sleep(3000);
        WebElement warningMessage = driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
        Thread.sleep(3000);
        Assert.assertTrue(warningMessage.isDisplayed());

        System.out.println(warningMessage.getText());

    }

    @Test(description = "Tc#2")
    public void registrationFormLanguage() {
        driver.findElement(cplusplusBy).click();
        driver.findElement(javaBy).click();
        driver.findElement(javascriptBy).click();

        BrowserUtils.wait(3);

        Assert.assertTrue(driver.findElement(cplusplusBy).isSelected());
        Assert.assertTrue(driver.findElement(javaBy).isSelected());
        Assert.assertTrue(driver.findElement(javascriptBy).isSelected());
    }
        @Test(description ="Tc#3")
                public void characterName(){
            driver.findElement(firstNameBy).sendKeys("N");
            WebElement warningMessage1 = driver.findElement(By.xpath("//small[contains(text(),'first name must be more than 2 and less than 64 characters long')]"));
            Assert.assertTrue(warningMessage1.isDisplayed());

            System.out.println(warningMessage1.getText());
        }
    @Test(description ="Tc#4")
    public void characterLastName(){
        driver.findElement(lastNameBy).sendKeys("N");
        WebElement warningMessage2 = driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64 characters long')]"));

        BrowserUtils.wait(3);
        Assert.assertTrue(warningMessage2.isDisplayed());

        System.out.println(warningMessage2.getText());
    }
    @Test(description ="Tc#5")
    public void test1() {
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("123455678");
        driver.findElement(phoneBy).sendKeys("234-123-1231");

        driver.findElement(maleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("09/18/1975");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(4);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

package com.cbt.tests;

import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase7 {

    private WebDriver driver;

    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private By fileUploadButton = By.xpath("//a[contains(text(),'File Upload')]");

   @Test
   private void FileUpload(){
       WebDriverManager.chromedriver().version("79").setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get(URL);

       driver.findElement(fileUploadButton).click();
       BrowserUtils.wait(3);

       WebElement upload = driver.findElement(By.id("file-upload"));
       String filePath = System.getProperty("user.dir")+"/pom.xml";
       String filePath2 ="/Users/nurandingilinan/IdeaProjects/BasicNavigationTests/pom.xml";
       upload.sendKeys(filePath2);

       driver.findElement(By.id("file-submit")).click();
       BrowserUtils.wait(5);
       driver.quit();
   }

}

package com.cybertek.Homework;

import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BRETestCase1 {
     WebDriver driver;
     // we declare the driver reference type into interface WebDriver cuz we  will use it later,
     // //it is a leach and will attach it to the dog in this case to the browser which will work
     String username = "//*[@id='login']";
     // we found the username location of the element and assign it to the var String
     String password = "//*[@id='password']";
     // the same her but we found the password element and declare it to the variable String
String loginButton = "//*[@type ='submit']";
// and login buttom



@BeforeMethod
     public void setUp () {

         WebDriverManager.chromedriver().setup();
         // here we are setting up the environment and we use WebDrivermanager to help us
         driver = new ChromeDriver();
         // here we found our dog which is google chrome, we will work on this browser our project
         driver.manage().window().maximize();
         // since we hve a lot of methods which help us to me our job easier so we use driver pointer in order to manage our window
    // so we want our window to be big
    driver.get("http://34.220.250.213/web/login");
    // and we use get method in order to open our URL
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    //as soon we have opened the page we want to wait for 4 seconds and here we use implicitWait method,
     }
     @Test
     public void test1 (){

driver.findElement(By.xpath(username)).sendKeys("expensesmanager65@info.com");
// we found our element by using xpath locator and sending username information by using findelemet and sendKeys methods
driver.findElement(By.xpath(password)).sendKeys("expensesmanager");
// we found our element by using xpath locator and sending password information by using findelemet and sendKeys methods
driver.findElement(By.xpath(loginButton)).click();
// we found our element by using xpath locator and clicking it by using click() method
SeleniumUtil.waitPlease(5);

        WebElement clPage =  driver.findElement(By.xpath("//*[@id='oe_main_menu_navbar']/div[2]/ul[1]/li[2]/a/span"));
        clPage.click();
         SeleniumUtil.waitPlease(4);
        String expected ="Calendar";
        String actual =  clPage.getText();
        Assert.assertEquals(expected,actual);
        System.out.println("The CalendarPage is open");
         List<WebElement> days = driver.findElements(By.tagName("th"));
         for (WebElement results : days){
             results.click();
System.out.println(results.getText());
         }


     }


     @AfterMethod
     public void tearDown (){
    driver.quit();
     }
}

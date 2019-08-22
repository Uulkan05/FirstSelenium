package com.cybertek.Homework;

import com.cybertek.Utilities.SeleniumUtil;
import com.cybertek.Utilities.VYTrackUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BRETestCases2 {
    WebDriver driver;
    // we declare the driver reference type into interface WebDriver cuz we  will use it later,
    // //it is a leach and will attach it to the dog in this case to the browser which will work
    String username = "//*[@id='login']";
    // we found the username location of the element and assign it to the var String
    String password = "//*[@id='password']";
    // the same her but we found the password element and declare it to the variable String
    String loginButton = "//*[@type ='submit']";
// and login buttom
    String calendar = "//*[@id='oe_main_menu_navbar']/div[2]/ul[1]/li[2]/a/span";
    String creatingEvent =".fc-widget-content";
    String summary = "//*[@class ='o_input']";
    String createBtn = "//span[contains(text(),'Create')]";




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
    public void verifyCreatingMeeting (){
        driver.findElement(By.xpath(username)).sendKeys("expensesmanager65@info.com");
// we found our element by using xpath locator and sending username information by using findelemet and sendKeys methods
        driver.findElement(By.xpath(password)).sendKeys("expensesmanager");
// we found our element by using xpath locator and sending password information by using findelemet and sendKeys methods
        driver.findElement(By.xpath(loginButton)).click();
// we found our element by using xpath locator and clicking it by using click() method
        SeleniumUtil.waitPlease(5);

        WebElement clPage =  driver.findElement(By.xpath(calendar));
        // assign it to the WebElement nd click on it
        clPage.click();
        SeleniumUtil.waitPlease(2);
        // wait for 10 seconds
        String expected ="Calendar";
        // expected result
        String actual =  clPage.getText();
        // actual
        Assert.assertEquals(expected,actual);
        System.out.println("The CalendarPage is open");
        try {
            WebElement timeAndDay = driver.findElement(By.cssSelector(creatingEvent));
            timeAndDay.click();
        }catch (Exception e){
            e.fillInStackTrace();
        }
        SeleniumUtil.waitPlease(2);
        WebElement meetingWithIbrahim = driver.findElement(By.xpath(summary));
        meetingWithIbrahim.sendKeys("Meeting with our Mentor");
        try {
        driver.findElement(By.xpath(createBtn)).click();
        System.out.println("You have created the meeting with Your Mentor");

      } catch (Exception e) {
            if (e.getStackTrace().length == 0) {
                e.fillInStackTrace(); }
        }
       SeleniumUtil.waitPlease(3 );
    }




@AfterMethod
    public void tearDown (){
     driver.quit();
}
}

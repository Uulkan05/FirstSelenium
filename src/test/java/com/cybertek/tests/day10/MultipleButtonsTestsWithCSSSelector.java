package com.cybertek.tests.day10;

import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultipleButtonsTestsWithCSSSelector {
String button1Locator = "[onclick='button1()']";
    String button2Locator = ".btn.btn-primary:nth-of-type(2)";
    String button3Locator = "[id^='button_']";// starts with ^ in css (caret sign^)
    String button4Locator = "[id$='_button'][onclick='button4()']";
    String button5Locator = "[onclick*='5']";
    String button6Locator = "#disappearing_button";
    String resultLocator = "#result";

    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test(priority = 1, description = "Verifying button 1", enabled = true)
    public void button1Test(){
        driver.findElement(By.cssSelector(button1Locator)).click();
        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test (priority = 2, dependsOnMethods = {"button1Test"})
    //dependsOnMethod will affect on current test if those methods fail, it will ignore this test
    public void button2Test(){
        driver.findElement(By.cssSelector(button2Locator)).click();
        String expectedMessage = "Clicked on button two!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        SeleniumUtil.waitPlease(3);
//        throw new SkipException("I don't want to run this test."); we can skip the test
    }





    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}

package com.cybertek.Homework;

import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class Crm_Test_Case1 {
//    User Story : As a user, when I already created an opportunity in CRM module of Bribe ERP application, I want to be able to delete it.
//    Acceptance Criteria :
//     1.Verify that user should be able to see the list view.
//    2.Verify that user should be able to delete the opportunity from action drop down list .

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
    public void verifyToseetheListView()throws Exception {
        driver.findElement(By.xpath(username)).sendKeys("eventscrmmanager10@info.com");
// we found our element by using xpath locator and sending username information by using findelemet and sendKeys methods
        driver.findElement(By.xpath(password)).sendKeys("eventscrmmanager");
// we found our element by using xpath locator and sending password information by using findelemet and sendKeys methods
        driver.findElement(By.xpath(loginButton)).click();
// we found our element by using xpath locator and clicking it by using click() method
        SeleniumUtil.waitPlease(5);
        // find the crm module element and click on it
        System.out.println(driver.getTitle());
        // verification of the main page by printing out the title
        WebElement crm = driver.findElement(By.xpath("//span[@class='oe_menu_text'][contains(text(),'CRM')]"));
        crm.click();
        SeleniumUtil.waitPlease(5);
        System.out.println(crm.getText() + " page is open");
        //make sure is the crm module is opened;
        WebElement creatBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o-kanban-button-new']"));
        creatBtn.click();
        SeleniumUtil.waitPlease(5);
        // defining the create button and clicking on it and wait until the create btn opens
        WebElement opportunityLine1 = driver.findElement(By.xpath("//input [@placeholder ='e.g. Customer Deal']"));
        opportunityLine1.sendKeys("Amigo Meeting");
        SeleniumUtil.waitPlease(5);
        // filling up the lines to create the opportunities
        WebElement revenueLine3 = driver.findElement(By.xpath("//div//input[@name ='planned_revenue']"));
        revenueLine3.clear();
        revenueLine3.sendKeys("5000");
        SeleniumUtil.waitPlease(5);
        driver.findElement(By.xpath("//button[@name='close_dialog']//span[contains(text(),'Create')]")).click();
        SeleniumUtil.waitPlease(5);
        // clicking on the list and make sure is opened
        WebElement list = driver.findElement(By.xpath("//button[@data-original-title ='List']"));
        list.click();
        SeleniumUtil.waitPlease(5);


          //  List checkboxes =driver.findElements(By.)
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
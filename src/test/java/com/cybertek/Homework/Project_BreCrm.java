package com.cybertek.Homework;

import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Project_BreCrm {
    WebDriver driver;
String loginBtn = "#wrapwrap > main > div > form > div.clearfix.oe_login_buttons > button";
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
    //Verify that user should be able to see the list view.

    @Test
    public void Test1 () throws Exception {
        WebElement username = driver.findElement(By.id("login"));
        username.sendKeys("eventscrmmanager10@info.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("eventscrmmanager");
        driver.findElement(By.cssSelector(loginBtn)).click();
        SeleniumUtil.waitPlease(2);
        WebElement crmBtn = driver.findElement(By.xpath("//span[@class='oe_menu_text'][contains(text(),'CRM')]"));
        crmBtn.click();
        System.out.println("You have opened the " + crmBtn.getText() + " page!");
        SeleniumUtil.waitPlease(3);
        WebElement listBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[3]/button[2]"));
        listBtn.click();
        SeleniumUtil.waitPlease(5);
        WebElement checkBox = driver.findElement(By.xpath("//td[contains(text(),'Book sale')]"));
       // if (checkBox.equals("Book sale")){
            checkBox.click();
            System.out.println("Checkbox Status is -  " + checkBox.isSelected());
       // }else
        //checkBox.click();
           // System.out.println("It is wrong the check box");
            SeleniumUtil.waitPlease(5);
//       // WebElement actionBtn =driver.findElement(By.xpath("//button[contains(text(),'Action')]"));
//            //Action actions = new Action (driver.findElement(By.xpath("//button[contains(text(),'Action')]")));
//Select actionBtn = new Select(driver.findElement(By.xpath("//div[starts-with(@class,'btn-group o_dropdown']")));
////label[starts-with(@id,'message')]
//actionBtn.deselectByVisibleText("Delete");
       // driver.findElement(By.xpath("//div[starts-with(@class,'btn-group o_dropdown']")).click();
           // actionBtn.click();
            SeleniumUtil.waitPlease(5);



    }

    @AfterMethod
    public  void tearDown (){
        driver.quit();
    }
}

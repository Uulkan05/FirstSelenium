package com.cybertek.Homework;

//import com.sun.tools.javac.util.Assert;
import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.cybertek.Homework.PracticeCybertekSchool1.driver;

public class CybertekPractice {

    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(3000);

       WebElement username = driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input"));
       username.sendKeys("tomsmith");

       WebElement password = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input"));
       password.sendKeys("SuperSecret9Password");

       WebElement submit = driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]"));
       submit.click();

      WebElement loggedin = driver.findElement(By.xpath("//*[@id=\"flash\"]"));

      System.out.println(loggedin.getText());




       driver.quit();


       }





    }


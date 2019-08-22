package com.cybertek.OfficeHours;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AmazonWarmUp {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws InterruptedException {
        amazonTest();
    }

    public static void amazonTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sunscreen");
        driver.findElement(By.className("nav-input")).click();
        //driver.quit();
        String title = driver.getTitle();
        Thread.sleep(3000);
        if (title.contains("sunscreen")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.quit();
    }
}
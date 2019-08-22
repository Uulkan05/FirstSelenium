package com.cybertek.tests.Day5;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EbayTest
{
static WebDriver driver = BrowserFactory.getDriver("chrome");

public static void main(String[] args) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
//        driver.findElement(By.id("gh-ac")).sendKeys("Java Book", Keys.ENTER);
        driver.findElement(By.id("gh-ac")).sendKeys("Java Book");
        driver.findElement(By.id("gh-btn")).click();
        String results = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(results);
        driver.close();

        }
        }
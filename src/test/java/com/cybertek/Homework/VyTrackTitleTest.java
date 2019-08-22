package com.cybertek.Homework;

import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class VyTrackTitleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("User45");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123" + Keys.ENTER);
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(2000);

        WebElement name = driver.findElement(By.className("dropdown-toggle"));
        name.click();
        Thread.sleep(2000);
        WebElement myConfiguration = driver.findElement(By.linkText("My Configuration"));
        myConfiguration.click();
        Thread.sleep(2000);


        String currentTitle = driver.getTitle();
        if (currentTitle.startsWith("John Doe")) {
            System.out.println("Tittle starts with John Doe");
        } else {
            System.out.println("Failed!");

        }

        driver.findElement(By.className("dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[5]/a")).click();
String url = driver.getCurrentUrl();
if (url.contains("http://qa2.vytrack.com/user/login")){
    System.out.println("Succesfully logged out");
}else{
    System.out.println("Failed!");
}

driver.quit();
    }
}



package com.cybertek.Homework;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PracticeCybertekSchool1 {
    static int count = 0;

    static WebDriver driver =
            BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() throws Exception {
        driver.manage().window().maximize();
        /// selenium will wait 10 seconds for element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        String expectedMessage = "This is where you can log into the secure area.";
        String actualMessage = driver.findElement(By.className("subheader")).getText();
        if (SeleniumUtil.verifyEquals(expectedMessage, actualMessage)) System.out.println("Correct Web Site");
        else System.out.println("Logged into wrong Web Site");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("tt");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("wooden_spoon")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String errorMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        expectedMessage = "Your password is invalid!";
        //System.out.println(errorMessage + " error message is received.");
        if (SeleniumUtil.verifyEquals(expectedMessage, errorMessage)) {
            driver.quit();
        } else {
            driver.findElement(By.linkText("Logout")).click();
            driver.quit();
        }
        //div[@id='flash']
    }
}

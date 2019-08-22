package com.cybertek.tests.day13_actions_jsexecutor;

import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.crypto.SealedObject;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void jsExecutorTest1() {
        driver.get("http://practice.cybertekschool.com/");
        //we want to run some javascript code
        //for this, we have to use Javascript interface
        //Since it;s an interface, we cannot create an object
        //we just have to cast webdriver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //and then to execute script itself
        //we call executeScript()method
        //executeScript returns an object
        String title = (String) js.executeScript("return document.title");
        //or you can execute some script without any return
        js.executeScript("alert('Hello Spartans!!!')");
        SeleniumUtil.waitPlease(2);
        //Alert interface hadles alerts
        //what is alert?
        //It looks like pop up window
        Alert alert = driver.switchTo().alert();
        //we can use accept 9) method to select Ok in the pop up
        alert.accept();
        SeleniumUtil.waitPlease(3);
        System.out.println(title);
    }

    @Test
    public void scrollTest1() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 11; i++) {
            js.executeScript("window.scrollBy(0, 250)");
            SeleniumUtil.waitPlease(1);
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}

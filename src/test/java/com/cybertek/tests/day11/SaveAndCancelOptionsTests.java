package com.cybertek.tests.day11;

import com.cybertek.Utilities.SeleniumUtil;
import com.cybertek.Utilities.VYTrackUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SaveAndCancelOptionsTests {
    WebDriver driver;
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
    String cancelButtonLocator = "a[title='Cancel']";
    //locators for save and close dropdown
    String saveAndCloseButtonLocator = "//div/button[contains(text(),'Save and Close')]";
    String saveAndCloseDropdownLocator = "a[class='btn-success btn dropdown-toggle']";
    String saveAndCloseOptionLocator = "//li/button[contains(text(),'Save and Close')]";
    String saveAndNewOptionLocator = "//li/button[contains(text(),'Save and New')]";
    String saveOptionLocator = "(//li/button[contains(text(),'Save')])[3]";


    @BeforeMethod
    public void setup() {
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        VYTrackUtilities.login(driver, "salesmanager253", "UserUser123");
    }

    @Test
    public void verifyCancelButton() {
        VYTrackUtilities.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtil.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtil.waitPlease(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

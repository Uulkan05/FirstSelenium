package com.cybertek.Homework;

import com.cybertek.Utilities.SeleniumUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Vy_Track2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

//        1. Open browser done
//        2. Go to Vytrack login page done
//        3. Login as a sales manager done
//        4. Verify Dashboard page is open
//        5. Click on Shortcuts icon
//        6. Click on link See full list
//        7. Click on link Opportunities
//        8. Verify Open opportunities page is open
//        9. Click on Shortcuts icon
//        10.Click on link Vehicle Service Logs
//        11.Verify error message text is You do not have permission to perform this action.
//        12.Verify Open opportunities page is still open

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("storemanager81");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123" + Keys.ENTER );
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(2000);

       WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
       String label =  dashboard.getText();
if ( label.contains("Dashboard")){
    System.out.println("Dashboard is Open");
}else{
    System.out.println("Failed!");
}

WebElement shortcut = driver.findElement(By.xpath("//*[@class='fa-share-square']"));
shortcut.click();

WebElement fullist = driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a"));
fullist.click();
System.out.println(fullist.getText());

//driver.findElement()
System.out.println(driver.getTitle());




    }







    }


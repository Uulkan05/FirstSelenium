package com.cybertek.tests.Day6;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

//test1();
test2();


    }

    public static void openCheckBoxesPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //let's make sure that Checkboxes header is visible, not only in the code
        WebElement checkboxesLogo = driver.findElement(By.tagName("h3"));
        if(checkboxesLogo.isDisplayed()){
            System.out.println("Checkboxes logo is visible");
        }else{
            System.out.println("Checkboxes logo not found!");
        }
    }

    //check if the checkbox is selected and checkbox 2 is not selected
    public static void test1() {
        openCheckBoxesPage();
        WebElement check1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement check2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if (!check1.isSelected()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        if (check2.isSelected()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.quit();
    }
        public static void test2(){
            openCheckBoxesPage();
            WebElement check1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
            WebElement check2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
            SeleniumUtil.waitPlease(2);
            check1.click();
            SeleniumUtil.waitPlease(2);
        check2.click();
        SeleniumUtil.waitPlease(2);
        if (check1.isSelected() && (!check2.isSelected())){
            System.out.println("Passed!");



    }else {
            System.out.println("Failed!");
        }
driver.quit();
    }




}

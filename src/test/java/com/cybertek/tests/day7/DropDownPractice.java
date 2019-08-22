package com.cybertek.tests.day7;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openDropDownpage();
        SeleniumUtil.waitPlease(2);
        //test1();
       // test2();
        test6();
        SeleniumUtil.waitPlease(2);
        driver.close();
    }

    public static void openDropDownpage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        String expected = "Dropdown List";
//String actual = driver.findElement(By.tagName("h3")).getText();
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtil.verifyIsDisplayed(element);
    }

    public static void test1() {
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        //to work with select elements
        // we need to use Select class
        Select dropdownSelect = new Select(dropdown1);
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        //  System.out.println(selected);
        String expected = "Please select an option";
        SeleniumUtil.verifyEquals(expected, actual);
        List<WebElement> option = dropdownSelect.getOptions();
        // we can get list options that are available in the dropdown
        for (WebElement option1 : option) {
            System.out.println((option1.getText()));
        }


    }

    public static void test2() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select state = new Select(dropdownState);
        List<WebElement> states = state.getOptions();
        for (WebElement e : states) {
            // lets select Virginia
            //we have to use object select class

            System.out.println(e.getText());
        }
        state.selectByVisibleText("Virginia");
        SeleniumUtil.waitPlease(2);
        state.selectByVisibleText("Washington");
        SeleniumUtil.waitPlease(2);
        state.selectByVisibleText("California");
        SeleniumUtil.waitPlease(2);

    }

    public static void test3() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select state = new Select(dropdownState);
        List<WebElement> states = state.getOptions();
        for (WebElement opt : states) {
            state.selectByVisibleText(opt.getText());
            SeleniumUtil.waitPlease(3);

        }
    }


public static void test4 (){
    WebElement dropdownState = driver.findElement(By.id("state"));
    Select state = new Select(dropdownState);
    // means to find among the option the value of states
    state.selectByValue("MD");
 SeleniumUtil.waitPlease(2);
 String expected = "Maryland";
 // to read which option is selected
 String actual = state.getFirstSelectedOption().getText();
 SeleniumUtil.verifyEquals(expected,actual);



}
// select by index
public static void test5(){
    WebElement dropdownState = driver.findElement(By.id("state"));
    Select state = new Select(dropdownState);
    state.selectByIndex(5);
    SeleniumUtil.waitPlease(2);


}
// selection of multiple options////*
    public static void test6 (){
        WebElement language = driver.findElement(By.xpath("//select [@name = 'Languages']"));
        Select multipleSelection = new Select(language);
        multipleSelection.selectByVisibleText("Java");
        multipleSelection.selectByVisibleText("JavaScript");
        multipleSelection.selectByVisibleText("C#");
        SeleniumUtil.waitPlease(3);
    }
}



package com.cybertek.tests.Day6;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTests {
    static WebDriver driver = BrowserFactory.getDriver ("chrome");

    public static void main(String[] args) {
        openRadioButtonPage();
        test1();
        test2();
        test3();
        test4();
        driver.quit();

    }
    public static void openRadioButtonPage (){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    public static void test1 (){
        //lets check if blue radio button is selected
        //then other radio buttons are not selected
        WebElement btn = driver.findElement(By.id("blue"));
        if (btn.isSelected()){
            System.out.println( "Passed");
        }else {
            System.out.println( "Failed");
        }
        SeleniumUtil.waitPlease(2);

    }
    //check if the green button is disabled

    public static void test2 (){
       WebElement blck= driver.findElement(By.id("black"));
       WebElement green = driver.findElement(By.id("green"));

        if (blck.isSelected() && (!green.isSelected())){
            System.out.println( "Passed");
        }else {
            System.out.println( "Failed");
        }
        SeleniumUtil.waitPlease(2);
    }
    //TASK!
    //write a test(method) that will do following:
    //verify that blue button is selected
    //then click on black button
    //verify that black button is selected
    //verify that blue button is not selected

    public static void test3(){
        WebElement blueBtn =  driver.findElement(By.id("blue"));
        if(blueBtn.isSelected()){
            System.out.println("PASSED");
            System.out.println("Blue selected");
        }else{
            System.out.println("FAILED");
            System.out.println("Blue is not selected!");
        }
        WebElement blackBtn = driver.findElement(By.id("black"));
    SeleniumUtil.waitPlease(2);
        blackBtn.click();
        SeleniumUtil.waitPlease(2);
        //we are checking if black button is selected
        if(blackBtn.isSelected()){
            System.out.println("PASSED");
            System.out.println("Black is selected");
        }else{
            System.out.println("FAILED");
            System.out.println("Black is not selected");
        }
        // ! means opposite. To check if blue button
        //is not selected any more
        //based on requirements, we canot have more
        //then one favorite color
        if(!blueBtn.isSelected()){
            System.out.println("PASSED");
            System.out.println("Blue is not selected");
        }else{
            System.out.println("FAILED");
            System.out.println("Blue is selected!");
        }
    }
    //Let's write a test
    //that will make sure
    //that only one radio button is selected
    public static void test4(){
        // Step 1. Let's find all radio buttons
        List<WebElement> listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        //let's create counter, to count
        //how many selected radio buttons
        int counter = 0;
        //we will go through list of web elements
        //and check one by one
        //which radio button is selected
        //if radio button is selected
        //increase counter
        for(WebElement radioButton: listOfRadioButtons){
            if(radioButton.isSelected()){
                //get id of selected radio button
                System.out.println(radioButton.getAttribute("id"));
                counter++;
            }
        }
        System.out.println(counter);

    }
}

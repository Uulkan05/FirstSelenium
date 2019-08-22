package com.cybertek.tests.day15_review;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Testbase;
import com.cybertek.Utilities.VYTrackUtilities;
import com.cybertek.pages.vytrack.CalendarEventsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends Testbase {

    //BeforeMethod is coming from TestBase
    CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions() {
        //we are reading username from .properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        //we are reading password from .properties file
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        VYTrackUtilities.login(driver, username, password); //login

        //go to Calendar Events
        VYTrackUtilities.navigateToModule(driver, "Activities", "Calendar Events");

        VYTrackUtilities.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();

        VYTrackUtilities.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

        List<String> expectedOptions = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actualOptions = calendarPage.getRepeatOptions();

        //correct way to check if 2 collections are equals
        Assert.assertEquals(actualOptions, expectedOptions);

    }

    @Test
    public void DailyRepeatOptionRepeatEveryTest(){

    }

}

package com.cybertek.tests.day14_Ssytem_Properties_Singleton;

import com.cybertek.Utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigurationReaderTests {

    @Test
    public void test1 (){
        String expected = "chrome";
        String actual = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void test2 (){
        String expectedUserName = "storemanager";
        String actualUserName=ConfigurationReader.getProperty("username");
        Assert.assertEquals(actualUserName,expectedUserName);
    }
}

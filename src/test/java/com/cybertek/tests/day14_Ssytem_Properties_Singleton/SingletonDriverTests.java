package com.cybertek.tests.day14_Ssytem_Properties_Singleton;

import com.cybertek.Utilities.Driver;
import com.cybertek.Utilities.SeleniumUtil;
import org.testng.annotations.Test;

public class SingletonDriverTests {

    @Test
    public void test1(){
        Driver.getDriver().get("https://www.google.com/");
        SeleniumUtil.waitPlease(3);
        Driver.closeDriver();// shutdown the driver completely
    }
}

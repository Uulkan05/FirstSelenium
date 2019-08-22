package com.cybertek.tests.day14_Ssytem_Properties_Singleton;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Testbase;
import com.cybertek.pages.vytrack.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends Testbase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTests1() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
    }
}
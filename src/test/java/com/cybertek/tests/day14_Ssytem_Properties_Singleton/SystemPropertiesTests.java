package com.cybertek.tests.day14_Ssytem_Properties_Singleton;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SystemPropertiesTests {


    @Test
    public void systemPropertiesTest(){
        String os = System.getProperty("os.name");//--> based on that we get the keys-> the operation system
        // we are configuring the os webdriver right now in our computer

                // we get the property and for the parameter we have to provide the value
String username = System.getProperty("user.name");
String javaVersion = System.getProperty("java.version");
String homeDirectory = System.getProperty("user.home");
System.out.println (homeDirectory);
System.out.println(username);
System.out.println(javaVersion);
System.out.println(os);
        Properties properties = System.getProperties();
        // this is an entry set of all propertie
        // since its key value pair, we use Map to store this information
        for (Map.Entry<Object,Object> property: properties.entrySet()){
            // get key of every item(os.name) value of every property
            System.out.println ("Key: " + property.getKey() + ", Value: " + property.getValue());


        }
    }

}

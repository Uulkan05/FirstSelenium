package com.cybertek.tests.day8_testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Java_TestNG_Demo {

    @Test
    public void Test1(){
        String a = "A";
        String b = "A";
        Assert.assertEquals(a,b);
    }
    @Test
    public void Test2 (){
        String str1 = "Apple";
        String str2 = "Orange";
        Assert.assertEquals(str1,str2);
    }
    @Test
    public void test3(){
        String str1 ="ABDC";
        String str2 = "AAA";
        Assert.assertTrue(str1.contains(str2));
        //opposite to AssertTrue--> AssertFalse
    }
    @Test
    public void test4 (){
        Assert.assertFalse(false);
    }
}


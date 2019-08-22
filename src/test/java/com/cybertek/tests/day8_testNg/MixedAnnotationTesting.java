package com.cybertek.tests.day8_testNg;

import org.testng.annotations.*;

public class MixedAnnotationTesting {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @BeforeMethod
 public void setUp(){
     System.out.println("Before method");
 }

    @Test
public void test1(){
    System.out.println ("I am the test1");
}
    @Test
    public void test2() {
        System.out.println("Great Idea");
    }


@AfterMethod
public void tearDown (){
        System.out.println("After Method");
}
@AfterClass
public void afterClass(){
    System.out.println("After Class");
}
}
//Before class--> runs only once
//
//Before method
//  I am the test1 --> runs every test
//  After Method
//
//   Before method
//  Great Idea --> runs every test
// After Method

//  After Class --> runs only once

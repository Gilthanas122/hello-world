package com.helloworld.demohelloworld;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Sampletest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Beforesuite test run");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Aftersuite test run");
    }
}

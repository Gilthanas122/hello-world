package com.helloworld.demohelloworld;

import com.helloworld.demohelloworld.Models.MathForTesting;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MathTests {
    MathForTesting mathForTesting;
    private static final double DELTA = 1e-15;

    @BeforeMethod
    public void beforeMethod(){
        mathForTesting = new MathForTesting();
    }

    @Test
    public void addPositiveIntegers() {
        final int expected = 4;
        Assert.assertEquals(expected, mathForTesting.add(2, 2));
    }

    @Test
    public void addNegativeIntegers() {
        final int expected = -4;
        Assert.assertEquals(expected, mathForTesting.add(-2, -2));
    }

    @Test
    public void addNegativeAndPositiveIntegers() {
        final int expected = 0;
        Assert.assertEquals(expected, mathForTesting.add(2, -2));
    }

    @Test
    public void dividePositiveIntegers() {
        final double expected = 1;
        Assert.assertEquals(expected, mathForTesting.divide(4, 3),DELTA);
    }

    @Test
    public void divideNegativeIntegers() {
        final double expected = 2;
        Assert.assertEquals(expected, mathForTesting.divide(-4, -2),DELTA);
    }

    @Test
    public void divideNegativeAndPositiveIntegers() {
        final double expected = -2;
        Assert.assertEquals(expected, mathForTesting.divide(-4, 2),DELTA);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void divideWith0() {
       mathForTesting.divide(4, 0);
    }

    @AfterMethod
    public void afterMethod(){
        mathForTesting = null;
    }

}

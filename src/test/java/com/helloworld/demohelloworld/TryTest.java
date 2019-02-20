package com.helloworld.demohelloworld;

import org.junit.Assert;
import org.junit.Test;

public class TryTest {
    @Test
    public void testMe() {
        GreetingService greetingService = new GreetingService();
       String greeting = "Hello World5";
        Assert.assertEquals(greeting, greetingService.greet());
    }
}

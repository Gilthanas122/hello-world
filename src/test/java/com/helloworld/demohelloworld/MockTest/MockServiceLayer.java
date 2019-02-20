package com.helloworld.demohelloworld.MockTest;

import com.helloworld.demohelloworld.Models.Hello;
import com.helloworld.demohelloworld.Repositories.HelloRepository;
import com.helloworld.demohelloworld.Services.GreetingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MockServiceLayer {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public GreetingService greetingService() {
            return new GreetingService();
        }
    }

    @Autowired
    private GreetingService greetingService;

    @MockBean
    private HelloRepository helloRepository;

    @Before
    public void setUp() {
        Hello hello = new Hello("hi");
        helloRepository.save(hello);
        Mockito.when(helloRepository.findByGreetingText(hello.getGreetingText()))
                .thenReturn(hello);  // Stubbing -> to return a specified data
    }

    @Test
    public void whenValidGreet_thenHelloShouldBeFound() {
        String greet = "hi";
        Hello found = greetingService.findByGreetingText(greet);
        Assert.assertEquals(found.getGreetingText(), greet);
    }
}

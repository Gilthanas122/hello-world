package com.helloworld.demohelloworld.IntegrationTests;

import com.helloworld.demohelloworld.Models.Hello;
import com.helloworld.demohelloworld.Repositories.HelloRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestFindByGreetingText {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HelloRepository helloRepository;


    public TestFindByGreetingText() {
        this.helloRepository = helloRepository;
    }

    @Test
    public void whenFindByGreetingText_thenReturnHello() {
        // given
        Hello hello = new Hello("hi");
        entityManager.persist(hello);
        entityManager.flush();

        // when
        Hello found = helloRepository.findByGreetingText(hello.getGreetingText());

        // then
        assertThat(found.getGreetingText())
                .isEqualTo(hello.getGreetingText());
    }
}

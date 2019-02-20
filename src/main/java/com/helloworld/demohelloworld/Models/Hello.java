package com.helloworld.demohelloworld.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hello {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String greetingText;

    public Hello() {
    }

    public Hello(String greetingText) {
        this.greetingText = greetingText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGreetingText() {
        return greetingText;
    }

    public void setGreetingText(String greetingText) {
        this.greetingText = greetingText;
    }
}

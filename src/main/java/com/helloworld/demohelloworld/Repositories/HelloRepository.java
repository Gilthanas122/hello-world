package com.helloworld.demohelloworld.Repositories;

import com.helloworld.demohelloworld.Models.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HelloRepository extends JpaRepository <Hello, Long>{

    Hello findByGreetingText(String greet);
}

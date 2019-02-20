#Introduction to TEST

##UnitTesting

* Testing is the process of checking the functionality of an application to ensure it runs as per requirements
* UnitTesting test one single entity - class or method
* Manual (slower) or Automated (faster) testing
* Unit Test Case is a part of code, which ensures that another part of code (method) works as expected -> JUnit and TestNg Framework for Testing 

##Integration Test

* @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit. Whenever we are using any Spring Boot testing features in out JUnit tests, this annotation will be required.

* @DataJpaTest provides some standard setup needed for testing the persistence layer:
    * configuring H2, an in-memory database
    * setting Hibernate, Spring Data, and the DataSource
    * performing an @EntityScan
    * turning on SQL logging
 * TestEntityManager
   * The TestEntityManager provided by Spring Boot is an alternative to the standard JPA EntityManager that provides methods commonly used when writing tests.


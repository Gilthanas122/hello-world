# Introduction to TEST

## UnitTesting

* Testing is the process of checking the functionality of an application to ensure it runs as per requirements
* UnitTesting test one single entity - class or method
* Manual (slower) or Automated (faster) testing
* Unit Test Case is a part of code, which ensures that another part of code (method) works as expected -> JUnit and TestNg Framework for Testing 
* @Before @After annotations
      * Run before and after every test method in the class
* @BeforeClass @AfterClass annotations
      * Static methods which are executed once before and after a test class

## Integration Test

* @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit. Whenever we are using any Spring Boot testing features in out JUnit tests, this annotation will be required.

* @DataJpaTest provides some standard setup needed for testing the persistence layer:
    * configuring H2, an in-memory database
    * setting Hibernate, Spring Data, and the DataSource
    * performing an @EntityScan
    * turning on SQL logging
 * TestEntityManager
   * The TestEntityManager provided by Spring Boot is an alternative to the standard JPA EntityManager that provides methods commonly used when writing tests.
   
## Mocking -> child of Test doubles

* to avoid dependencies -> without wiring in our full persistence layer
* @TestConfiguration annotation that can be used on classes in src/test/java to indicate that they should not be picked up by scanning
* @MockBean. It creates a Mock for the Repository which can be used to bypass the call to the actual Repository
```java
@Test
public void addCustomerWithDummyTest() {
 Customer dummy = mock(Customer.class);
 AddressBook addressBook = new AddressBook();
 addressBook.addCustomer(dummy);
 Assert.assertEquals(1, addressBook.getNumberOfCustomers());
}
```


* Stubing: lightweight versions of system components to help with testing -> part of test doubles just like mock



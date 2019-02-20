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

[Link to the used article](https://www.baeldung.com/integration-testing-in-spring)

* @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit. Whenever we are using any Spring Boot testing features in out JUnit tests, this annotation will be required.

* @DataJpaTest provides some standard setup needed for testing the persistence layer:
    * configuring H2, an in-memory database
    * setting Hibernate, Spring Data, and the DataSource
    * performing an @EntityScan
    * turning on SQL logging
 * TestEntityManager
   * The TestEntityManager provided by Spring Boot is an alternative to the standard JPA EntityManager that provides methods commonly used when writing tests.
 ```java
 @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class GreetControllerIntegrationTest {
    ....
}
```
* @ContextConfiguration, we provided the ApplicationConfig.class config class which loads the configuration we need for this particular test.
### Verify view name
```java
@Test
public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() {
    this.mockMvc.perform(get("/homePage")).andDo(print())
       
      .andExpect(view().name("index"));
}
```
* perform() method will call a get request method which returns the ResultActions. Using this result we can have assertion expectations on response like content, HTTP status, header, etc
* andDo(print()) will print the request and response. This is helpful to get detailed view in case of error
* andExpect() will expect the provided argument. In our case we are expecting “index” to be returned via MockMvcResultMatchers.view()
### Verify response body
```java
@Test
public void givenGreetURI_whenMockMVC_thenVerifyResponse() {
    MvcResult mvcResult = this.mockMvc.perform(get("/greet"))
      .andDo(print()).andExpect(status().isOk())
      .andExpect(jsonPath("$.message").value("Hello World!!!"))
      .andReturn();
     
    Assert.assertEquals("application/json;charset=UTF-8", 
      mvcResult.getResponse().getContentType());
}
```
* andExpect(MockMvcResultMatchers.status().isOk()) will verify that response http status is Ok i.e. 200. This ensures that request was successfully executed
* andExpect(MockMvcResultMatchers.jsonPath(“$.message”).value(“Hello World!!!”)) will verify that response content matches with the argument “Hello World!!!“. Here we used jsonPath which extracts response content and provide the requested value
* andReturn() will return the MvcResult object which is used, when we have to verify something which is not achievable by library. You can see we have added assertEquals to match the content type of response that is extracted from MvcResult object

### Send GET Request with Path Variable
```java
@Test
public void givenGreetURIWithPathVariable_whenMockMVC_thenResponseOK() {
    this.mockMvc
      .perform(get("/greetWithPathVariable/{name}", "John"))
      .andDo(print()).andExpect(status().isOk())
       
      .andExpect(content().contentType("application/json;charset=UTF-8"))
      .andExpect(jsonPath("$.message").value("Hello World John!!!"));
}
```
### Send GET Request with Query Parameters
```java
@Test
public void givenGreetURIWithQueryParameter_whenMockMVC_thenResponseOK() {
    this.mockMvc.perform(get("/greetWithQueryVariable")
      .param("name", "John Doe")).andDo(print()).andExpect(status().isOk())
      .andExpect(content().contentType("application/json;charset=UTF-8"))
      .andExpect(jsonPath("$.message").value("Hello World John Doe!!!"));
}
```

###  Send Post Request
```java
@Test
public void givenGreetURIWithPost_whenMockMVC_thenVerifyResponse() {
    this.mockMvc.perform(post("/greetWithPost")).andDo(print())
      .andExpect(status().isOk()).andExpect(content()
      .contentType("application/json;charset=UTF-8"))
      .andExpect(jsonPath("$.message").value("Hello World!!!"));
}
```

## Test Doubles
[Link to the used article](https://www.javaworld.com/article/2074508/core-java/mocks-and-stubs---understanding-test-doubles-with-mockito.html)
### Mocking 
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
### Mock Object
* verify object's behaviour during a test <-> Stubing: to provide results to whatever you are testing.
```java
public class SimpleTradingService implements TradingService{

  TradeRepository tradeRepository;
  AuditService auditService;
 
  public SimpleTradingService(TradeRepository tradeRepository, 
                              AuditService auditService)
  {
    this.tradeRepository = tradeRepository;
    this.auditService = auditService;
  }

  public Long createTrade(Trade trade) throws CreateTradeException {
  Long id = tradeRepository.createTrade(trade);
  auditService.logNewTrade(trade);
  return id;
}
```
```java
@Mock
TradeRepository tradeRepository;
 
@Mock
AuditService auditService;
@Test
public void testAuditLogEntryMadeForNewTrade() throws Exception { 
  Trade trade = new Trade("Ref 1", "Description 1");
  when(tradeRepository.createTrade(trade)).thenReturn(anyLong()); 
  
  TradingService tradingService 
    = new SimpleTradingService(tradeRepository, auditService);
  tradingService.createTrade(trade);
  
  verify(auditService).logNewTrade(trade);
}
```
* Last line does the checking on the mocked AuditService

### Stubing

* Stubing: lightweight versions of system components to help with testing -> part of test doubles just like mock
* Return controlled values to the object being tested
* These are described as indirect inputs to the test
 > Following example The SimplePricingService has one collaborating object which is the trade repository
 > The trade repository provides trade prices to the pricing service through the getPriceForTrade method.
 > In the following example we stub the PricingRepository to return known values 
 > which can be used to test the business logic of the SimpleTradeService.
 ```java
@Test
public void addCustomerWithDummyTest() {
 Customer dummy = mock(Customer.class);
 AddressBook addressBook = new AddressBook();
 addressBook.addCustomer(dummy);
 Assert.assertEquals(1, addressBook.getNumberOfCustomers());
}
```
### Test Spy
*  wrap a real object and then verify or modify it's behaviour to support your testing
>Here is an example were we check the standard behaviour of a List. 
>Note that we can both verify that the add method is called and 
>also assert that the item was added to the list. <-> if used mock -> only mocking the behaviour so size() gonna be 0
 ```java
@Spy
List<string> listSpy = new ArrayList<string>();

@Test
public void testSpyReturnsRealValues() throws Exception {
 String s = "dobie";
 listSpy.add(new String(s));

 verify(listSpy).add(s);
 assertEquals(1, listSpy.size());
}
</string></string>
```
## Endpoint Testing
* MockMvc creates a mock environment
* Checks if that given endpoint returns with status ok and with the expected string
 ```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
}
```

## Assertions
[Link to the used article](https://www.baeldung.com/spring-assert)
*By using methods of the Assert class, we can write assumptions which we expect to be true
* Assert’s methods are static
* They throw either IllegalArgumentException or IllegalStateException
* The first parameter is usually an argument for validation or a logical condition to check
* The last parameter is usually an exception message which is displayed if the validation fails
* The message can be passed either as a String parameter or as a Supplier<String> parameter

 isTrue()
 * It accepts a boolean condition and throws an IllegalArgumentException when the condition is false
 equals()
 * Checks if the two return values are equal
 state()
 * As the name suggests, it should be used when the method mustn’t be continued because of an illegal state of the object.
 * F.E. if a car is running, we cannot fuel it
 ```java
 Assert.state(this.state.equals("stop"), "car must be stopped");
 ```
notNull() or isNull()
* checks if it is null or not
isInstanceOf()
* is an instance of another object of the specific type
isAssignable()
* To check types, we can use Assert.isAssignable():
hasLength()
*We can check if a String isn’t blank,
hastText()
* String contains at least one non-whitespace character
doesNotContain()
* String argument doesn’t contain a specific substring
notEmpty()
* asserts that a collection/map/array is not empty meaning that it’s not null and contains at least one element;
noNullElements()
*  array doesn’t contain null elements



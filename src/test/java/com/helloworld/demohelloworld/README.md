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
   
## Test Doubles
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



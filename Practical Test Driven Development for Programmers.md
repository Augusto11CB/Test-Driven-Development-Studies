
# Practical Test Driven Development

---
TODO:  Study [Writing Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests)
* [assertAll](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)
* [Dependency Injection for Constructors and Methods](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dependency-injection)
* [Nested Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested)
* [Repeated Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests)
* [Parameterized Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)


## Rules of TDD
1. **Test the expected outcome of an example**
	When writting test, think about expected outcomes not the logic, architecture, design pattern etc. Generally, tests will work on the basis of "cover all the particular "examples"" that the code might have.
	
2. **Don't pre-judge design... let your test drive it**
In TDD, the decisions around things like data types, class structure, architecture will change over time as the tests come up in order to achieve the requirements.

3. **Write the minimum code required to get the tests to pass**

4. **Each test should validate one single piece of logic**
	Some times more than one `assert` is required to validate the logic. But when working with more than one assert it must fit one of the following cases:  
	
	A. Test more than one value to check that something worked correctly.
	> Ex.: A method is spected to set values in a class, is fine write assertions for each of those variables.
	
	B. Test multiple values that are just different examples of the same thing.
	>Validate two CPFs in the method that performs CPF validations.
	
## Rules of Testing
1. Test one item of functionality only

2. Test business logic, not methods
We don't have to create a one-to-one relationship between the tests and the methods of an application in order to test. We do must validate business logic, which turn can call several methods in its execution.

3. Test must be repeatable, and consistent

4. TODO Get explanation in the lessom 21
**How to create a thorough test?**
		A. What should the logic be?
		B. What is the opposite to the logic?
		C. Are there any edge cases?
		D. Are there any error conditions?
	

## Work Flow

### RED -> GREEN -> REFACTOR

1.  RED
Always start a test method with `fail()`. By doing so, we ensure that non-implemented methods does not pass after the tests execution.

2. GREEN
The goal of this step is to write the minimum code needed to make the test pass

3. REFACTOR 

## Mock vs Stubs vs Fake

### Fake
* When is necessary override something
* What's it for? Its presence is just needed either to make the code work or to avoid effects caused by the absence of the object that the code might have that don't impact the test, however is it desireble that effect doesn't happen. In order to avoid that it is just necessary use mocks.
```java
//How to do it in Mockito
mock()
```

### Mock
*	Override External Dependencies
* Used to check if whether or not objects are being used 
	*  Test behavior

```java
//How to do it in Mockito
mock()
verify().myMethod()
```

### Stubs
*	Override External Dependencies
* Are used to the object to return some data 	
	*  Used to test Data
	* Test the outcome of the called method

```java
//How to do it in Mockito
mock()
when().thenReturn()
```

## Junit 

### Expecting An Exception  To Be  Thrown
The test will fail if no exception are thrown

#### Junit 5
```java
@Test
public void notValid(){

	Validator accountValidator = new AccountValidator()	
	assertThrows(NumberFormatException.class, () -> {validator.checkNumberAccount("001122")})
}
```

#### Junit 4
```java
@Test(expect = NumberFormatException.class)
public void notValid(){

	Validator accountValidator = new AccountValidator()
	validator.checkNumberAccount("001122")
}
```

### Asserts

#### assertTrue() or assertFalse()
```java
@Test  
public void checkAValid10DigitsISBN() {  
  
  boolean result = validator.checkISBN("0135781868");  
  assertTrue(result, "First   Value");  
  
  result = validator.checkISBN("ABCDEFGHIJ");  
  assertTrue(result, "Second Value");  
}
```

#### assertThrows()
```java
@Test  
void lessThan10Digits() {  
    assertThrows(NumberFormatException.class, () -> validator.checkISBN("134494164"));  
}
```
#### assertDoesNotThrow()

#### assertNotNull()
```java
@Test  
void valueIsNotNull() {  
    MySystem mySystem = new MySystem();
    String value = mySystem.getValue();
    assertNotNull(value);
}
```
#### assertEquals()
#### assertNotEquals()
#### assertArrayEquals()

### Assumptions

## Mockito


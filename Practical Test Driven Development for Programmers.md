
# Practical Test Driven Development

## Rules of TDD
1. **Test the expected outcome of an example**

2. **Don't pre-judge design... let your test drive it**

3. **Write the minimum code required to get the tests to pass**

4. **Each test should validate one single piece of logic**
	Some times more the one `assert` is required to validate the logic. But when working with more than one assert it must fit one of the following cases:  
	
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

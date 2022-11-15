
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.example.ex1.ContactManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContactManagerTest {

	private ContactManager contactManager;
	
	@BeforeAll 
	public static void setupAll() { 
		System.out.println("Should Print Before All Tests"); 
		} 
	
	@BeforeEach 
	public void setup() { 
		System.out.println("Instantiating Contact Manager"); 
		contactManager = new ContactManager(); 
		}
	
	@Test
	@DisplayName("Deve criar um Contact") 
	public void shouldCreateContact() { 
		contactManager.addContact("John", "Doe", "0123456789"); 
		assertFalse(contactManager.getAllContacts().isEmpty()); 
		assertEquals(1, contactManager.getAllContacts().size()); }

	@Test 
	@DisplayName("Should Not Create Contact When First Name is Null") 
	public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() { 
	Assertions.assertThrows(RuntimeException.class, () -> { 
	contactManager.addContact(null, "Doe", "0123456789"); 
	}); 
	} 
	@Test 
	@DisplayName("Should Not Create Contact When Last Name is Null") 
	public void shouldThrowRuntimeExceptionWhenLastNameIsNull() { 
	Assertions.assertThrows(RuntimeException.class, () -> { 
	contactManager.addContact("John", null, "0123456789"); 
	}); 
	} 
	
	@Test 
	@DisplayName("Should Not Create Contact When Phone Number is Null") 
	public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
	Assertions.assertThrows(RuntimeException.class, () -> { 
	contactManager.addContact("John", "Doe", null); 
	}); 
	} 
	
	@Test 
	@DisplayName("Phone Number should start with 0") 
	public void shouldTestPhoneNumberFormat() { 
	contactManager.addContact("John", "Doe", "0123456789"); 
	assertEquals(1, contactManager.getAllContacts().size()); 
	} 
	
	@Nested 
	class RepeatedTests { 
	@DisplayName("Repeat Contact Creation Test 5 Times") 
	@RepeatedTest(value = 5) 
	public void shouldTestContactCreationRepeatedly() { 
	contactManager.addContact("John", "Doe", "0123456789"); 
	assertFalse(contactManager.getAllContacts().isEmpty()); 
	assertEquals(1, contactManager.getAllContacts().size()); 
	} 
	} 
	
	@Nested 
	class ParameterizedTests { 
	@DisplayName("Phone Number should match the required Format") 
	@ParameterizedTest 
	@ValueSource(strings = {"0123456789", "0123456798", "0123456897"}) 
	public void shouldTestPhoneNumberFormatUsingValueSource(String phoneNumber) { 
	contactManager.addContact("John", "Doe", phoneNumber); 
	assertFalse(contactManager.getAllContacts().isEmpty()); 
	assertEquals(1, contactManager.getAllContacts().size()); 
	} 
	} 
	
	@DisplayName("Method Source Case - Phone Number should match the required Format") 
	@ParameterizedTest
	@MethodSource("phoneNumberList") 
	public void shouldTestPhoneNumberFormatUsingMethodSource(String phoneNumber) { 
	contactManager.addContact("John", "Doe", phoneNumber); 
	assertFalse(contactManager.getAllContacts().isEmpty()); 
	assertEquals(1, contactManager.getAllContacts().size()); 
	} 
	
	private static List<String> phoneNumberList() { 
	return Arrays.asList("0123456789", "0123456798", "0123456897"); 
	} 
	
	@Test 
	@DisplayName("Test Should Be Disabled") 
	@Disabled 
	public void shouldBeDisabled() { 
	throw new RuntimeException("Test Should Not be executed"); 
	} 
	
	@AfterEach 
	public void tearDown() { 
	System.out.println("Should Execute After Each Test"); 
	} 
	
	@AfterAll 
	public static void tearDownAll() { 
	System.out.println("Should be executed at the end of the Test"); 
	} 
	}

	


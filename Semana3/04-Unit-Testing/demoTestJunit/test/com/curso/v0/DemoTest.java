package com.curso.v0;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.lang.Integer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DemoTest {
	
//	@BeforeEach
//	void inicio() {
//	    System.out.println("@BeforeEach - executes before each test method in this class");
//	}
//	
//	@BeforeAll
//	static void setup() {
//		System.out.println("@BeforeAll - executes once before all test methods in this class");
//	}

	@Test
	@DisplayName("Prueba1")
	void test() {
		double d = 5.0;
		assertEquals(5.0, d);
	}
	
	@Test
	@DisplayName("Prueba2")
	void test2() {
		double d = 5.0;
		assertNotEquals(8.0, d);
	}
	
	@Test
	void lambdaExpressions() {
	    List<Integer> numbers = Arrays.asList(1, 2, 3);
	    
	    assertTrue(numbers.stream()
	      .mapToInt(Integer::intValue)
	      .sum() > 5, () -> "Sum should be greater than 5");
	}
	
	@Test
	void lambdaExpressions1() {
	    List<Integer> numbers = Arrays.asList(1, 2, 3);
	    
	    Stream<Integer> stream = numbers.stream();
	    IntStream intStream = stream.mapToInt(Integer::intValue);
	    int suma = intStream.sum();
	    
	    assertTrue(suma > 5, () -> "Error, sum should be greater than 5");
	}

	 @Test
	 void groupAssertions() {
	     int[] numbers = {0, 1, 2, 3, 4};
	     assertAll("numbers",
	         () -> assertEquals(numbers[0], 0),
	         () -> assertEquals(numbers[3], 3),
	         () -> assertEquals(numbers[4], 4)
	     );
	 }
	 
	 @Test
	 void shouldThrowException() {
	     Throwable exception = 
	    		 assertThrows(UnsupportedOperationException.class, () -> {
	       throw new UnsupportedOperationException("Not supported");
	     });
	     
	     assertEquals("Not supported", exception.getMessage());
	 }
	 
	 @Test
	 void assertThrowsException() {
	     String str = null;
	     assertThrows(IllegalArgumentException.class, () -> {
	       Integer.valueOf(str);
	     });
	     
	 }
	 
	 @Test
	 void assertThrowsException2() {
	     String str = null;
	     assertThrows(NullPointerException.class, () -> str.length() );
	     
	 }
	 
	 @Test
	 void assertThrowsException3() {
	     String str = null;
	     assertThrows(Throwable.class, () -> str.length() );
	     
	 }
	
	
}

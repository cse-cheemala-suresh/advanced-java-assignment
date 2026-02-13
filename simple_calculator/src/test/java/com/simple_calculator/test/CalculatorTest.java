/**
 * 
 */
package com.simple_calculator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import simple_calculator.Calculator;

/**
 * 
 */
public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("Test of Two Positive Numbers")
	public void testTwoAndTwoGivesFour() {
		assertEquals(5, calculator.add(2, 3));
	}

	@Test
	@DisplayName("Test of Two Positive Numbers")
	public void testFiveAndFourGivesNine() {
		assertEquals(9, calculator.add(5, 4), "Sum of 2 and 3 should be 9");
	}
	
	@RepeatedTest(3)
	@DisplayName("Test sum with repeated execution")
	void testSumRepeated() {
		assertEquals(10, calculator.add(5,5), "Sum of 5 and 5 is 10");
	}
	
	@Nested
	@DisplayName("Subtraction Tests")
	class SubtractionTests{
		@Test
		@DisplayName("Test subtraction of two numbers")
		void testFiveandFourGivesOne() {
			assertEquals(1, calculator.sub(5, 4), "5 - 4 should be 1");
		}
		
		@Test
		@DisplayName("Test subtraction of two numbers")
		void testEightandFourGivesOne() {
			assertEquals(4, calculator.sub(8, 4), "8 - 4 should be 4");
		}
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	@DisplayName("Test multiplication of numbers by 2")
	void testMultiplyByTwo(int num) {
		assertEquals(num * 2, calculator.mul(num, 2), "Multiplication of 2 with nums");
	}
	
	@ParameterizedTest
	@CsvSource({"2, 2, 4", "2, 3, 6", "4, 4, 16"})
	void testMultiply(int x, int y, int expected) {
		assertEquals(expected, calculator.mul(x, y));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/calculator-data.csv", numLinesToSkip = 1)
	@DisplayName("Test sum using CSV file")
	void testSumUsnigCsvFile(int a, int b, int expectedSum) {
		assertEquals(expectedSum, calculator.add(a, b));
	}
	
	@Test
	@DisplayName("Test division with non-division denominator")
	void testDivide() {
		assertEquals(2.0, calculator.div(10, 5), "10 divided by 5 should be 2");
	}
	
	@Test
	@DisplayName("Test division by zero")
	void testDivideByZero() {
		assertThrows(IllegalArgumentException.class, () -> calculator.div(2, 0));
	}
}

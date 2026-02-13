/**
 * 
 */
package simple_calculator_mockito_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import simple_calculator_mockito.Calculator;
import simple_calculator_mockito.MathService;

/**
 * 
 */
@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	@Mock
	private MathService mathService; //Dependency mocked
	@InjectMocks
	private Calculator calculator; //class under test
	
	@Test
	void testAdd() {
		//Arrange - stub
		when(mathService.add(10, 20)).thenReturn(30);
		//Assert
		assertEquals(30, calculator.add(10, 20));
		//Verify interaction
		verify(mathService).add(10, 20);
	}
}

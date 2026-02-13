/**
 * 
 */
package simple_calculator_mockito;

/**
 * 
 */
public class Calculator {
	private MathService mathService;
	
	public Calculator() {
		
	}
	public Calculator(MathService mathService) {
		this.mathService = mathService;
	}
	
	public int add(int a, int b) {
		return mathService.add(a, b);
	}
}

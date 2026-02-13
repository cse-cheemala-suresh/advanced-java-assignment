/**
 * 
 */
package employee_data_analysis_using_collection_and_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 */
public class EmployeeUtility {
	public static void empDetails() {
		List<Employee> employeeList = Arrays.asList(
				new Employee(101, "Suresh", "IT", "Developer", 1000000, 2),
				new Employee(102, "Ravi", "HR", "Recruiter", 450000, 5),
			    new Employee(103, "Amit", "Finance", "Analyst", 600000, 3),
			    new Employee(104, "Neha", "IT", "Tester", 550000, 4),
			    new Employee(105, "Priya", "Sales", "Sales Executive", 500000, 6),
			    new Employee(106, "Kiran", "IT", "Manager", 1200000, 8),
			    new Employee(107, "Anjali", "Marketing", "SEO Specialist", 480000, 2),
			    new Employee(108, "Vikram", "Operations", "Supervisor", 650000, 7)
				);
		double avg = employeeList.stream()
				.mapToDouble(Employee :: getSalary)
				.average()
				.orElse(0.0);
		System.out.println("Average Salary : " + avg);
		System.out.println();
		
		double highestSalary = employeeList.stream()
				.mapToDouble(Employee :: getSalary)
				.max()
				.orElse(0.0);
		System.out.println("Employee with Highest Salary : " + highestSalary);
		System.out.println();
		
		List<Employee> above80K = employeeList.stream()
				.filter(e -> e.getSalary() > 800000)
				.collect(Collectors.toList());
		System.out.println("Employee with salary above 80000 : ");
		above80K.stream().forEach(System.out :: println);
		System.out.println();
		
		Map<String, Long> countEmp = employeeList.stream()
				.collect(Collectors
						.groupingBy(Employee :: getDepartment, Collectors
								.counting()
								));
		System.out.println("No of Employees in Each Department : " + countEmp);
		System.out.println();
		
		List<Employee> employeeList1 = employeeList.stream()
				.filter(e -> e.getDepartment()
						.equals("IT"))
				.filter(e -> e.getYearsOfExperience() > 5)
				.collect(Collectors.toList());
		System.out.println("Employees in IT department with more than 5 years of Experience : ");
		employeeList1.stream().forEach(System.out::println);
	}
}

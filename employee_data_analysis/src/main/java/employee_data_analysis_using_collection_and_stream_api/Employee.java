/**
 * 
 */
package employee_data_analysis_using_collection_and_stream_api;

/**
 * 
 */
public class Employee {
	private int employeeId;
	private String name;
	private String department;
	private String designation;
	private double salary;
	private double yearsOfExperience;
	/**
	 * @param employeeId
	 * @param name
	 * @param designation
	 * @param department
	 * @param salary
	 * @param yearsOfExperience
	 */
	public Employee(int employeeId, String name, String department, String designation, double salary,
			double yearsOfExperience) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	/**
	 * @return the employeeId
	 */
	public final int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public final void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * @return the yearsOfExperience
	 */
	public double getYearsOfExperience() {
		return yearsOfExperience;
	}
	/**
	 * @param yearsOfExperience the yearsOfExperience to set
	 */
	public void setYearsOfExperience(double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation
				+ ", department=" + department + ", salary=" + salary + ", yearsOfExperience=" + yearsOfExperience
				+ "]";
	}
	
}

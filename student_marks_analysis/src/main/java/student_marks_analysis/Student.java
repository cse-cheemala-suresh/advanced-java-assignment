/**
 * 
 */
package student_marks_analysis;

/**
 * 
 */
public class Student {
	private int studentId;
	private String name;
	private double sub1;
	private double sub2;
	private double sub3;
	/**
	 * @param studentId
	 * @param name
	 * @param sub1
	 * @param sub2
	 * @param sub3
	 */
	public Student(int studentId, String name, double sub1, double sub2, double sub3) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	/**
	 * 
	 */
	public Student() {
		super();
	}
	/**
	 * @return the studentId
	 */
	public final int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public final void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sub1
	 */
	public final double getSub1() {
		return sub1;
	}
	/**
	 * @param sub1 the sub1 to set
	 */
	public final void setSub1(double sub1) {
		this.sub1 = sub1;
	}
	/**
	 * @return the sub2
	 */
	public final double getSub2() {
		return sub2;
	}
	/**
	 * @param sub2 the sub2 to set
	 */
	public final void setSub2(double sub2) {
		this.sub2 = sub2;
	}
	/**
	 * @return the sub3
	 */
	public final double getSub3() {
		return sub3;
	}
	/**
	 * @param sub3 the sub3 to set
	 */
	public final void setSub3(double sub3) {
		this.sub3 = sub3;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3="
				+ sub3 + "]";
	}
	
}

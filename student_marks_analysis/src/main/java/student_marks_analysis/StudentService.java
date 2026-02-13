/**
 * 
 */
package student_marks_analysis;

/**
 * 
 */
public class StudentService {
	private Student student;
	public StudentService(Student student) {
		this.student = student;
	}
	public double totalMarks() {
		return student.getSub1() + student.getSub2() + student.getSub3();
	}
	public double avgMarks() {
		return totalMarks()/3;
	}
	public boolean isPassed() {
		return avgMarks() >= 40;
	}
}

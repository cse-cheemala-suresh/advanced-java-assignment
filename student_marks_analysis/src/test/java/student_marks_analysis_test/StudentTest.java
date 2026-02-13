/**
 * 
 */
package student_marks_analysis_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import student_marks_analysis.Student;
import student_marks_analysis.StudentService;

/**
 * 
 */
public class StudentTest {
	private StudentService sc;
	@BeforeEach
	void setUp() {
		Student student = new Student(101, "Suresh", 70, 83, 90);
		sc = new StudentService(student);
	}
	
	@Test
	@DisplayName("Testing total Marks")
	void passingMarks() {
		assertEquals(243, sc.totalMarks());
	}
	
	@Test
	@DisplayName("Checking student avg")
	void avgCheck() {
		assertEquals(81.0, sc.avgMarks(), 0.01);
	}
	
	@Test
	@DisplayName("Check pass")
	void passCheck() {
		assertTrue(sc.isPassed());
	}
	
	@Test
	@DisplayName("Check fail")
	void failCheck() {
		assertFalse(sc.isPassed());
	}
}

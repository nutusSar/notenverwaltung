package datenklassen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataclasses.StudentSubject;

class StudentSubjectTest {
	private StudentSubject s;

	@BeforeEach
	void init() throws Exception {
		s = new StudentSubject();
	}

	@Test
	void create() {
		assertEquals(null, s.getStudent2Subjects());
		assertEquals(null, s.getSubject2Students());
		assertEquals(null, s.getStSb2Grades());
	}
	
	@Test
	void Student2Subjects() {
		String[] subjects = {"math"};
		HashMap<String, String[]> student2Subjects = new HashMap<String, String[]>();
		student2Subjects.put("Nico", subjects);
		s.setStudent2Subjects(student2Subjects);
		assertEquals(student2Subjects, s.getStudent2Subjects());
	}
	
	@Test
	void Subject2Students() {
		String[] students = {"Nico"};
		HashMap<String, String[]> subject2Students = new HashMap<String, String[]>();
		subject2Students.put("math", students);
		s.setSubject2Students(subject2Students);
		assertEquals(subject2Students, s.getSubject2Students());
	}
	
	@Test
	void StSb2Grades() {
		double[] grades = {1.0};
		HashMap<String, double[]> stSb2Grades  = new HashMap<String, double[]>();
		stSb2Grades.put("NicoMath", grades);
		s.setStSb2Grades(stSb2Grades);
		assertEquals(stSb2Grades, s.getStSb2Grades());
	}
}

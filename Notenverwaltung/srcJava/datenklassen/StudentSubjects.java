package datenklassen;

import java.util.HashMap;
import java.util.Map;



public class StudentSubjects {
	private HashMap<String, String[]> student2Subjects;
	private HashMap<String, String[]> subject2Students;
	private HashMap<String, double[]> stSb2Grades;
	
	public HashMap<String, String[]> getStudent2Subjects() {
		return student2Subjects;
	}
	public void setStudent2Subjects(HashMap<String, String[]> student2Subjects) {
		this.student2Subjects = student2Subjects;
	}
	public HashMap<String, String[]> getSubject2Students() {
		return subject2Students;
	}
	public void setSubject2Students(HashMap<String, String[]> subject2Students) {
		this.subject2Students = subject2Students;
	}
	public HashMap<String, double[]> getStSb2Grades() {
		return stSb2Grades;
	}
	public void setStSb2Grades(HashMap<String, double[]> stSb2Grades) {
		this.stSb2Grades = stSb2Grades;
	}

	
	

}

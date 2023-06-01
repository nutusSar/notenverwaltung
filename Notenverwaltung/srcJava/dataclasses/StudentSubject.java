package dataclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class StudentSubject {
	private HashMap<String, ArrayList<Subject>> student2Subjects = new HashMap<String, ArrayList<Subject>>();
	private HashMap<String, ArrayList<Student>> subject2Students = new HashMap<String, ArrayList<Student>>();
	private HashMap<String, ArrayList<Double>> stSb2Grades = new HashMap<String, ArrayList<Double>>();
	
	
	public HashMap<String, ArrayList<Subject>> getStudent2Subjects() {
		return student2Subjects;
	}
	public void setStudent2Subjects(HashMap<String, ArrayList<Subject>> student2Subjects) {
		this.student2Subjects = student2Subjects;
	}
	public HashMap<String, ArrayList<Student>> getSubject2Students() {
		return subject2Students;
	}
	public void setSubject2Students(HashMap<String, ArrayList<Student>> subject2Students) {
		this.subject2Students = subject2Students;
	}
	public HashMap<String, ArrayList<Double>> getStSb2Grades() {
		return stSb2Grades;
	}
	public void setStSb2Grades(HashMap<String, ArrayList<Double>> stSb2Grades) {
		this.stSb2Grades = stSb2Grades;
	}
	

	
	

}

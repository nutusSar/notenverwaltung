package dataclasses;

import java.util.HashMap;

public class Model {
	
	private HashMap<String, SClass> classes = new HashMap<String, SClass>();
	private HashMap<String, Student> students = new HashMap<String, Student>();
	private HashMap<String, Subject> subjects = new HashMap<String, Subject>();
	private StudentSubject s2s = new StudentSubject();
	
	public HashMap<String, SClass> getClasses() {
		return classes;
	}
	public void setClasses(HashMap<String, SClass> classes) {
		this.classes = classes;
	}
	public HashMap<String, Student> getStudents() {
		return students;
	}
	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}
	public HashMap<String, Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(HashMap<String, Subject> subjects) {
		this.subjects = subjects;
	}
	public StudentSubject getS2s() {
		return s2s;
	}
	public void setS2s(StudentSubject s2s) {
		this.s2s = s2s;
	}

}

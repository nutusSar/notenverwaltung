package dataclasses;

import java.util.ArrayList;
import java.util.HashMap;


/**Model for the n to 0-12 relationship between student <> module
 * 
 * @author nutusSar
 *
 */
public class StudentSubject {
	private HashMap<String, ArrayList<Subject>> student2Subjects = new HashMap<String, ArrayList<Subject>>();
	private HashMap<String, ArrayList<Student>> subject2Students = new HashMap<String, ArrayList<Student>>();
	private HashMap<String, ArrayList<Grade>> stSb2Grades = new HashMap<String, ArrayList<Grade>>();
	private HashMap<String, Double> stSb2Average = new HashMap<String, Double>();
	
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
	public HashMap<String, ArrayList<Grade>> getStSb2Grades() {
		return stSb2Grades;
	}
	public void setStSb2Grades(HashMap<String, ArrayList<Grade>> stSb2Grades) {
		this.stSb2Grades = stSb2Grades;
	}
	public HashMap<String, Double> getStSb2Average() {
		return stSb2Average;
	}
	public void setStSb2Average(HashMap<String, Double> stSb2Average) {
		this.stSb2Average = stSb2Average;
	}
	
	

}

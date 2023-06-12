package dataclasses;

import java.util.ArrayList;

/**Model for one school class
 * 
 * @author nutusSar
 *
 */
public class SClass {
	private String name;
	private String id;
	private ArrayList<Student> students = new ArrayList<Student>();
	private double average = -1.0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	

}

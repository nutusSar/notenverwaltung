package dataclasses;

public class Student implements Comparable<Student>{
	private String name;
	private String id;
	private String sclass;
	private double average = -1.0;
	private boolean abitur;
	
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
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public boolean isAbitur() {
		return abitur;
	}
	public void setAbitur(boolean abitur) {
		this.abitur = abitur;
	}
	
	@Override
	public int compareTo(Student o) {
		return(this.getId().compareTo(o.getId()));
	}
}

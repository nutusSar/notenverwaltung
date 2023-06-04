package dataclasses;

public class Subject implements Comparable<Subject>{
	private String name;
	private String id;
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
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	@Override
	public int compareTo(Subject o) {
		return(this.getId().compareTo(o.getId()));
	}

}

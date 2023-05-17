package datenklassen;

public class Student {
	private String name;
	private int id;
	private double average;
	private boolean abitur;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}

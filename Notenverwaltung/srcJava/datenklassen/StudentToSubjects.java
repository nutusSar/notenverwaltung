package datenklassen;

import java.util.HashMap;
import java.util.Map;



public class StudentToSubjects {
	private HashMap<String, double[]> map;

	
	public HashMap<String, double[]> getMap() {
		return map;
	}
	public void setMap(HashMap<String, double[]> map) {
		this.map = map;
	}

	
	public void addEntry(int studentID, int subjectID, double[] grades) {
		String key =  Integer.toString(studentID) + Integer.toString(subjectID);
		map.put(key, grades);
	}
	
	public void delEntry(int studentID, int subjectID) {
		String key = Integer.toString(studentID) + Integer.toString(subjectID);
		map.remove(key);
	}
	

}

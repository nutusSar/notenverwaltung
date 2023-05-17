package datenklassen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentToSubjectsTest {
	private StudentToSubjects s;

	@BeforeEach
	void init() throws Exception {
		s = new StudentToSubjects();
	}

	@Test
	void create() {
		assertEquals(null, s.getMap());
	}
	
	@Test
	void map() {
		double[] grades = {1.0};
		HashMap<String, double[]> s2s = new HashMap<String, double[]>();
		s2s.put("Nico", grades);
		s.setMap(s2s);
		assertEquals(s2s, s.getMap());
	}
	
	@Test
	void addEntry() {
		double[] grades = {1.0};
		HashMap<String, double[]> s2s = new HashMap<String, double[]>();
		s2s.put("123456", grades);
		s.setMap(new HashMap<String, double[]>());
		s.addEntry(123, 456, grades);
		assertEquals(s2s, s.getMap());
	}
	
	@Test
	void delEntry() {
		double[] grades = {1.0};
		HashMap<String, double[]> s2s = new HashMap<String, double[]>();
		s2s.put("123456", grades);
		s.setMap(s2s);
		s.delEntry(123, 456);
		assertEquals(new HashMap<String, double[]>(), s.getMap());
	}

}

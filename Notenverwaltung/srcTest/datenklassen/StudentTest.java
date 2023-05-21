package datenklassen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
	private Student s;

	@BeforeEach
	void init() {
		s = new Student();
	}

	@Test
	void create() {
		assertEquals(null, s.getName());
		assertEquals(0, s.getId());
		assertEquals(0.0, s.getAverage());
		assertEquals(false, s.isAbitur());
	}
	
	@Test
	void name() {
		s.setName("Nico");
		assertEquals("Nico", s.getName());
	}
	
	@Test
	void id() {
		s.setId(9);
		assertEquals(9, s.getId());
	}
	
	@Test
	void average() {
		s.setAverage(1.0);
		assertEquals(1.0, s.getAverage());
	}

	@Test
	void abitur() {
		s.setAbitur(true);
		assertEquals(true, s.isAbitur());
	}
}

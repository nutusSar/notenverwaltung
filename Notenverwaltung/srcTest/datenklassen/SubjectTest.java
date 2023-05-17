package datenklassen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubjectTest {
	private Subject s;

	@BeforeEach
	void init() {
		s = new Subject();
	}

	@Test
	void create() {
		assertEquals(null, s.getName());
		assertEquals(0, s.getId());
		assertEquals(0.0, s.getAverage());
	}
	
	@Test
	void name() {
		s.setName("Mathe");
		assertEquals("Mathe", s.getName());
	}
	
	@Test
	void id() {
		s.setId(9);
		assertEquals(9, s.getId());
	}

}

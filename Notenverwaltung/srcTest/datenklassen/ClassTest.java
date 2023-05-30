package datenklassen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataclasses.Class;
import dataclasses.Student;

class ClassTest {
	
	private Class c;

	@BeforeEach
	void init() {
		c = new Class();
	}

	@Test
	void create() {
		assertEquals(null, c.getName());
		assertEquals(0, c.getId());
		assertEquals(null, c.getStudents());
		assertEquals(0.0, c.getAverage());
	}
	
	@Test
	void name() {
		c.setName("Nico");
		assertEquals("Nico", c.getName());
	}
	
	@Test
	void id() {
		c.setId(9);
		assertEquals(9, c.getId());
	}
	
	@Test
	void students() {
		Student student = new Student();
		Student[] students = {student};
		c.setStudents(students);
		assertEquals(students, c.getStudents());
	}
	
	@Test
	void average() {
		c.setAverage(1.0);
		assertEquals(1.0, c.getAverage());
	}

}

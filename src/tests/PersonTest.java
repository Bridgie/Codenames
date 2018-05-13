package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import code.Person;

public class PersonTest {
	
	// tests person getters (RY)
	@Test
	public void checkPersonGetters() {
		Person p = new Person("theirRole");
		assertEquals("theirRole", p.getRole());
		assertFalse (p.getRevealed());
	}
	
	//tests person setters (RY)
	@Test
	public void checkPersonSetters() {
		Person p = new Person("");
		p.setRole("Role");
		p.setRevealed(true);
		assertEquals("Role", p.getRole());
		assertTrue(p.getRevealed());
	}
	
}

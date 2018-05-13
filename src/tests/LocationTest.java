package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import org.junit.Test;
import code.Location;
import code.Person;

public class LocationTest {
	
	//tests Location Constructors. RY
	@Test
	public void checkConstructors() {
		Person p = new Person("theirRole");
		Location l = new Location("theirCodeName", p);
		assertEquals("theirCodeName", l.getCodename());
		assertEquals(p, l.getPerson());
		assertFalse(l.is_selected());
	}
	
	//tests Location _selected setter. RY
	@Test
	public void checkSelectedSetter() {
		Person p = new Person("role");
		Location l = new Location("codeName", p);
		l.set_selected(true);
		assertTrue(l.is_selected());
	}
	
}

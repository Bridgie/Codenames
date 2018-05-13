package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import code.Board;
import code.Location;
import code.Person;

public class BoardTest {

	// Test to make sure the board is initialized with a full array of locations.
	@Test
	public void locationsTester() {
		Board tester = new Board(false);
		int expected = 25;
		int actual = tester.getLocations().size();

		assertEquals(expected, actual);
	}
	
	//Ensures it is red teams move when the board is initialized.
	@Test
	public void teamStartTester() {
	Board tester = new Board(false);
	
	
	assertEquals(tester.getGame().getTurn(),0);
	
	}
	
	// Tests to make sure that the board is filled with correct number of characters
	@Test
	public void characterTester() {
		Board tester = new Board(false);
		int expectedRedAgents = 9;
		int expectedBlueAgents = 8;
		int expectedAssassin = 1;
		int expectedInnocents = 7;

		int actualRedAgents = 0;
		int actualBlueAgents = 0;
		int actualAssassin = 0;
		int actualInnocents = 0;

		for (int i = 0; i < tester.getLocations().size(); i++) {
			if (tester.getLocation(i).getPerson().getRole().equals("RedAgent")) {
				actualRedAgents += 1;
			} else if (tester.getLocation(i).getPerson().getRole().equals("BlueAgent")) {
				actualBlueAgents += 1;
			} else if (tester.getLocation(i).getPerson().getRole().equals("Assassin")) {
				actualAssassin += 1;
			} else if (tester.getLocation(i).getPerson().getRole().equals("Innocent")) {
				actualInnocents += 1;
			}
		}

		assertEquals(expectedRedAgents, actualRedAgents);
		assertEquals(expectedBlueAgents, actualBlueAgents);
		assertEquals(expectedAssassin, actualAssassin);
		assertEquals(expectedInnocents, actualInnocents);

	}
	
	
	
	/*
	 * Tests the update locations method for a true return, a count decrement, and the location update
	 */
	@Test
	public void updateLocationsTrueTest() {	
		Board tester = new Board(false);
		tester.getGame().setCount(1);
		
		Person pete = new Person("RedAgent");
		Location testLoc = new Location("Africa", pete);
		
		ArrayList<Location> testList = new ArrayList<Location>(); 
		testList.add(testLoc);
		tester.setLocations(testList);
		
		tester.updateLocations(0, tester, "Africa");
		
		assertEquals(tester.getGame().getCount(), 0);
		assertEquals(tester.getLocation(0).getPerson().getRevealed(), true);
		assertEquals(tester.updateLocations(0, tester, "Africa"), true);
	}
	
	/*
	 * Tests the update locations method for a false return, a count decrement, and the location update
	 */
	@Test
	public void updateLocationsFalseTest() {	
		Board tester = new Board(false);
		tester.getGame().setCount(1);
		tester.getGame().setTurn(1);
		
		Person pete = new Person("BlueAgent");
		Location testLoc = new Location("Africa", pete);
		
		ArrayList<Location> testList = new ArrayList<Location>(); 
		testList.add(testLoc);
		tester.setLocations(testList);
		
		tester.updateLocations(0, tester, "Africa");
		
		assertEquals(tester.getGame().getCount(), 0);
		assertEquals(tester.getLocation(0).getPerson().getRevealed(), true);
		assertEquals(tester.updateLocations(0, tester, "Africa"), false);
	}
	
}

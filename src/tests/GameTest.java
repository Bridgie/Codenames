package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import code.Game;
import code.Location;
import code.Person;

public class GameTest {

	// Tests to make sure the it used to track which teams turn it currently is on
	// this instance of board is initialized to 3, representative of red, correctly.
	@Test
	public void turnTester() {
		Game tester = new Game();
		assertEquals(tester.getTurn(), 3);
	}

	/*
	 * Checks codenames are assigned on random
	 * 
	 * 
	 * 
	 * 
	 * NOTE: since codenames are generated at random this test will return false AND
	 * true if run multiple times
	 */

	@Test
	public void randomAssignmentsTest2Team() {
		Person thisPerson1 = new Person("Assassin");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson3 = new Person("BlueAgent");
	
		Game myGame = new Game();
		
		myGame.setTeam(false);
		
		ArrayList<Person> listofPersons = new ArrayList<Person>();

		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson3);
		
			ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");
			assertEquals(3, listofLocations.size());
			//assertEquals("FOURTH", listofLocations.get(0).getCodename());
	
	}
	
	@Test
	public void randomAssignmentsTest3Team() {
		Person thisPerson1 = new Person("Assassin");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson4 = new Person("GreenAgent");
	
		Game myGame = new Game();
		
		myGame.setTeam(true);
		
		ArrayList<Person> listofPersons = new ArrayList<Person>();

		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson4);
		
			
			
			ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");
			//assertEquals("FOURTH", listofLocations.get(0).getCodename());
			assertEquals(4, listofLocations.size());
			//assertEquals("FOURTH", listofLocations.get(0).getCodename());
	

	}
	

	/*
	 * checks if clue was legal
	 * 
	 * 
	 * returns true if clue == one of the codenames
	 */
	@Test
	public void checkIfClueLegalTestTrue2Team() {
		Person thisPerson1 = new Person("Assassin");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson3 = new Person("BlueAgent");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson3);

		Game myGame = new Game();
		myGame.setTeam(false);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		boolean expected = true;
		boolean actual = myGame.checkIfClueLegal("SKY", listofLocations);

		assertEquals(expected, actual);

	}
	
	
	
	/*
	 * checks if clue was legal
	 * 
	 * 
	 * returns true if clue == one of the codenames
	 */
	@Test
	public void checkIfClueLegalTestTrue3Team() {
		Person thisPerson1 = new Person("Assassin");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson4 = new Person("GreenAgent");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson4);

		Game myGame = new Game();
		myGame.setTeam(true);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		boolean expected = true;
		boolean actual = myGame.checkIfClueLegal("SKY", listofLocations);

		assertEquals(expected, actual);

	}

	/*
	 * This test checks what checkIfCLueLegal returns when clue == one of the
	 * codenames should return false;
	 */
	@Test
	public void checkIfClueLegalTestFalse2Team() {
		Person thisPerson1 = new Person("Assassin");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson3 = new Person("BlueAgent");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson3);

		Game myGame = new Game();
		
		myGame.setTeam(false);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		boolean expected = false;
		boolean actual = myGame.checkIfClueLegal("SECOND", listofLocations);

		assertEquals(expected, actual);

	}
	
	
	
	/*
	 * This test checks what checkIfCLueLegal returns when clue == one of the
	 * codenames should return false;
	 */
	@Test
	public void checkIfClueLegalTestFalse3Team() {
		Person thisPerson1 = new Person("Assassin");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson4 = new Person("GreenAgent");


		ArrayList<Person> listofPersons = new ArrayList<Person>();

		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson4);

		Game myGame = new Game();
		
		myGame.setTeam(true);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		boolean expected = false;
		boolean actual = myGame.checkIfClueLegal("SECOND", listofLocations);

		assertEquals(expected, actual);

	}

	//Checks to see if the isWinning method will return true for the red team 
    // if there are more revealed red agents in the list of locations for a game.
	@Test
	public void redWinningTest2Team() {
		
		Game myGame = new Game();

		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson1 = new Person("RedAgent");
		Person thisPerson0 = new Person("BlueAgent");
		
		thisPerson2.setRevealed(true);
		thisPerson1.setRevealed(true);
		thisPerson0.setRevealed(false);
		
		
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson0);
		
		myGame.setTeam(false);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "RedAgent") {
				listofLocations.get(i).getPerson().setRevealed(true);
			}
		}
		
		String team = "Red";
		boolean check = myGame.isWinning(team, listofLocations);
		
		assertEquals(true, check);
		
	}
	
	//Checks to see if the isWinning method will return true for the red team 
    // if there are more revealed red agents in the list of locations for a game.
	@Test
	public void redWinningTest3Team() {
		
		Game myGame = new Game();

		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson3 = new Person("GreenAgent");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson1 = new Person("RedAgent");
		Person thisPerson0 = new Person("BlueAgent");
		
		thisPerson3.setRevealed(false);
		thisPerson2.setRevealed(true);
		thisPerson1.setRevealed(true);
		thisPerson0.setRevealed(false);
		
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson0);
		
		
		myGame.setTeam(true);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "RedAgent") {
				listofLocations.get(i).getPerson().setRevealed(true);
			}
		}
		
		String team = "Red";
		boolean check = myGame.isWinning(team, listofLocations);
		
		assertEquals(true, check);
	
	}
	

	//Checks to see if the isWinning method will return true for the blue team 
    // if there are more revealed blue agents in the list of locations for a game.
	@Test
	public void blueWinningTest2Team() {
		
		Game myGame = new Game();

		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson2 = new Person("BlueAgent");
		Person thisPerson1 = new Person("BlueAgent");
		Person thisPerson0 = new Person("RedAgent");
		
		thisPerson2.setRevealed(true);
		thisPerson1.setRevealed(true);
		thisPerson0.setRevealed(false);
		
		
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson0);
		
		myGame.setTeam(false);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "BlueAgent") {
				listofLocations.get(i).getPerson().setRevealed(true);
			}
		}
		
		String team = "Blue";
		boolean check = myGame.isWinning(team, listofLocations);
		
		assertEquals(true, check);
		
	}
	
	//Checks to see if the isWinning method will return true for the blue team 
    // if there are more revealed blue agents in the list of locations for a game.
	@Test
	public void blueWinningTest3Team() {
		
		Game myGame = new Game();

		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson3 = new Person("GreenAgent");
		Person thisPerson2 = new Person("BlueAgent");
		Person thisPerson1 = new Person("BlueAgent");
		Person thisPerson0 = new Person("RedAgent");
		
		thisPerson3.setRevealed(false);
		thisPerson2.setRevealed(true);
		thisPerson1.setRevealed(true);
		thisPerson0.setRevealed(false);
		
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson0);
		
		myGame.setTeam(true);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "BlueAgent") {
				listofLocations.get(i).getPerson().setRevealed(true);
			}
		}
		
		String team = "Blue";
		boolean check = myGame.isWinning(team, listofLocations);
		
		assertEquals(true, check);
		
	}
	
	
	//Checks to see if the isWinning method will return true for the blue team 
    // if there are more revealed blue agents in the list of locations for a game.
	@Test
	public void greenWinningTest3Team() {
		
		Game myGame = new Game();

		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson3 = new Person("GreenAgent");
		Person thisPerson2 = new Person("GreenAgent");
		Person thisPerson1 = new Person("BlueAgent");
		Person thisPerson0 = new Person("RedAgent");
		
		thisPerson3.setRevealed(true);
		thisPerson2.setRevealed(true);
		thisPerson1.setRevealed(false);
		thisPerson0.setRevealed(false);
		
		
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson0);
		
		myGame.setTeam(true);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "BlueAgent") {
				listofLocations.get(i).getPerson().setRevealed(true);
			}
		}
		
		String team = "Green";
		boolean check = myGame.isWinning(team, listofLocations);
		
		assertEquals(true, check);
		
	}

	@Test
	public void notWinningBlueTest2Team() {
		Game myGame = new Game();
		myGame.setTeam(false);
		
		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson1 = new Person("BlueAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson0 = new Person("RedAgent");
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");
		
		thisPerson1.setRevealed(false);
		thisPerson3.setRevealed(false);
		thisPerson0.setRevealed(true);		//red team is winning;
		
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson0);
		listofPersons.add(thisPerson3);

		
		if(myGame.getTeam()) {
			Person thisPerson2 = new Person("GreenAgent");
			thisPerson2.setRevealed(false);
			listofPersons.add(thisPerson2);
		}

		String team = "Blue";
		boolean check = myGame.isWinning(team, listofLocations);
		assertEquals(false, check );

	}
	
	
	@Test
	public void notWinningBlueTest3Team() {
		Game myGame = new Game();
		myGame.setTeam(true);
		
		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson2 = new Person("GreenAgent");
		Person thisPerson1 = new Person("BlueAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson0 = new Person("RedAgent");
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");
		
		thisPerson2.setRevealed(false);
		thisPerson1.setRevealed(false);
		thisPerson3.setRevealed(false);
		thisPerson0.setRevealed(true);		//red team is winning;
		
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson0);
		listofPersons.add(thisPerson3);


		String team = "Blue";
		boolean check = myGame.isWinning(team, listofLocations);
		assertEquals(false, check );

	}
	
	@Test
	public void notWinningRedTest2Team() {
		Game myGame = new Game();

		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson1 = new Person("BlueAgent");
		Person thisPerson0 = new Person("RedAgent");
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");
		
		thisPerson3.setRevealed(true);
		thisPerson1.setRevealed(true);		//blue is winning
		thisPerson0.setRevealed(false);
	
		
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson0);
		
		if(myGame.getTeam()) {
			Person thisPerson2 = new Person("GreenAgent");
			thisPerson2.setRevealed(false);
			listofPersons.add(thisPerson2);
		}

		String team = "Red";
		boolean check = myGame.isWinning(team, listofLocations);
		assertEquals(false, check );

	}
	
	@Test
	public void notWinningRedTest3Team() {
		Game myGame = new Game();
		myGame.setTeam(true);
		
		ArrayList<Person> listofPersons = new ArrayList<Person>();
		
		Person thisPerson2 = new Person("GreenAgent");
		Person thisPerson1 = new Person("BlueAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson0 = new Person("RedAgent");
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");
		
		thisPerson2.setRevealed(true);			//green team is winning
		thisPerson1.setRevealed(false);
		thisPerson3.setRevealed(false);
		thisPerson0.setRevealed(false);		
		
		listofPersons.add(thisPerson1);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson0);
		listofPersons.add(thisPerson3);


		String team = "Red";
		boolean check = myGame.isWinning(team, listofLocations);
		assertEquals(false, check );
	}
	

	@Test
	public void assassinRevealedBluelosses2Team() {

		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson1 = new Person("Assassin");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		thisPerson1.setRevealed(true);

		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);

		Game myGame = new Game();
		myGame.setTurn(2);				//sets the turn to blue team
		myGame.setTeam(false);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "Assassin") {
				listofLocations.get(i).getPerson().setRevealed(true);
				
			}
		}

		String expected = "Blue";
		String actual = myGame.assassinRevealed(listofLocations);

		assertEquals(expected, actual);

	}
	
	@Test
	public void assassinRevealedBluelossesTest3Team() {

		Person thisPerson4 = new Person("BlueAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson1 = new Person("Assassin");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		thisPerson1.setRevealed(true);

		listofPersons.add(thisPerson4);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);

		Game myGame = new Game();
		myGame.setTurn(2);				//sets the turn to blue team
		myGame.setTeam(true);
		
		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "Assassin") {
				listofLocations.get(i).getPerson().setRevealed(true);
				
			}
		}

		String expected = "Blue";
		String actual = myGame.assassinRevealed(listofLocations);

		assertEquals(expected, actual);

	}
	

	@Test
	public void assassinRevealedRedLossesTest2Team() {

		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson1 = new Person("Assassin");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		thisPerson1.setRevealed(true);

		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);

		Game myGame = new Game();

		myGame.setTeam(false);
		myGame.setTurn(1);

		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "Assassin") {
				listofLocations.get(i).getPerson().setRevealed(true);
				
			}
		}

		String expected = "Red";
		String actual = myGame.assassinRevealed(listofLocations);

		assertEquals(expected, actual);

	}
	
	@Test
	public void assassinRevealedRedLossesTest3Team() {

		Person thisPerson4 = new Person("GreenAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson1 = new Person("Assassin");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		thisPerson1.setRevealed(true);

		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson4);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);

		Game myGame = new Game();

		myGame.setTeam(true);
		myGame.setTurn(1);

		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "Assassin") {
				listofLocations.get(i).getPerson().setRevealed(true);
				
			}
		}

		String expected = "Red";
		String actual = myGame.assassinRevealed(listofLocations);

		assertEquals(expected, actual);

	}
	
	@Test
	public void assassinRevealedGreenLossesTest3Team() {

		Person thisPerson4 = new Person("GreenAgent");
		Person thisPerson3 = new Person("BlueAgent");
		Person thisPerson2 = new Person("RedAgent");
		Person thisPerson1 = new Person("Assassin");

		ArrayList<Person> listofPersons = new ArrayList<Person>();

		thisPerson1.setRevealed(true);

		listofPersons.add(thisPerson4);
		listofPersons.add(thisPerson3);
		listofPersons.add(thisPerson2);
		listofPersons.add(thisPerson1);

		Game myGame = new Game();

		myGame.setTeam(true);
		myGame.setTurn(3);

		ArrayList<Location> listofLocations = myGame.randomAssignments(listofPersons, "TestWords.txt");

		for (int i = 0; i < listofLocations.size(); i++) {
			if (listofLocations.get(i).getPerson().getRole() == "Assassin") {
				listofLocations.get(i).getPerson().setRevealed(true);
				
			}
		}

		String expected = "Green";
		String actual = myGame.assassinRevealed(listofLocations);

		assertEquals(expected, actual);

	}

}

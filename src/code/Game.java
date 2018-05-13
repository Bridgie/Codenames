package code;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

//this class will check clue, updates clue, checks winning state. Bridgie

public class Game {

	/*
	 * Turn functions:
	 * 
	 * turn = 1 - red teams turn turn = 2 - blue teams turn turn = 3 - green teams
	 * turn (IF greenGame = true) turn = 4 - red teams spymaster turn = 5 - blue
	 * teams spymaster turn = 6 - green team spymaster turn (IF greenGame = true)
	 */

	private int turn = 4;

	private int _count = 0;

	// this boolean variable checks if a 3-team game is being played or not
	private boolean greenGame;

	/**
	 * @return the turn. DJ
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * @param turn
	 *            the turn to set. DJ
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return _count;
	}

	/**
	 * @param count
	 *            updated count.
	 */
	public void setCount(int count) {
		_count = count;
	}

	/**
	 * @return boolean game is 2-team or 3-team
	 */
	public boolean getTeam() {
		return greenGame;
	}

	/**
	 * @param boolean
	 *            game updates game to 2-team or 3-team
	 */
	public void setTeam(boolean game) {
		greenGame = game;
	}

	/**
	 * Method to loop through the GameWords text file and save the codenames in an
	 * arraylist. OUTPUT - An arraylist of codenames
	 * 
	 * @param filename
	 *            - filename of a list containing codenames
	 */

	public ArrayList<String> readCodenamesFromFile(String filename) {
		ArrayList<String> answer = new ArrayList<String>();
		try {
			for (String word : Files.readAllLines(Paths.get(filename))) {
				answer.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return answer;
	}

	/**
	 * Method which creates list of 25 codenames selected at random OUTPUT - An
	 * arraylist of 25 codenames
	 * 
	 * @param listFromFile
	 *            - An arraylist of codenames
	 */
	public ArrayList<String> randomCodenames(ArrayList<String> listFromFile) {
		ArrayList<String> randomList = new ArrayList<String>();
		Collections.shuffle(listFromFile);
		for (int i = 0; i < listFromFile.size(); i++) {
			randomList.add(listFromFile.get(i));
		}
		return randomList;
	}

	/**
	 * Method which creates list of random location assigmnets OUTPUT - An arraylist
	 * of random locations
	 * 
	 * @param listOfPErsons,
	 *            fileName - An arraylist of person Objects, filename to read
	 *            codenames from Bridgie (DJ)
	 */

	public ArrayList<Location> randomAssignments(ArrayList<Person> listOfPersons, String fileName) {
		ArrayList<Location> assignmentList = new ArrayList<Location>();
		ArrayList<String> randomCodeNames = randomCodenames(readCodenamesFromFile(fileName));

		for (int i = 0; i < listOfPersons.size(); i++) {
			assignmentList.add(new Location(randomCodeNames.get(i), listOfPersons.get(i)));
		}

		Collections.shuffle(assignmentList);

		return assignmentList;

	}

	/**
	 * Method which checks if clue is legal or illegal OUTPUT - true if its legals,
	 * false if its illegal
	 * 
	 * @param clue,
	 *            assignmentList - An arraylist of assigned locations and codenames,
	 *            clue to check Bridgie (DJ)
	 *
	 */

	public boolean checkIfClueLegal(String clue, ArrayList<Location> assignmentList) {

		for (int i = 0; i < assignmentList.size(); i++) {
			if (clue.toUpperCase().equals(assignmentList.get(i).getCodename())
					&& (assignmentList.get(i).getPerson().getRevealed() == false)) {
				return false;
			}
		}
		return true;

	}

	/*
	 * Method checks if either team is winning or not
	 * 
	 * @param teamname - name of the team you want to see is winning, either Red or
	 * Blue
	 * 
	 * @param assignmentList - An arraylist of assigned locations and codenames,
	 * number of locations whose codename is related to clue Bridgie (DJ)
	 * 
	 * @return true if that team is winning, false if not
	 */
	public boolean isWinning(String teamName, ArrayList<Location> assignmentList) {

		ArrayList<Location> blue = new ArrayList<Location>();
		ArrayList<Location> red = new ArrayList<Location>();
		ArrayList<Location> green = new ArrayList<Location>();

		for (int i = 0; i < assignmentList.size(); i++) {
			if (greenGame == true) {
				if (assignmentList.get(i).getPerson().getRole() == "BlueAgent"
						&& assignmentList.get(i).getPerson().getRevealed() == true) {
					blue.add(assignmentList.get(i));
				} else if (assignmentList.get(i).getPerson().getRole() == "RedAgent"
						&& assignmentList.get(i).getPerson().getRevealed() == true) {
					red.add(assignmentList.get(i));
				} else if (assignmentList.get(i).getPerson().getRole() == "GreenAgent"
						&& assignmentList.get(i).getPerson().getRevealed() == true) {
					green.add(assignmentList.get(i));
				}
			} else {
				if (assignmentList.get(i).getPerson().getRole() == "BlueAgent"
						&& assignmentList.get(i).getPerson().getRevealed() == true) {
					blue.add(assignmentList.get(i));
				} else if (assignmentList.get(i).getPerson().getRole() == "RedAgent"
						&& assignmentList.get(i).getPerson().getRevealed() == true) {
					red.add(assignmentList.get(i));
				}
			}

		}
		if (greenGame == true) {
			if (red.size() > blue.size() && red.size() > green.size() && teamName == "Red") {
				return true;
			} else if (red.size() > blue.size() && red.size() > green.size() && teamName == "Blue") {
				return true;
			} else if (green.size() > red.size() && green.size() > blue.size() && teamName == "Green") {
				return true;
			}
		} else {
			if (red.size() > blue.size() && teamName == "Red") {
				return true;
			} else if (blue.size() > red.size() && teamName == "Blue") {
				return true;
			}
		}
		return false;

	}

	/*
	 * Method that checks who revealed the assassin and which team LOST
	 * 
	 * @param assignmentList - list of filled locations Returns - team who LOST
	 * <----- CHANGED FROM WON TO LOST 5/6/2018 <-----
	 */
	public String assassinRevealed(ArrayList<Location> assignmentList) {
		if (greenGame == false) {
			if (getTurn() == 1) {
				return "Red";
			} else {
				return "Blue";
			}
		}

		if (getTurn() == 1) {
			return "Red";
		} else if (getTurn() == 2) {
			return "Blue";
		} else {
			return "Green";
		}
	}

	/*
	 * Creates a random list of 25 properly assigned persons.
	 * 
	 * @Return - list of 25 properly assigned persons
	 */
	public ArrayList<Person> assignmentList() {

		ArrayList<Person> answer = new ArrayList<Person>();
		if (greenGame == false) { // if its a 2-team game
			for (int i = 0; i < 9; i++) {
				answer.add(new Person("RedAgent"));
			}

			for (int i = 0; i < 8; i++) {
				answer.add(new Person("BlueAgent"));
			}

			for (int i = 0; i < 7; i++) {
				answer.add(new Person("Innocent"));
			}

			answer.add(new Person("Assassin"));

		} else { // if its a 3-team game
			for (int i = 0; i < 6; i++) {
				answer.add(new Person("RedAgent"));
			}

			for (int i = 0; i < 5; i++) {
				answer.add(new Person("BlueAgent"));
			}

			for (int i = 0; i < 5; i++) {
				answer.add(new Person("GreenAgent"));
			}

			for (int i = 0; i < 7; i++) {
				answer.add(new Person("Innocent"));
			}

			for (int i = 0; i < 2; i++) {
				answer.add(new Person("Assassin"));
			}
		}
		Collections.shuffle(answer);
		return answer;

	}

}

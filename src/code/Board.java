package code;

import code.Location;

import java.util.ArrayList;

import code.Game;

// This class contains the board for the game. CH
// A new instance of the board class will be instantiated 
// at the beginning of the game and updated throughout.

public class Board {

	// Fields for the board class. WW

	private Game _game = new Game();

	private Location[] _board = new Location[25];

	// Int to track which teams turn it is. 0 = red, 1 = blue.

	// Array list of locations.

	private ArrayList<Location> _locations = new ArrayList<Location>();

	/**
	 * Creates a game instance and initializes the board to it's start state. RY
	 */

	public Board(boolean g) {
		this.getGame().setTeam(g);
		_locations = _game.randomAssignments(_game.assignmentList(), "GameWords.txt");
		for (int i = 0; i < _board.length -1 ; i++) {
			_board[i] = _locations.get(i);
		}
	}

	/**
	 * Decrements the count, updates a Location when the Location's codename was
	 * selected, and returns if the Location contained the current team's Agent
	 * 
	 * @param currentTurn
	 *            int representing what team is currently guessing
	 * @param board
	 *            instance of the Board class representing the current game being
	 *            played
	 * @param guess
	 *            Current teams submitted code name guess.
	 * 
	 * @return Boolean true if the guessed location contained the current teams
	 *         agent. False otherwise. WW
	 */

	public boolean updateLocations(int currentTurn, Board board, String guess) {
		for (int i = 0; i < board.getLocations().size(); i++) {
			if (board.getLocation(i).getCodename().equals(guess)) {
				board.getGame().setCount(board.getGame().getCount() - 1);
				board.getLocation(i).set_selected(true);
				board.getLocation(i).getPerson().setRevealed(true);
				if (board.getGame().getTurn() == currentTurn ) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Counts to determine how many of each agent are revealed.
	
	public int redAgentsRevealed() {
		int answer = 0;
		for(Location l : this._locations) {
			if (l.getPerson().getRole() == "RedAgent" && l.getPerson().getRevealed() == true) {
				answer+=1;
			}
		}
		return answer;
	}
	public int blueAgentsRevealed() {
		int answer = 0;
		for(Location l : this._locations) {
			if (l.getPerson().getRole() == "BlueAgent" && l.getPerson().getRevealed() == true) {
				answer+=1;
			}
		}
		return answer;
	}
	
	
	public int greenAgentsRevealed() {
		int answer = 0;
		for(Location l : this._locations) {
			if (l.getPerson().getRole() == "GreenAgent" && l.getPerson().getRevealed() == true) {
				answer+=1;
			}
		}
		return answer;
	}
	
	// getters. RY

	public Game getGame() {
		return _game;
	}

	/*
	 *  @return a list of location objects
	 */
	public ArrayList<Location> getLocations() {
		return _locations;
	}

	/*
	 * @param i an index
	 * @return the location in a list of locations at index i
	 */
	public Location getLocation(int i) {
		return _locations.get(i);
	}
	
	/*
	 * @param list of locations to set a board instance.
	 */
	 public void setLocations(ArrayList<Location> locations) {
		 _locations = locations;
	 }
}
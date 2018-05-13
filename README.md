# Codenames [![Codacy Badge](https://api.codacy.com/project/badge/Grade/04e09bb3541f48a4ada13540bd3c9b02)](https://www.codacy.com/app/Bridgie/Codenames?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Bridgie/Codenames&amp;utm_campaign=Badge_Grade)

## Description
Codenames is a game made in Java using Java swing. Game rules:
## Game Setup
The game board consists of a 5 x 5 grid. (This may or may not change in future phases)
When the game begins, each location in this grid is assigned a "codename", a Person, and whether their Person is Revealed.
The codename assigned to each location should be selected at random from a master list of codenames. Each location's codename must be unique; if the randomly selected codename is assigned to another location, you will need to select again until an unused codename is chosen.
There are exactly 25 Persons to be placed randomly on the board: 1 Assassin, 9 Red Agents, 8 Blue Agents, and 7 Innocent Bystanders. Each location in the grid will therefore have exactly 1 Person.
Each of the 25 locations should start with their Person NOT being Revealed.
## Taking a turn
Red team ALWAYS gets the first turn of the game.
At the start of their turn, the Team's "spymaster" provides a "clue" and a count.
The clue will be a String. If the clue is equal to a codename on the board, the team's turn is forfeit UNLESS that codename is already Revealed
The count is the number of locations whose codename is related to the clue. This will always be a whole number greater than 0.
The remainder of the team is told the clue and count. If the count is 0 or greater, the team can either choose to pass OR select a location to be Revealed. (Once the count is NOT 0 or greater or the team chooses to pass, the turn ends.) If they select a location to be Revealed, the location should be Revealed and what happens next depends on the Person in that location:
If the Person is an Agent for the selecting team (e.g., the Red team selects a location with a Red Agent; the Blue team select a location with a Blue Agent), then decrease the count by 1. The team's turn continues with the same clue but the updated count.
If the location's Person is an Innocent Bystander, other team's Agent, or the Assassin, the turn ends.
At the end of a turn, check to see if a team has won (see below). If neither team has won, start the other team's turn with their spymaster offering a clue and a count.
## Ways to Win
If a team Reveals the Assassin, then that team is immediately "killed". The game is over and the other team is declared the winner.
If all 9 Red Agents are Revealed, the Red team wins. This is true even if it is a Blue team selection that Revealed the final Red Agent.
If all 8 Blue Agents are Revealed, the Blue team wins. This is true even if it is a Red team selection that Revealed the final Blue Agent.

## License

This project is licensed under the MIT License - see the License.md file for details

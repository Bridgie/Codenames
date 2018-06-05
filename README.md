# Codenames

## Description
Codenames is a game made in Java using Java swing.
## Game Setup
The game board consists of a 5 x 5 grid.
When the game begins, each Location in this grid is assigned a "codename", a Person, and whether their Person is Revealed.
The codename assigned to each Location should be selected at random from a master list of codenames. Each Location's codename must be unique; if the randomly selected codename is assigned to another Location, you will need to select again until an unused codename is chosen.
There are exactly 25 Persons to be placed randomly on the board: 2 Assassin, 6 Red Agents, 5 Blue Agents, 5 Green Agents, and 7 Innocent Bystanders. Each Location in the grid will therefore have exactly 1 Person.
Each of the 25 Locations should start with their Person NOT being Revealed.
## Taking a turn
Red team ALWAYS gets the first turn of the game.
At the start of a turn, the team's "spymaster" provides a "clue" and a count.
The clue will be a String. If the clue is equal to a codename on the board, the team's turn is forfeit UNLESS that codename is already Revealed
The count is the number of Locations whose codename is related to the clue. This will always be a whole number greater than 0.
The remainder of the team is told the clue and count. If the count is 0 or greater, the team can either choose to pass OR select a Location to be Revealed. (Once the count is NOT 0 or greater or the team chooses to pass, the turn ends.) If they select a Location to be Revealed, the Location should be Revealed and what happens next depends on the Person in that Location:
If the Person is an Agent for the selecting team (e.g., the Red team selects a Location with a Red Agent; the Blue team selects a Location with a Blue Agent; the Green team selects a Location with a Green Agent), then decrease the count by 1. The team's turn continues with the same clue but the updated count.
If the Location's Person is an Innocent Bystander, other team's Agent, or the Assassin, the turn ends.
At the end of a turn, check to see if a team has won (see below). Turns should rotate through the teams in order Red, Blue, Green (and then back to Red). If a team's turn ends without a team having won, check to see if the next team has lost (Revealed one of the Assassins). If the team has not lost, it is their turn. If the next team has lost, play should continue with the 3rd team.
## Ways to Win
If 2 teams Reveal the Assassins, then the third team is declared the winner.
If all 6 Red Agents are Revealed and the Red team has not Revealed the Assassin, then the Red team wins. This is true no matter who Revealed the final Red Agent.
If all 5 Blue Agents are Revealed and the Blue team has not Revealed the Assassin, then the Blue team wins. This is true no matter who Revealed the final Blue Agent.
If all 5 Green Agents are Revealed and the Green team has not Revealed the Assassin, then the Green team wins. This is true no matter who Revealed the final Green Agent.
## License
This project is licensed under the MIT License - see the License.md file for details

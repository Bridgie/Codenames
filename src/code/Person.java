package code;

// Creates a person object for the game to use later. WW

public class Person {

	// Person globals to be used throughout an instance of the object. WW

	private String _role;

	private Boolean _revealed;

	/**
	 * Person constructor, parameters as role and name to be assigned at setup. WW
	 * 
	 * @param role
	 *            - role assigned to person
	 * @param name
	 *            - name assigned to person
	 */

	public Person(String role) {
		this._role = role;
		this._revealed = false;
	}


	// Getter method for role. CH

	public String getRole() {
		return this._role;
	}

	/**
	 * Setter method for role. CH
	 * 
	 * @param role
	 *            - role assigned to person object
	 */

	public void setRole(String role) {
		this._role = role;
	}

	/**
	 * Setter method for role. CH
	 * 
	 * @param role
	 *            - role assigned to person object
	 */

	public void setRevealed(Boolean rev) {
		this._revealed = rev;
	}

	// Getter method for role. CH

	public Boolean getRevealed() {
		return this._revealed;
	}
}

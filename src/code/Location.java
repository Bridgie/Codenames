package code;

// This class will create each location instance. WW

public class Location {

	// Fields defined for the location class. WW
	
	private String _codename;
	
	private Person _person;
	
	private boolean _selected;
	/**
	 *constructor
	 *@Param codeName - codename assigned to the location
	 *@Param p - person assigned to the location
	 *@Param revealed - assigns whether the location is revealed (should be false at the start of the game)
	*/
	public Location(String codeName, Person p) {
		_codename = codeName;
		_person = p;
		_selected = false;
				
	}
		
	//getter for codename. RY
	public String getCodename() {
		return _codename;
	}
	
	//getter for person. RY
	public Person getPerson() {
		return _person;
	}

	
	
	
	/**
	 * @return the _selected
	 */
	public boolean is_selected() {
		return _selected;
	}

	/**
	 * @param _selected the _selected to set
	 */
	public void set_selected(boolean _selected) {
		this._selected = _selected;
	}
	
	
}

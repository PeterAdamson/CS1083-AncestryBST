// Authors: Tristen Tulkens, Peter Adamson

public class Ancestor {

	private String name;
	private int birthYear;

	public Ancestor(String name, int birthYear) {
		
		this.name = name;
		this.birthYear = birthYear;

	}

	public String getName() {

		return name;

	}

	public int getBirthYear() {

		return birthYear;

	}

	public String toString() {

		return String.format("%s %d", name, birthYear);

	}

}

package lab03;

public class UABPerson {
	private String name;
	private String gender;
	private int age;
	private String blazerID;

	/**
	 * Makes a person with a NAME, GENDER, AGE, and BLAZERID
	 * 
	 * @param name
	 * @param gender
	 * @param age
	 * @param blazerID
	 */
	public UABPerson(String name, String gender, int age, String blazerID) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.blazerID = blazerID;
	}

	// Getters
	public String getName() {
		return this.name;
	}

	public String getGender() {
		return this.gender;
	}

	public int getAge() {
		return this.age;
	}

	public String getBlazerID() {
		return this.blazerID;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBlazerID(String blazerID) {
		this.blazerID = blazerID;
	}

	/**
	 * Checks if the UABPerson name is a palindrome.
	 * 
	 * @return boolean
	 */
	public boolean checkPalindrome() {
		String name = this.getName().toLowerCase();
		int length = name.length();
		String reverse = "";
		for (int i = length - 1; i >= 0; i--) {
			reverse += name.charAt(i);
		}
		if (reverse.equals(name)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns how many years are left until UABPerson can retire
	 * 
	 * @return int
	 */
	public int yearsUntilRetirement() {
		int age = getAge();
		return 65 - age;
	}

	/**
	 * Returns NAME is AGE years old
	 * 
	 * @return String
	 */
	public String toString() {
		return getName() + " is " + getAge() + " years old.";
	}

}

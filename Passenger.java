package project2;

public class Passenger {

	// Attributes declaration
	private String firstName;
	private String lastName;
	private char gender;
	private String passportNumber;
	private  String nationality;
	private boolean hasVISA;
	private static int numOfPassenger;
	
	// Constructors 
	public Passenger(String firstName, String lastName, char gender, String passportNumber, String nationality,
			boolean hasVISA) {
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setPassportNumber(passportNumber);
		setNationality(nationality);
		setHasVISA(hasVISA);
		setNumOfPassenger(gender);		
	}

	// Methods 
	public void printPassengerInfo() {
		System.out.println("\n--------------------------\n"
				+ "passenger information:\n"
				+ "--------------------------\n"
				+ "First Name: " + firstName +"\n"
				+ "Last Name: " + lastName + "\n"
				+ "Gender: " + gender + "\n"
				+ "Passport Number: " + passportNumber + "\n"
				+ "Nationality: " + nationality + "\n"
				+ "Has VISA: " + hasVISA );
		
	}
	
	//Setters&getters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		int flag=0;// helping variable for result
		if(firstName.length() < 3){// validation on length
			System.out.println("\nInvaid input! your first name must be at lest 3 letters.");
			return;
		}

		for(int i=0; i<firstName.length(); i++) { // validation for letters only
			if(Character.isLetter(firstName.charAt(i)) != true ) {
				flag=1;
				break;
			}
		}
		if(flag == 0)
			this.firstName = firstName;
		else
			System.out.println("\nInvaid input! your first name must containe letters only.");		
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.length() < 3 ) // validation on length
			System.out.println("\nInvaid input! your last name must be at lest 3 letters.");

		int flag=0;// helping variable
		for(int i=0; i<lastName.length(); i++) { // validation for letters only
			if(Character.isLetter(lastName.charAt(i)) != true ) {
				flag=1;
				break;
			}
		}
		if(flag == 0)
			this.lastName = lastName;
		else
			System.out.println("\nInvaid input! your last name must contain letters only.");
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if(gender == 'M' || gender == 'm' || gender == 'F' || gender == 'f') // validation on gender input
			this.gender = Character.toUpperCase(gender);
		else 
			System.out.println("\nInvaid input! there is only two genders M&F.");		
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		int counter =0;
		for (int i = 0; i < passportNumber.length(); i++) {
			if(Character.isDigit(passportNumber.charAt(i)) != true) { // validation for letters only
				System.out.println("\nInvaid input! your passport number must contain digits only.");
				break;
			}
			else
				counter++;
		}
		if(counter != 7)// validation on number range
			System.out.println("\nInvaid input! your passport number must be preformed as 7 digits.");
		else 
			this.passportNumber = passportNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		int flag=0;
		for(int i=0; i<nationality.length(); i++) { // validation for letters only
			if(Character.isLetter(nationality.charAt(i)) != true ) {
				flag=1;
				break;
			}
		}
		if(flag == 0)
			this.nationality = nationality;
		else 
			System.out.println("\nInvaid input! your nationality must contain letters only.");		
	}

	public boolean getHasVISA() {
		return hasVISA;
	}

	public void setHasVISA(boolean hasVISA) {
		if(hasVISA == true || hasVISA == false)// validation on the input
			this.hasVISA = hasVISA;	
	}

	public static int getNumOfPassenger() {
		return numOfPassenger;
	}
	
	public static void setNumOfPassenger(int numOfPassenger) {
			Passenger.numOfPassenger ++; // number of passenger on the plain
	}
}

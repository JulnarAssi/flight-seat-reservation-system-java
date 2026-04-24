package project2;

public class TestPassenger {

	public static void main(String[] args) {
		
		/*Passenger passeng1 = new Passenger("julnar", "Assi", 'f', "1221669", "palestenian", true);
		passeng1.printPassengerInfo();
		Passenger passeng2 = new Passenger("ju", "9ssi", 's', "122y66", "0alestenian", false);
		passeng2.printPassengerInfo();
		System.out.println("Number of Passengers is: " + Passenger.getNumOfPassenger());
	*/
		
		Passenger[][] seats = new Passenger[32][6];// array of passengers
		Driver driver = new Driver(); // creation of object of type Driver
        driver.menu(seats, 32, 6); // implementation of the system
	}
}

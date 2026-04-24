package project2;

import java.util.Random;
import java.util.Scanner;

public class Driver {

	private Passenger[][] seats = new Passenger[31][]; // plain seat object of passenger type
	
	//constructors
	public Driver() {
		for (int i = 0; i < 3; i++) {
			seats[i+1] = new Passenger[6];
		}
		for (int i = 6; i < seats.length; i++) {
			seats[i] = new Passenger[6];
		}
	}
	
	//setters & getters
	public Passenger[][] getSeats() {
		return seats;
	}

	public void setSeats(Passenger[][] seats) {
		this.seats = seats;
	}
	
	//methods
	public void menu(Passenger[][] seats, int row, int column) {
		int choice =0;
		//menu
		do { 
			System.out.println("\n\t\tWelcome to BZU Sky Reservation System, choose:\n"
					+ "0- To reserve a random empty seat.\n"
					+ "1- To reserve a specific new seat number.\n"
					+ "2- To display the passenger information for a specific seat.\n"
					+ "3- To search for a passenger by first or last name.\n"
					+ "4- To search for passenger by passport number.\n"
					+ "5- To print a list of the passengers and there seat numbers.\n"
					+ "6- To exit execution.\n"
					+ "\t\tEnter your choice (0 - 6)?");
			
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			if(choice > 6 || choice < 0) {
				System.out.println("Invaled input! try numbers 0-6\n"); 
				continue;
			}
			//function calls
			switch(choice) {
			
			case 0: randomReservation(seats, row, column);
					break;
			case 1: specificReservation(seats);
					break;	
			case 2: displayPassengerInfo(seats);
					break;
			case 3: searchByName(seats);
					break;
			case 4: searchByPassportNum(seats);
					break;
			case 5: printList(seats);
					break;	
			default : System.out.println("\nHope you enjoyed our system! Goodbye :)"); 
					break;
			}
		}while(choice != 6);
	}
	
	// this function appendas the row letter with row number and return the result for example (A12)
	public StringBuilder lable(Passenger[][] seats, int row, int column) {
		String lable = "ABCDEF";
		StringBuilder ap = new StringBuilder();
		char seatnum = lable.charAt(column);
		ap = ap.append(seatnum).append(row);
		return ap;
	}
	
	// this function reserve randomlly economy or business seat
	public void randomReservation(Passenger[][]seats, int row, int column) {
		String firstName= null, lastName = null, passportNumber = null, nationality= null;
		boolean hasVISA = false;
		char gender = '\0';
		//read user info
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your first name: ");
		firstName = input.next();
		System.out.print("Please enter your last name: ");
		lastName = input.next();
		System.out.print("Please enter your gender (F-M): ");
		gender = input.next().charAt(0);
		System.out.print("Please enter your passport number: ");
		passportNumber = input.next();
		System.out.print("Please enter your nationality: ");
		nationality = input.next();
		System.out.print("Please enter true if you have VISA and false if you dont: ");
		hasVISA = input.nextBoolean();
		// choose a random seat number
		for (int i = 0; i < seats.length; i++) {
			Random random1 = new Random();
			Random random2 = new Random();
			row = random1.nextInt(32);
			column = random1.nextInt(6);
			if(row == 4 || row == 5 || row == 13) {
				System.out.println("Sorry :( There is no seats in this row");
				return;
			}
			if(seats[row][column] == null ) {//reserve the seat
				seats[row][column] = new Passenger(firstName, lastName, gender, passportNumber, nationality, hasVISA);
				System.out.println("\nReservatio went succsessfuly, Your seat number is: " + lable(seats,row,column));
				break;
			}
		}
	}
	
	
	//this function reserve a specific entered seat form user (economy or business)
	public void specificReservation(Passenger[][]seats) {
		String seat = null;
		int column=0, row=0;
		Scanner input1 = new Scanner(System.in);
		System.out.println("Please enter number of the seat you want to reserve: ");
		seat = input1.next();
		//validation on seat number format
		if(seat.length() < 2) {
			System.out.println("\nInvalid input!!, your seat number must be like -> for example B13\n");
			return;
		}
		// for labeling each column
		if(seat.charAt(0) == 'A') {
			column =0;
		}
		else if(seat.charAt(0) == 'B') {
			column =1;
		}
		else if(seat.charAt(0) == 'C') {
			column =2;
		}
		else if(seat.charAt(0) == 'D') {
			column =3;
		}
		else if(seat.charAt(0) == 'E') {
			column =4;
		}
		else if(seat.charAt(0) == 'F') {
			column =5;
		}
		else {
			System.out.println("\nInvalid input!!, There is no such a seat with this number.\n");
			return;
		}
		
		row = Integer.valueOf(seat.substring(1));// to trim out the letter and the number
		if(row > 31 || row < 1) {// validation for out of range number 
			System.out.println("\nInvalid input!!, There is no such a seat with this number.\n");
			return;
		}
		
		String firstName= null, lastName = null, passportNumber = null, nationality= null;
		boolean hasVISA = false;
		char gender = '\0';
		//reading data from user
		System.out.print("Please enter your first name: ");
		firstName = input1.next();
		System.out.print("Please enter your last name: ");
		lastName = input1.next();
		System.out.print("Please enter your gender (F-M): ");
		gender = input1.next().charAt(0);
		System.out.print("Please enter your passport number: ");
		passportNumber = input1.next();
		System.out.print("Please enter your nationality: ");
		nationality = input1.next();
		System.out.print("Please enter true if you have VISA and false if you dont: ");
		hasVISA = input1.nextBoolean();

		if(row == 4 || row == 5 || row == 13) {// validation for no seat rows
			System.out.println("Sorry :( There is no seats in this row");
			return;
		}
			
		if(seats[row][column] == null) {// reserve that specific seat entered number
			seats[row][column] = new Passenger(firstName, lastName, gender, passportNumber, nationality, hasVISA);
			System.out.println("\nReservation went successfully, Your seat number is: " + lable(seats,row,column));
		}
		else
			System.out.println("\nSorry :(, This seat is already reserved.\n");
	}
	
	
	//this function display the information of a specific passenger by his seat number
	public void displayPassengerInfo(Passenger[][]seats) {
		String seat = null;
		int column=0, row=0;
		Scanner input1 = new Scanner(System.in);
		System.out.print("Please enter number of the seat you want to display its info: ");
		seat = input1.next();
		//validation on seat number format
		if(seat.length() < 2) {
			System.out.println("\nInvalid input!!, your seat number must be: for example B13\n");
			return;
		}
		// for labeling each column
		if(seat.charAt(0) == 'A') 
			column =0;
		else if(seat.charAt(0) == 'B') 
			column =1;
		else if(seat.charAt(0) == 'C') 
			column =2;
		else if(seat.charAt(0) == 'D') 
			column =3;
		else if(seat.charAt(0) == 'E')
			column =4;
		else if(seat.charAt(0) == 'F')
			column =5;
		else {
			System.out.println("\nInvalid input!!, There is no such a seat with this number.\n");
			return;
		}
		// to trim out the letter and the number
		row = Integer.valueOf(seat.substring(1));
		if(row > 31 || row < 1) {// validation for out of range numbers
			System.out.println("\nInvalid input!!, There is no such a seat with this number.\n");
			return;
		}
		
		if(row == 4 || row == 5 || row == 13) {// validation for no seat rows
			System.out.println("Sorry :( There is no seats in this row");
			return;
		}
		
		if(seats[row][column] != null ) {// display out info
			seats[row][column].printPassengerInfo();
			printList(seats);
		}
		
		else
			System.out.println("\nSorry :( This seat is empty.\n");
	}
	
	//this method searching by first or last passenger name then return the seat number
	public void searchByName(Passenger[][] seats) {
		String name = null, seatNum= null;
		char column = 0;
		int flag=0;
		Scanner input1 = new Scanner(System.in);
		System.out.print("\nPlease enter first name or last name of the passenger you want to search about: ");
		name = input1.next();
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if(seats[i][j] != null) {
					if(name.equalsIgnoreCase(seats[i][j].getFirstName())  || name.equalsIgnoreCase(seats[i][j].getLastName())) {
						column = (char)('A' +j);
						seatNum = column + String.valueOf(i) ; 
						System.out.print("According to the enterd passenger name the seat number is: " + seatNum);
						flag = 1;
						return;
					}
				}
			}
		}
		if(flag == 0)
			System.out.println("\nSorry :( There is no passenger with this name.\n");
	}
				
	//this method searching by passenger passport number then return the seat number
	public void searchByPassportNum(Passenger[][] seats) {
		
		String passportNum = null, seatNum= null;
		char column = 0;
		int flag=0;
		Scanner input1 = new Scanner(System.in);
		System.out.print("\nPlease enter the passport number for the passenger you want to search about: ");
		passportNum = input1.next();
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if(seats[i][j] != null) {
					if(passportNum.equalsIgnoreCase(seats[i][j].getPassportNumber())) {
						column = (char)('A' +j);
						seatNum = column + String.valueOf(i) ; 
						System.out.print("\nAccording to the enterd passenger passport number the seat number is: " + seatNum);
						flag = 1;
						return;
					}
				}
			}
		}
		if(flag == 0)
			System.out.println("\nSorry :( There is no passport number matches what you enterd.\n");
	}
	
	//this method print out all passenger information
	public void printList(Passenger[][] seats) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if(seats[i][j] != null) {
					seats[i][j].printPassengerInfo();
					System.out.println("Seat Number: " + lable(seats, i, j)); 
					System.out.println("--------------------------");
				}
			}
		}
	}
	
}

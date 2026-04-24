Flight Seat Reservation System ✈️

A Java-based console application that simulates a flight seat reservation system for an A320 aircraft.
The system allows users to reserve seats, manage passenger information, and perform search operations efficiently.

---

Features

	>> Reserve a random empty seat
	>> Reserve a specific seat by seat number (e.g.,A12)
	>> Display passenger information for a selected seat
	>> Search passengers by:

  		> First name / Last name
  		> Passport number
	>> Print a list of all passengers with their seat numbers
	>> Input validation (names, passport number, gender, etc.)
	>> Seat structure based on real A320 configuration

---

System Design

	>> Uses a 2D ragged array to represent flight seats
	>> Business and Economy classes are handled according to seat layout
	>> Some rows (4, 5, 13) are intentionally excluded (no seats)

---

Technologies Used

	>> Java
	>> Object-Oriented Programming (OOP)
	>> Arrays (2D structures)
	>> User input handling (Scanner)

---

Project Structure


flight-seat-reservation-system-java/
│
├── src/
│   ├── Passenger.java
│   ├── Driver.java
│   └── TestPassenger.java
│
├── UML/
│   └── passenger-diagram.png
│
├── docs/
│   └── assignment.pdf
│
└── README.md

---

How to Run

1. Open the project in any Java IDE (Eclipse / IntelliJ / VS Code)

2. Navigate to:


	> TestPassenger.java


3. Run the main method

4. Use the menu to interact with the system

---

UML Diagram

The UML diagram for the Passenger class is included in the UML/ folder.

---

Documentation

Full assignment details are available in:


	> docs/assignment.pdf


---

Author

Julnar Naal Assi

---

Notes

This project was developed as part of an academic assignment and demonstrates strong understanding of:

	>> Object-Oriented Programming
	>> Data structures (2D arrays)
	>> Input validation and system design

---

Future Improvements

	>> Add GUI (JavaFX or Swing)
	>> Improve error handling
	>> Enhance seat visualization

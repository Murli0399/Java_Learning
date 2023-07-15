package com.masai.assignment;

public class BoatTicketIssue {
	static boolean issueTicket(Passenger passenger, SpeedBoat speedBoat) {
		// write code to allot speed boat to passenger it has vacant seat
		// reduce total capacity of the boat by 1 after allocation
		// if boat allocation it successful then return true; false otherwise
		if (speedBoat.getCapacity() > 0) {
			speedBoat.setCapacity(speedBoat.getCapacity() - 1);
			passenger.setSpeedBoat(speedBoat);
			return true;
		} else {
			return false;
		}
	}

	static boolean issueTicket(Passenger passenger, MotorBoat motorBoat) {
		// write code to allot motor boat to passenger it has vacant seat
		// reduce total capacity of the boat by 1 after allocation
		// if boat allocation it successful then return true; false otherwise
		if (motorBoat.getCapacity() > 0) {
			motorBoat.setCapacity(motorBoat.getCapacity() - 1);
			passenger.setMotorBoat(motorBoat);
			return true;
		} else {
			return false;
		}
	}
}

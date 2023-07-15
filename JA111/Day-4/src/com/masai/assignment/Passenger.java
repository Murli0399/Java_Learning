package com.masai.assignment;

public class Passenger {
	private String passengerId;
	private String name;
	private SpeedBoat speedBoat;
	private MotorBoat motorBoat;
	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpeedBoat getSpeedBoat() {
		return speedBoat;
	}

	public void setSpeedBoat(SpeedBoat speedBoat) {
		this.speedBoat = speedBoat;
	}

	public MotorBoat getMotorBoat() {
		return motorBoat;
	}

	public void setMotorBoat(MotorBoat motorBoat) {
		this.motorBoat = motorBoat;
	}

	public static int getPassengerCounter() {
		return passengerCounter;
	}

	public static void setPassengerCounter(int passengerCounter) {
		Passenger.passengerCounter = passengerCounter;
	}

	private static int passengerCounter;

	public Passenger(String name) {
		passengerCounter++;
        this.passengerId = "PS" + String.format("%04d", passengerCounter);
        this.name = name;
	}
}

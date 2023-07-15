package com.masai;

abstract class Science {
	private static int counter;
	private String registrationNumber;
	private float physicsTheoryMarks;
	private float physicsPracticalMarks;
	private float chemistryTheoryMarks;
	private float chemistryPracticalMarks;

	static {
		counter = 0;
	}

	Science(String registrationPrefix, float physicsTheoryMarks, float physicsPracticalMarks,
			float chemistryTheoryMarks, float chemistryPracticalMarks) {
		this.registrationNumber = registrationPrefix + (++counter);
		this.physicsTheoryMarks = physicsTheoryMarks;
		this.physicsPracticalMarks = physicsPracticalMarks;
		this.chemistryTheoryMarks = chemistryTheoryMarks;
		this.chemistryPracticalMarks = chemistryPracticalMarks;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public float getPhysicsTheoryMarks() {
		return physicsTheoryMarks;
	}

	public void setPhysicsTheoryMarks(float physicsTheoryMarks) {
		this.physicsTheoryMarks = physicsTheoryMarks;
	}

	public float getPhysicsPracticalMarks() {
		return physicsPracticalMarks;
	}

	public void setPhysicsPracticalMarks(float physicsPracticalMarks) {
		this.physicsPracticalMarks = physicsPracticalMarks;
	}

	public float getChemistryTheoryMarks() {
		return chemistryTheoryMarks;
	}

	public void setChemistryTheoryMarks(float chemistryTheoryMarks) {
		this.chemistryTheoryMarks = chemistryTheoryMarks;
	}

	public float getChemistryPracticalMarks() {
		return chemistryPracticalMarks;
	}

	public void setChemistryPracticalMarks(float chemistryPracticalMarks) {
		this.chemistryPracticalMarks = chemistryPracticalMarks;
	}

	abstract public double getPercentage();
}

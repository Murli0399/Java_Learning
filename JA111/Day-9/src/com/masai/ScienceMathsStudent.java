package com.masai;

class ScienceMathsStudent extends Science {
	final static String MATHS_PREFIX = "SM";
	private float mathsMarks;

	ScienceMathsStudent(float mathsMarks, float physicsTheoryMarks, float physicsPracticalMarks,
			float chemistryTheoryMarks, float chemistryPracticalMarks) {
		super(MATHS_PREFIX, physicsTheoryMarks, physicsPracticalMarks, chemistryTheoryMarks, chemistryPracticalMarks);
		this.mathsMarks = mathsMarks;
	}

	public float getMathsMarks() {
		return mathsMarks;
	}

	public void setMathsMarks(float mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	@Override
	public double getPercentage() {
		return (Math.round((mathsMarks + getPhysicsTheoryMarks() + getPhysicsPracticalMarks() + getChemistryTheoryMarks()
				+ getChemistryPracticalMarks()) / 3)*100.0)/100.00;
	}

}

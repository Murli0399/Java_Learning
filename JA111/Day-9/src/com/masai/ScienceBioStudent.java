package com.masai;

class ScienceBioStudent extends Science {
	final static String BIO_PREFIX = "SB";
	private float bioTheoryMarks;
	private float bioPracticalMarks;
//
//	constructor,
//	setter and
//	getter methods

	ScienceBioStudent(float bioTheoryMarks, float bioPracticalMarks, float physicsTheoryMarks,
			float physicsPracticalMarks, float chemistryTheoryMarks, float chemistryPracticalMarks) {
		super(BIO_PREFIX, physicsTheoryMarks, physicsPracticalMarks, chemistryTheoryMarks, chemistryPracticalMarks);
	}

	public float getBioTheoryMarks() {
		return bioTheoryMarks;
	}

	public void setBioTheoryMarks(float bioTheoryMarks) {
		this.bioTheoryMarks = bioTheoryMarks;
	}

	public float getBioPracticalMarks() {
		return bioPracticalMarks;
	}

	public void setBioPracticalMarks(float bioPracticalMarks) {
		this.bioPracticalMarks = bioPracticalMarks;
	}

	@Override
	public double getPercentage() {
		return (Math.round(
				((getBioPracticalMarks() + getBioTheoryMarks()) + (getPhysicsTheoryMarks() + getPhysicsPracticalMarks())
						+ (getChemistryTheoryMarks() + getChemistryPracticalMarks()) / 3) * 100.0))
				/ 100.0;
	}
}

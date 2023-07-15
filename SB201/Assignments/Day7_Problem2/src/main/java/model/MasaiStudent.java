package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MasaiStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private double registrationFee;

	public void displayDetails() {
		System.out.println(this.id + " " + this.name + " " + this.address);
	}

	public abstract double payFee();

	public MasaiStudent() {
		super();
	}

	public MasaiStudent(int id, String name, String address, double registrationFee) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.registrationFee = registrationFee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(double registrationFee) {
		this.registrationFee = registrationFee;
	}

}

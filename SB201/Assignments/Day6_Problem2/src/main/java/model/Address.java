package model;

import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String state;

	private String city;

	private String pincode;

	public Address(Long id, String state, String city, String pincode) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public Address(String state, String city, String pincode) {
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public Address() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}

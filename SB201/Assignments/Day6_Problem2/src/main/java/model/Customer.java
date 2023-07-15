package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;

	private String name;

	private String mobileNumber;

	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> addresses;

	public Customer() {
		super();
	}

	public Customer(String name, String mobileNumber, String email, List<Address> addresses) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.addresses = addresses;
	}

	public Customer(Long cid, String name, String mobileNumber, String email, List<Address> addresses) {
		super();
		this.cid = cid;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.addresses = addresses;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}

package com.masai.dto;

public class DepartmentDTOImpl implements DepartmentDTO {
	private int did;
	private String dname;
	private String location;

	public DepartmentDTOImpl(String dname, String location) {
		this.dname = dname;
		this.location = location;
	}

	public DepartmentDTOImpl(int id, String dname, String location) {
		this.did = id;
		this.dname = dname;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department Id = " + did + ", Department Name = " + dname + ", Location = " + location;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

package com.masai.dto;

public class EmployeeDTOImpl implements EmployeeDTO {
	private int empid;
	private String ename;
	private String address;
	private String mobile;
	private int depyid;

	public EmployeeDTOImpl(String ename, String address, String mobile, int depyid) {
		this.ename = ename;
		this.address = address;
		this.mobile = mobile;
		this.depyid = depyid;
	}

	public EmployeeDTOImpl(int empid, String ename, String address, String mobile, int depyid) {
		this.empid = empid;
		this.ename = ename;
		this.address = address;
		this.mobile = mobile;
		this.depyid = depyid;
	}

	@Override
	public String toString() {
		return "Employee Id = " + empid + ", Employee Name = " + ename + ", Address = " + address + ", Mobile = "
				+ mobile + ", Department Id = " + depyid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getDepyid() {
		return depyid;
	}

	public void setDepyid(int depyid) {
		this.depyid = depyid;
	}

}

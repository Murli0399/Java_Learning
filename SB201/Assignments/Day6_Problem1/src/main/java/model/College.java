package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	private String collegeName;
	private String collegeAddress;

	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();

	public College() {
	}

	public College(String collageName, String collageAddress, List<Student> students) {
		this.collegeName = collageName;
		this.collegeAddress = collageAddress;
		this.students = students;
	}

	public College(int collageId, String collageName, String collageAddress, List<Student> students) {
		this.collegeId = collageId;
		this.collegeName = collageName;
		this.collegeAddress = collageAddress;
		this.students = students;
	}

	public int getCollageId() {
		return collegeId;
	}

	public void setCollageId(int collageId) {
		this.collegeId = collageId;
	}

	public String getCollageName() {
		return collegeName;
	}

	public void setCollageName(String collageName) {
		this.collegeName = collageName;
	}

	public String getCollageAddress() {
		return collegeAddress;
	}

	public void setCollageAddress(String collageAddress) {
		this.collegeAddress = collageAddress;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College [collageId=" + collegeId + ", collageName=" + collegeName + ", collageAddress=" + collegeAddress
				+ ", students=" + students + "]";
	}

}

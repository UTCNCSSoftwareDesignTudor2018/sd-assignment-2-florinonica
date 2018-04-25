package assignment2.CourseManagement.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentID;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "cnp")
	private String CNP;

	@Column(name = "identitycardnumber")
	private String identityCardNumber;

	@Column(name = "studentgroup")
	private int studentGroup;
	
	@OneToMany(mappedBy = "s", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<StudentEnrollment> enrollments;
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int id) {
		this.studentID = id;
	}

	@Override
	public String toString() {
		return "Student: " + this.getFirstName() + this.getLastName();
	}

	public int getGroup() {
		return studentGroup;
	}

	public void setGroup(int group) {
		this.studentGroup = group;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public List<StudentEnrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<StudentEnrollment> enrollments) {
		this.enrollments = enrollments;
	}
}

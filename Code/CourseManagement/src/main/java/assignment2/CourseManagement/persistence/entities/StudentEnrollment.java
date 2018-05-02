package assignment2.CourseManagement.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "enrollments")

public class StudentEnrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int enrollmentID;
	
	@Column(name = "status")
	private String status;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentid")
	private Student s;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "courseid")
	private Course c;
	
	public int getEnrollmentID() {
		return enrollmentID;
	}
	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}
	public Student getS() {
		return s;
	}
	public void setS(Student s) {
		this.s = s;
	}
	public Course getC() {
		return c;
	}
	public void setC(Course c) {
		this.c = c;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}

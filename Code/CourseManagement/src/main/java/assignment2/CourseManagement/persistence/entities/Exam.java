package assignment2.CourseManagement.persistence.entities;

import java.sql.Date;

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
@Table(name = "exams")

public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int examID;
	
	@Column(name = "examname")
	private String examname;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "courseid")
	@NotNull
	private Course course;
	
	@Column(name = "date")
	private Date date;

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Exam for:" + this.getCourse().toString();
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

}

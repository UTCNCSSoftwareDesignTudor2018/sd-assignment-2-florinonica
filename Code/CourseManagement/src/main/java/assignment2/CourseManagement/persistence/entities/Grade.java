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
@Table(name = "grades")

public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeID;

	@Column(name = "value")
	private int value;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentid")
	@NotNull
	private Student student;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "examid")
	@NotNull
	private Exam exam;

	@Column(name = "date")
	private Date date;

	public int getGradeID() {
		return gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return this.getExam().toString() + " Grade:" + this.getValue();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}

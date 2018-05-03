package assignment2.CourseManagement.persistence.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import assignment2.CourseManagement.persistence.entities.builder.ActivityReportBuilder;

public class ActivityReport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Student student;
	
	private List<Grade> grades;

	public ActivityReport(ActivityReportBuilder builder)
	{
		this.id = builder.id;
		this.student=builder.student;
		this.grades=builder.grades;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
}

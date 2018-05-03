package assignment2.CourseManagement.persistence.entities.builder;

import java.util.List;

import assignment2.CourseManagement.persistence.entities.ActivityReport;
import assignment2.CourseManagement.persistence.entities.Grade;
import assignment2.CourseManagement.persistence.entities.Student;

public class ActivityReportBuilder {
	public int id;
	public Student student;
	public List<Grade> grades;

	public ActivityReportBuilder setId(Integer id) {
		this.id = id;
		return this;
	}

	public ActivityReportBuilder setStudent(Student student) {
		this.student = student;
		return this;
	}

	public ActivityReportBuilder setGrades(List<Grade> grades) {
		this.grades = grades;
		return this;
	}

	public ActivityReport build() {
		return new ActivityReport(this);
	}
}

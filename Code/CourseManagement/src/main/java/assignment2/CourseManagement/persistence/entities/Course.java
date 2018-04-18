package assignment2.CourseManagement.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "courses")

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseID;
	
	@Column(name = "coursename")
	private String courseName;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<StudentEnrollment> courseStudents;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacherid")
	@NotNull
	private Teacher teacher;

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		return this.getCourseName();
	}

	public List<StudentEnrollment> getCourseStudents() {
		return courseStudents;
	}

	public void setCourseStudents(List<StudentEnrollment> courseStudents) {
		this.courseStudents = courseStudents;
	}

}

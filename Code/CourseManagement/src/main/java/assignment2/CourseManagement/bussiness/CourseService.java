package assignment2.CourseManagement.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.CourseManagement.persistence.entities.Course;
import assignment2.CourseManagement.persistence.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository cr;
	
	public Course makeCourse(Course c) {
		return cr.save(c);
	}
	
	public List<Course> getAllCourses() {
		return cr.findAll();
	}
	
	public Course getCourseByName(String name) {
		return cr.findByCourseName(name);
	}
	
	public List<Course> getCourseByTeacherId(int id) {
		return cr.findByTeacherTeacherID(id);
	}
	
	public Optional<Course> getCourseById(int id) {
		return cr.findById(id);
	}
}

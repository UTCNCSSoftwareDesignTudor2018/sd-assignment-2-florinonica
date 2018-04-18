package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment2.CourseManagement.persistence.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	public List<Course> findAll();
	public Optional<Course> findById(int id);
	public List<Course> findByTeacherId(int id);
	public Course findByCourseName(String name);
}

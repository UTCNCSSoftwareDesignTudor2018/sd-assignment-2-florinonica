package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment2.CourseManagement.persistence.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	public List<Course> findAll();
	public Optional<Course> findById(int id);
	public List<Course> findByTeacherTeacherID(int id);
	public Course findByCourseName(String name);
}

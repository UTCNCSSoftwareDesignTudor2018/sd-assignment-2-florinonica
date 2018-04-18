package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment2.CourseManagement.persistence.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	public List<Teacher> findAll();
	public Optional<Teacher> findById(int id);
	public Teacher findByLastName(String lastName);
}

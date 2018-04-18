package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment2.CourseManagement.persistence.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	public List<Student> findAll();
	public Optional<Student> findById(int id);
	public Student findByLastName(String lastName);
	@SuppressWarnings("unchecked")
	public Student save(Student student);
	public void delete(Student student);
	public void deleteByStudentid(int id);
}

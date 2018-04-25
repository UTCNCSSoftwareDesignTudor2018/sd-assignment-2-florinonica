package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment2.CourseManagement.persistence.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	public List<Student> findAll();
	public Optional<Student> findById(int id);
	public Student findByLastName(String lastName);
	public List<Student> findAllByStudentGroup(int groupid);
}

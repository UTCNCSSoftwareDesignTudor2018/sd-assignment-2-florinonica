package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment2.CourseManagement.persistence.entities.StudentEnrollment;

public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, Integer>{
	public List<StudentEnrollment> findAll();
	public Optional<StudentEnrollment> findById(int id);
	public List<StudentEnrollment> findByStudentId(int id);
	public List<StudentEnrollment> findByCourseId(int id);
	public List<StudentEnrollment> findByStatus(String status);
}

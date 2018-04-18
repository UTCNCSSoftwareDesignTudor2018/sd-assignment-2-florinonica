package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment2.CourseManagement.persistence.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{
	public List<Exam> findAll();
	public Optional<Exam> findById(int id);
	public Exam findByExamName(String name);
	public List<Exam> findByCourseId(int id);
}

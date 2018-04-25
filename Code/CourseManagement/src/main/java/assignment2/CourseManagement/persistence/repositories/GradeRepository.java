package assignment2.CourseManagement.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment2.CourseManagement.persistence.entities.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer>{
	public List<Grade> findAll();
	public Optional<Grade> findById(int id);
	public List<Grade> findAllByStudentStudentID(int id);
	public List<Grade> findAllByExamExamID(int id);
}

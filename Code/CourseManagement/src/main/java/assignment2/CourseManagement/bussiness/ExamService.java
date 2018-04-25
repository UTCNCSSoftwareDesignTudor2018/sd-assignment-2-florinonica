package assignment2.CourseManagement.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.CourseManagement.persistence.entities.Exam;
import assignment2.CourseManagement.persistence.repositories.ExamRepository;

@Service
public class ExamService {
	@Autowired
	private ExamRepository er;
	
	public Exam makeExam(Exam e) {
		return er.save(e);
	}
	
	public List<Exam> getAllExams() {
		return er.findAll();
	}
	
	public Exam getByExamName(String name) {
		return er.findByExamName(name);
	}
	
	public Optional<Exam> getByExamId(int id) {
		return er.findById(id);
	}
	
	public List<Exam> getByCourseId(int id) {
		return er.findAllByCourseCourseID(id);
	}
}

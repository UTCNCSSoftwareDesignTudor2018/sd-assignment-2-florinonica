package assignment2.CourseManagement.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.CourseManagement.persistence.entities.Grade;
import assignment2.CourseManagement.persistence.repositories.GradeRepository;

@Service
public class GradeService {
	@Autowired
	private GradeRepository gr;
	
	public Grade makeGrade(Grade g) {
		return gr.save(g);
	}
	
	public List<Grade> getAll() {
		return gr.findAll();
	}
	
	public Optional<Grade> getById(int id) {
		return gr.findById(id);
	}
	
	public List<Grade> getByStudentId(int id) {
		return gr.findAllByStudentStudentID(id);
	}
	
	public List<Grade> getByExamId(int id) {
		return gr.findAllByExamExamID(id);
	}
}

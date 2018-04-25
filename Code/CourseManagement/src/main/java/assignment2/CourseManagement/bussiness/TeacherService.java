package assignment2.CourseManagement.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.CourseManagement.persistence.entities.Teacher;
import assignment2.CourseManagement.persistence.repositories.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepository tr;
	
	public Teacher makeTeacher(Teacher t) {
		return tr.save(t);
	}
	
	public List<Teacher> getAll() {
		return tr.findAll();
	}
	
	public Optional<Teacher> getById(int id) {
		return tr.findById(id);
	}
	
	public Teacher getByName(String name) {
		return tr.findByLastName(name);
	}
}

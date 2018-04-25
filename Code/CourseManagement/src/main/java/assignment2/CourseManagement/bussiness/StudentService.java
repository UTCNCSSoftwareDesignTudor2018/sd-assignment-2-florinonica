package assignment2.CourseManagement.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.CourseManagement.persistence.entities.Student;
import assignment2.CourseManagement.persistence.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository sr;
	
	public Student makeStudent(Student s) {
		return sr.save(s);
	}
	
	public List<Student> getAll() {
		return sr.findAll();
	}
	
	public void deleteStudent(Student s) {
		sr.delete(s);
	}
	
	public void deleteStudentById(int id) {
		sr.deleteById(id);
	}
	
	public Optional<Student> getById(int id) {
		return sr.findById(id);
	}
	
	public List<Student> getByGroup(int groupid) {
		return sr.findAllByStudentGroup(groupid);
	}
	
	public Student getByName(String name) {
		return sr.findByLastName(name);
	}
}

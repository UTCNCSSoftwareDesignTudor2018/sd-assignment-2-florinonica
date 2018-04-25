package assignment2.CourseManagement.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.CourseManagement.persistence.entities.StudentEnrollment;
import assignment2.CourseManagement.persistence.repositories.StudentEnrollmentRepository;

@Service
public class StudentEnrollmentService {
	@Autowired
	private StudentEnrollmentRepository ser;
	
	public StudentEnrollment makeEnrollment(StudentEnrollment se) {
		return ser.save(se);
	}
	
	public List<StudentEnrollment> getAll() {
		return ser.findAll();
	}
	
	public List<StudentEnrollment> getByStudentId(int id) {
		return ser.findAllBySStudentID(id);
	}
	
	public List<StudentEnrollment> getByCourseId(int id) {
		return ser.findAllByCCourseID(id);
	}

	public List<StudentEnrollment> getByStatus(String status) {
		return ser.findByStatus(status);
	}
}

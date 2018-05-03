package assignment2.CourseManagement.presentation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import assignment2.CourseManagement.bussiness.ActivityReportService;
import assignment2.CourseManagement.bussiness.ExamService;
import assignment2.CourseManagement.bussiness.GradeService;
import assignment2.CourseManagement.bussiness.StudentService;
import assignment2.CourseManagement.bussiness.TeacherService;
import assignment2.CourseManagement.persistence.entities.Exam;
import assignment2.CourseManagement.persistence.entities.Grade;
import assignment2.CourseManagement.persistence.entities.Student;
import assignment2.CourseManagement.persistence.entities.StudentEnrollment;
import assignment2.CourseManagement.persistence.entities.Teacher;
import assignment2.CourseManagement.persistence.entities.builder.ActivityReportBuilder;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService ts;
	
	@Autowired
	private StudentService ss;
	
	@Autowired
	private ExamService es;
	
	@Autowired
	private GradeService gs;
	
	@Autowired
	private ActivityReportService rs;
	
	@RequestMapping(value ="/",  method = RequestMethod.POST)
    public ModelAndView studentPage()
    {
        return new ModelAndView("teacher-main-page");
    }
	
	@RequestMapping(value ="/profile",  method = RequestMethod.POST)
    public ModelAndView studentProfile()
    {
		Teacher t = ts.getByName("Marcel");
		ModelAndView mv = new ModelAndView("teacher-profile");
		mv.addObject("teacher", t);
        return mv;
    }
	
	@RequestMapping(value ="/management",  method = RequestMethod.POST)
    public ModelAndView studentManagement()
    {
		List<Student> students = ss.getAll();
		List<Exam> exams = es.getAllExams();
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("Students", students);
		mv.addObject("Exams", exams);
        return mv;
    }
	
	@RequestMapping(value ="/delete-student",  method = RequestMethod.POST)
    public ModelAndView deleteStudent(@RequestParam(value = "id", required=false) int id)
    {
		ss.deleteStudentById(id);
		List<Student> students = ss.getAll();
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("Students", students);
        return mv;
    }
	
	@RequestMapping(value ="/add-student",  method = RequestMethod.POST)
    public ModelAndView addStudent()
    {
		Student s = new Student();
		ModelAndView mv = new ModelAndView("add-student");
		mv.addObject("student", s);
        return mv;
    }
	
	@RequestMapping(value ="/save-student",  method = RequestMethod.POST)
    public ModelAndView saveStudent(@RequestParam(value = "studentID", required=false) int studentID,
    		@RequestParam(value = "username", required=false) String username,
    		@RequestParam(value = "password", required=false) String password,
    		@RequestParam(value = "firstName", required=false) String firstName,
    		@RequestParam(value = "lastName", required=false) String lastName,
    		@RequestParam(value = "CNP", required=false) String CNP,
    		@RequestParam(value = "email", required=false) String email,
    		@RequestParam(value = "address", required=false) String address,
    		@RequestParam(value = "identityCardNumber", required=false) String identityCardNumber,
    		@RequestParam(value = "studentGroup", required=false) int group)
    {
		Student student = new Student();
		student.setStudentID(studentID);
		student.setAddress(address);
		student.setCNP(CNP);
		student.setEmail(email);
		student.setEnrollments(new ArrayList<StudentEnrollment>());
		student.setIdentityCardNumber(identityCardNumber);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setPassword(password);
		student.setStudentGroup(group);
		student.setUsername(username);
		ss.makeStudent(student);
		List<Student> students = ss.getAll();
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("Students", students);
        return mv;
    }
	
	@RequestMapping(value ="/grade-student",  method = RequestMethod.POST)
    public ModelAndView gradeStudent(@RequestParam(value = "studentID", required=false) int studentID,
    		@RequestParam(value = "examID", required=false) int examID,
    		@RequestParam(value = "value", required=false) int value)
    {
		Grade grade = new Grade();
		grade.setDate(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
		grade.setValue(value);
		grade.setStudent(ss.getById(studentID).get());
		grade.setExam(es.getByExamId(examID).get());
		gs.makeGrade(grade);
		List<Student> students = ss.getAll();
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("Students", students);
        return mv;
    }
	
	@RequestMapping(value ="/report",  method = RequestMethod.POST)
    public ModelAndView reportStudent() {
		ActivityReportBuilder arb = new ActivityReportBuilder();
		arb.setId(1);
		arb.setStudent(ss.getById(6).get());
		arb.setGrades(gs.getByStudentId(6));
		//rs.makeReport(arb.build());
		ModelAndView mv = new ModelAndView("report");
		mv.addObject("student", arb.build().getStudent());
		mv.addObject("Grades", arb.build().getGrades());
        return mv;
    }
}

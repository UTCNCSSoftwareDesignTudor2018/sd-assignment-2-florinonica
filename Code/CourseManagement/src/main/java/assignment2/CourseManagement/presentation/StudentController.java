package assignment2.CourseManagement.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import assignment2.CourseManagement.bussiness.CourseService;
import assignment2.CourseManagement.bussiness.GradeService;
import assignment2.CourseManagement.bussiness.StudentEnrollmentService;
import assignment2.CourseManagement.bussiness.StudentService;
import assignment2.CourseManagement.persistence.entities.Course;
import assignment2.CourseManagement.persistence.entities.Grade;
import assignment2.CourseManagement.persistence.entities.Student;
import assignment2.CourseManagement.persistence.entities.StudentEnrollment;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService sr;
	
	@Autowired
	private StudentEnrollmentService ser;
	
	@Autowired
	private CourseService cr;
	
	@Autowired
	private GradeService gr;
	
	private final String lastName = "Strathearn";
	private int enrID = 11;
	
	@RequestMapping(value ="/",  method = RequestMethod.POST)
    public ModelAndView studentPage()
    {
        return new ModelAndView("student-main-page");
    }
	
	@RequestMapping(value ="/profile",  method = RequestMethod.POST)
    public ModelAndView studentProfile()
    {
		Student s = sr.getByName(lastName);
		ModelAndView mv = new ModelAndView("student-profile");
		mv.addObject("student", s);
        return mv;
    }
	
	@RequestMapping(value ="/enrollments",  method = RequestMethod.POST)
    public ModelAndView studentEnrollments()
    {
		List<StudentEnrollment> se = ser.getByStudentId(6);
		List<Course> courses = cr.getAllCourses();
		for(StudentEnrollment enr: se) {
			courses.remove(enr.getC());
		}
		ModelAndView mv = new ModelAndView("enrollments");
		mv.addObject("StudentEnrollment", se);
		mv.addObject("Courses", courses);
        return mv;
    }

	@RequestMapping(value ="/enroll",  method = RequestMethod.POST)
    public ModelAndView submitEnrollment(@RequestParam(value = "selectedCourse", required=false) String selectedCourse)
    {
		Student s = sr.getByName(lastName);
		StudentEnrollment newEnrollment = new StudentEnrollment();
		newEnrollment.setStatus("open");
		newEnrollment.setS(s);
		newEnrollment.setEnrollmentID(enrID);
		List<StudentEnrollment> se = ser.getByStudentId(6);
		List<Course> courses = cr.getAllCourses();
		for(StudentEnrollment enr: se) {
			courses.remove(enr.getC());
		}
		ModelAndView mv = new ModelAndView("add-enrollment");
		mv.addObject("Courses", courses);
		enrID++;

        return mv;
    }
	
	@RequestMapping(value ="/add",  method = RequestMethod.POST)
    public ModelAndView addEnrollment(@RequestParam(value = "selectedCourse") int selectedCourse)
    {
		Student s = sr.getByName(lastName);
		StudentEnrollment newEnrollment = new StudentEnrollment();
		newEnrollment.setStatus("open");
		newEnrollment.setS(s);
		newEnrollment.setEnrollmentID(enrID);
		enrID++;
		System.out.println(selectedCourse);
		newEnrollment.setC(cr.getCourseById(selectedCourse).get());
		ser.makeEnrollment(newEnrollment);
		List<StudentEnrollment> se = ser.getByStudentId(6);
		List<Course> courses = cr.getAllCourses();
		for(StudentEnrollment enr: se) {
			courses.remove(enr.getC());
		}
		ModelAndView mv = new ModelAndView("add-enrollment");
		mv.addObject("Courses", courses);
        return mv;
    }
	
	@RequestMapping(value ="/grades",  method = RequestMethod.POST)
    public ModelAndView studentGrades()
    {
		List<Grade> grades = gr.getByStudentId(6);
		ModelAndView mv = new ModelAndView("grades");
		mv.addObject("Grades", grades);
        return mv;
    }
}

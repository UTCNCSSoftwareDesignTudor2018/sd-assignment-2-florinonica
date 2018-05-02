package assignment2.CourseManagement.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import assignment2.CourseManagement.bussiness.StudentService;
import assignment2.CourseManagement.bussiness.TeacherService;
import assignment2.CourseManagement.persistence.entities.Student;
import assignment2.CourseManagement.persistence.entities.Teacher;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService ts;
	
	@Autowired
	private StudentService ss;
	
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
		ss.makeStudent(s);
        return mv;
    }
}

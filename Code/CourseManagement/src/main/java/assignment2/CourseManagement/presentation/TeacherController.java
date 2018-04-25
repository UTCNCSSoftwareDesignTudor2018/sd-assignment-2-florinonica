package assignment2.CourseManagement.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import assignment2.CourseManagement.bussiness.TeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService ts;
	
}

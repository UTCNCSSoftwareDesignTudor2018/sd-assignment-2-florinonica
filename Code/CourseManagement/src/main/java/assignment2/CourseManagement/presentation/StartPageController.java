package assignment2.CourseManagement.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class StartPageController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView startApp()
    {
        return new ModelAndView("start-page");
    }
}

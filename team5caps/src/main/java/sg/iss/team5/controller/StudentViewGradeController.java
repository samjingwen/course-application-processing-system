package sg.iss.team5.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.caps.SecurityConfigurations;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.StudentService;

@Controller
@RequestMapping("/studentGrade")
public class StudentViewGradeController {

	@Autowired
	StudentService studentService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listGrade(HttpSession session) {
		//Security
		if (!SecurityConfigurations.CheckStudAuth(session))
		{return new ModelAndView("redirect:/home/login");}
		//Security
		String sid = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();
		ArrayList<Studentcourse> cl = studentService.findCourseByStudentId(sid);
		ArrayList<Studentcourse> c2 = new ArrayList<Studentcourse>();
		for(Studentcourse current: cl)
		{if(current.getGrade() != null)
			c2.add(current);
		}
		
		ModelAndView mav = new ModelAndView("studentViewGrade");
		mav.addObject("courseList", c2);
		double gpa = studentService.getGpa(c2);
		mav.addObject("gpa", gpa);
		return mav;
	}
	
}

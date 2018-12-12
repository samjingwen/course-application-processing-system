package sg.iss.team5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.LecturerService;

@Controller
@RequestMapping(value ="/grade")
public class LecturerGradeCourseController {
	
	@Autowired
	LecturerService q;
	
	@RequestMapping(value = "/gradebook", method = RequestMethod.GET)
	
	public ModelAndView listAllStudentcourse(){
		ArrayList<Studentcourse> scList = q.findAllStudentcourse();
		ModelAndView mav = new ModelAndView("gradebook");
		mav.addObject("scList", scList);
		return mav;
	}
	
	@RequestMapping(value= "/home", method= RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	
}

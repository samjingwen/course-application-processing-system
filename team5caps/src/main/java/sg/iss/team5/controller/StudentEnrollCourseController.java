package sg.iss.team5.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Module;
import sg.iss.team5.service.StudentService;

@RequestMapping(value ="/studentenroll")
@Controller
public class StudentEnrollCourseController {

	@Autowired
	StudentService stuservice;
	
	@RequestMapping(value= "/modules", method= RequestMethod.GET)
	public ModelAndView listAll() throws Exception {
		Date year = new SimpleDateFormat("yyyy").parse("2018");
		ArrayList<Module> mlist = stuservice.findModuleByAcademicYear(year);
		ModelAndView mav = new ModelAndView("availablemods");
		return mav.addObject("modules", mlist);
	}
}

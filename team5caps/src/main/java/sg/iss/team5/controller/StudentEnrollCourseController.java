package sg.iss.team5.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Module;
import sg.iss.team5.repository.ModuleRepository;
import sg.iss.team5.service.StudentService;

@Controller
@RequestMapping(value ="/studentenroll")
public class StudentEnrollCourseController {

	@Autowired
	ModuleRepository stuservice;
	
	@RequestMapping(value= "/modules", method= RequestMethod.GET)
	
	public ModelAndView listAll() throws ParseException{
		//Date year = new SimpleDateFormat("yyyy").parse("2017");
		//ArrayList<Module> mlist = stuservice.findModuleByAcademicYear(year);
		//ArrayList<Module>mlist = (ArrayList<Module>) stuservice.findAll();
		ArrayList<Module> mlist = (ArrayList<Module>)stuservice.findModuleByLecturerId("L00001");
		ModelAndView mav = new ModelAndView("availablemods");
		mav.addObject("modules", mlist);
		return mav;
	}
	
	@RequestMapping(value= "/home", method= RequestMethod.GET)
	public String home() {
		return "index";
	}
}

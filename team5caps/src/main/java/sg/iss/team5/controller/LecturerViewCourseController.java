package sg.iss.team5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Module;
import sg.iss.team5.service.LecturerService;
//View courses taught & show rating
@Controller
@RequestMapping(value="/lecturer")
public class LecturerViewCourseController {

	@Autowired
	LecturerService lectservice;
	
	
	@RequestMapping(value ="/courselist/{lid}", method=RequestMethod.GET)
	public ModelAndView listAll(@PathVariable String lid) {
		ArrayList<Module> mlist = lectservice.findModuleByLecturerId(lid);
		ModelAndView mav = new ModelAndView("ViewModules");
		mav.addObject("modules",mlist);
		return mav;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView lsitAll() {
		//ArrayList<Module> mlist = lectservice.findAllModule();
		ModelAndView mav = new ModelAndView("ViewModules");
		ArrayList<Module> mlist = lectservice.findAllModule();
		mav.addObject("modules",mlist);
		return mav;
	}
	
}

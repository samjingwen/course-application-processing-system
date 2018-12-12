package sg.iss.team5.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.LecturerService;

@Controller
@RequestMapping(value ="/grade")
public class LecturerGradeCourseController {
	
	@Autowired
	private LecturerService lService;
	
	@RequestMapping(value = "/gradebook", method = RequestMethod.GET)
	
	public ModelAndView listAllStudentcourse(){
		 ModelAndView mav = new ModelAndView("gradebook");
		 String lid="L00007";
		 //String lid =session.getAttribute("ID").toString();
		 ArrayList<Module>sm=new ArrayList<Module>();
		 ArrayList<String>cList=new ArrayList<String>();
		 sm=lService.findModuleByLecturerId(lid);
		 for (Module module : sm) {
			 String eachcourse=module.getCoursedetail().getCourseName();
			 cList.add(eachcourse);
		}
	    mav.addObject("courselist", cList); 
		ArrayList<Studentcourse> scList = lService.findAllStudentcourse();
		mav.addObject("scList", scList);
		return mav;
	}
	
	@RequestMapping(value= "/home", method= RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value= "/courselist")
	@Transactional
	public ModelAndView ShowCourseList(HttpSession session) {
		 ModelAndView mav = new ModelAndView("gradebook");
		 String lid="L00003";
		 //String lid =session.getAttribute("ID").toString();
		 ArrayList<Module>sm=new ArrayList<Module>();
		 ArrayList<String>cList=new ArrayList<String>();
		 sm=lService.findModuleByLecturerId(lid);
		 for (Module module : sm) {
			 String eachcourse=module.getCoursedetail().getCourseName();
			 cList.add(eachcourse);
		}
		 mav.addObject("courselist", cList); 
		 return mav;
	}
	
}

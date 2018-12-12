package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.LecturerService;

@Controller
@RequestMapping(value ="/grade")
public class LecturerGradeCourseController {
	
	@Autowired
	private LecturerService lService;
	
	@RequestMapping(value = "/gradebook", method = RequestMethod.GET)
	public ModelAndView listAllStudentcourse(@RequestParam("selectone.getvalue()") Module selectone){
		 ModelAndView mav = new ModelAndView("gradebook");
		 String lid="L00007";
		 //String lid =session.getAttribute("USERSESSION").toString();
		 
		 //Show courses taught by lecture in dropdownlist
		 ArrayList<Module>sm=new ArrayList<>();
		 HashMap<String,Module> cList=new HashMap <>();
		 sm=lService.findModuleByLecturerId(lid);
		 for (Module module : sm) {
			 String eachcourse=module.getCoursedetail().getCourseName();
			 Module eachmodule=module;
			 cList.put(eachcourse, eachmodule);
		}
	    mav.addObject("courselist", cList); 
	    
	    //Get list of students from module(dropdownlist selected)
	   List<Studentcourse> scList =new ArrayList<>();
	   ArrayList<Student> stuList=new ArrayList<>();
	   scList=selectone.getStudentcourses();
	   for (Studentcourse studentcourse : scList) {
		   Student student=studentcourse.getStudent();
		   stuList.add(student);		
	}   	   
		mav.addObject("scList", stuList);
		return mav;
	}
	
	@RequestMapping(value= "/home", method= RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	
	
}

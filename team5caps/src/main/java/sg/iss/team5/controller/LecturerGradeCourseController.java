package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.LecturerService;
import sg.iss.team5.service.StudentService;

@Controller
@RequestMapping(value = "/grade")
@Transactional
public class LecturerGradeCourseController {
	@Autowired
	private StudentService sService;
	@Autowired
	private LecturerService lService;
	@RequestMapping(value = "/gradebook", method = RequestMethod.GET)
	public ModelAndView listAllStudentcourse() {
		ModelAndView mav = new ModelAndView("gradebook6");
		String lid = "L00007";
		// String lid =session.getAttribute("USERSESSION").toString();
		// Show courses taught by lecture in dropdownlist
		ArrayList<Module> sm = new ArrayList<Module>();
		HashMap<String, Module> cList = new HashMap<>();
		sm = lService.findModuleByLecturerId(lid);
		for (Module module : sm) {
			String eachcourse = module.getCoursedetail().getCourseName();
			Module eachmodule = module;
			cList.put(eachcourse, eachmodule);
		}
		//to
		mav.addObject("courselist", cList);
		return mav;
	}
	
	@RequestMapping(value = "/gradebook/exact", method = RequestMethod.POST)
	public ModelAndView listAllStudent(@RequestParam("selectone") String moduleID) {
		// Get list of students from module(dropdownlist selected)
		    ModelAndView mav = new ModelAndView("gradebook");
		    Module selectone=sService.findModulebyID("0117A0006");	
			List<Studentcourse> scList = new ArrayList<>();
			scList = selectone.getStudentcourses();
			//get the  student list of exact course
			mav.addObject("scList", scList);		
			mav.addObject("moduleID", moduleID);
			return mav;
		   
	}
	
	@RequestMapping(value = "/gradebook/gradeconfirm", method = RequestMethod.POST)
	public ModelAndView showGradeStudent(@ModelAttribute("scList") Studentcourse scList, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("testing");
		Map<String, String[]> parameters = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
			
			
			
			
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		
		
		
		System.out.println(parameters.get("S00006"));
		System.out.println("HAHAHAHA");
		
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

}

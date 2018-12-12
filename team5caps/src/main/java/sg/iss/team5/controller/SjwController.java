package sg.iss.team5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.service.StudentService;


@Controller
public class SjwController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/sjw")
	public String showHome() {
		return "index";
	}
	
	@RequestMapping(value = {"/sjw/home"}, method = RequestMethod.GET)
	public ModelAndView showTesting() {
		ArrayList<Coursedetail> cdList = new ArrayList<Coursedetail>();
		cdList = studentService.findAllCoursedetail();
		for (Coursedetail cd : cdList) {
			System.out.println(cd);
		}
		System.out.println("HAHAHAHAHAHAH");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("testing");
		mv.addObject("cdList", cdList);
		return mv;
	}
	
	
	
	@RequestMapping(value = {"/sjw/admin"}, method = RequestMethod.GET)
	public ModelAndView showAdmin() {
		return null;


	}
	
}

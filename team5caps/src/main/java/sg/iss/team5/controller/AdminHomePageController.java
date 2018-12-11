package sg.iss.team5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Student;
import sg.iss.team5.service.AdminService;

@Controller
public class AdminHomePageController {
	@Autowired
	AdminService adminService;

	@RequestMapping(value="/admin/homepage", method=RequestMethod.GET)
	public ModelAndView listStudentsNotEnrolled() {
		ArrayList<Student> studentNotEnrolledList=adminService.findNotEnrolled();
		ModelAndView mav=new ModelAndView("admin_homepage");
		mav.addObject("listNotEnrolled",studentNotEnrolledList);
		return mav;
	}
}

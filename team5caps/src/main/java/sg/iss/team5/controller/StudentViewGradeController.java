package sg.iss.team5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.StudentService;

@Controller
@RequestMapping("/studentGrade")
public class StudentViewGradeController {

	@Autowired
	StudentService studentService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listGrade(String sid) {
		ArrayList<Studentcourse> cl = studentService.findCourseByStudentId("S00006");
		ModelAndView mav = new ModelAndView("studentViewGrade");
		mav.addObject("courseList", cl);
		return mav;
	}
	
}

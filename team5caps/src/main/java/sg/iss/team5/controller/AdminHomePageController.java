package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminHomePageController {
	@Autowired
	AdminService adminService;
	
	Logger logger = LoggerFactory.getLogger(AdminHomePageController.class);

	@RequestMapping(value = "/homepage")
	public ModelAndView listStudentsNotEnrolled() {
		ArrayList<Student> studentNotEnrolledList = adminService.findNotEnrolled();
		ModelAndView mav = new ModelAndView("admin_homepage");
		mav.addObject("listNotEnrolled", studentNotEnrolledList);
		return mav;
	}

	@RequestMapping(value = "/manage/courses")
	public ModelAndView listAllCourses() {
		
		ModelAndView mav = new ModelAndView("admin_courselist");
		ArrayList<Coursedetail> listAllCourse = adminService.getCourseDetailList();
		mav.addObject("listAllCourse", listAllCourse);

		// get quantity of students enrolled
		ArrayList<Integer> capacity = new ArrayList<>();
		for (Coursedetail current : listAllCourse) {
			capacity.add(adminService.getEnrolledCapacity(current.getCourseID()));
		}
		mav.addObject("enrolledCapacity", capacity);
//		
//		HashMap<Coursedetail, Integer> pair = new HashMap<>();
//		for (int i =0;i<capacity.size();i++) {
//			pair.put(listAllCourse.get(i), capacity.get(i));
//			logger.info("key and value -> {},{}",listAllCourse.get(i), capacity.get(i));
//		}
//		mav.addObject(pair);
		return mav;
	}
	
	@RequestMapping(value = "/manage/courses/{cid}")
	public ModelAndView listStudentsInCourse(@PathVariable String cid) {
		ArrayList<Studentcourse> sclist = adminService.findCourseByCourseId(cid);
		ModelAndView mav = new ModelAndView("admin_coursedetails");
		mav.addObject("studentcourse",sclist);
		return mav;
	}
	
	@RequestMapping(value = "/manage/courses/{mid}/{sid}", method = RequestMethod.GET)
	public ModelAndView dropStudent(@PathVariable String mid, @PathVariable String sid) {
		Student student = adminService.findStudentById(sid);
		Module module = adminService.findByModuleID(mid);
		ModelAndView mav = new ModelAndView("admin_dropstudent");
		mav.addObject("student",student);
		mav.addObject("module",module);
		return mav;
	}
	
	@RequestMapping(value = "/manage/courses/{mid}/{sid}", method = RequestMethod.POST)
	public String dropStudentConfirm(@PathVariable String mid, @PathVariable String sid) {
		Studentcourse sc = adminService.findByModuleIDCourseID(mid, sid);
		adminService.removeStudentCourse(sc);
		return "admin_successful";
	}

//	To manage approval
//	@RequestMapping(value="/manage/enroll", method=RequestMethod.GET)
//	public ModelAndView showStudentsNotEnrolled() {
//		ArrayList<Student> studentNotEnrolledList=adminService.findNotEnrolled();
//		ModelAndView mav=new ModelAndView("admin_homepage");
//		mav.addObject("listNotEnrolled",studentNotEnrolledList);
//		return mav;
//	}
}

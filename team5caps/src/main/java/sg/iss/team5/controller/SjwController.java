package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Request;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.StudentcoursePK;
import sg.iss.team5.service.AdminService;
import sg.iss.team5.service.LecturerService;
import sg.iss.team5.service.StudentService;


@Controller
public class SjwController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private LecturerService lecturerService;
	
	@RequestMapping("/sjw")
	public String showHome() {
		return "index";
	}
	
	@ModelAttribute("modulesList")
	public ArrayList<Module> getAllModules(){
		return studentService.findAllModule();
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
	
	
	
	@RequestMapping(value = {"/sjw/request"}, method = RequestMethod.GET)
	public ModelAndView showRequest(Model model) {
		model.addAttribute("module", new Module());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("requestEnrollment");
		return mav;
	}
	
	@RequestMapping(value = {"/sjw/request"}, method = RequestMethod.POST)
	public ModelAndView showRequest(@ModelAttribute("module") Module module) {
		ModelAndView mav = new ModelAndView();
		Request newReq = new Request();
		module = lecturerService.findModuleByModuleID(module.getModuleID());
		System.out.println(module.getCoursedetail().getCourseName());
		System.out.println("HAHAHAHAHA");
		newReq.setCourseName(module.getCoursedetail().getCourseName());
		newReq.setLecturerName(module.getLecturer().getUser().getFirstName() + " " + module.getLecturer().getUser().getLastName());
		newReq.setModuleID(module.getModuleID());
		newReq.setVenue(module.getVenue());
		System.out.println(newReq);
		mav.addObject("newRequest", newReq);
		mav.setViewName("confirmRequest");
		return mav;
	}
	
	@RequestMapping(value = {"/sjw/confirm/{mid}"}, method = RequestMethod.POST)
	public String showConfirmRequest(@ModelAttribute("module") Module module, HttpSession session, @PathVariable String mid) {
		
		Studentcourse sc = new Studentcourse();
		StudentcoursePK scPK = new StudentcoursePK();
		module = lecturerService.findModuleByModuleID(mid);
		scPK.setModuleID(module.getModuleID());
		Student student = ((UserSession) session.getAttribute("USERSESSION")).getUser().getStudent();
		sc.setStudent(student);
		scPK.setStudentID(student.getStudentID());
		sc.setId(scPK);
		sc.setModule(module);
		sc.setEnrollStatus("Pending");
		sc.setEnrollTime(Calendar.getInstance().getTime());
		module.getStudentcourses().add(sc);
		//lecturerService.updateModule(module);
		lecturerService.createStudentcourse(sc);
		return "requestSuccess";
	}
	
}

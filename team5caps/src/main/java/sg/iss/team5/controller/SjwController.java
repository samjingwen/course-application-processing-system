package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public ArrayList<Module> getAllModules() {
		return studentService.findAllModule();
	}

	@RequestMapping(value = { "/sjw/home" }, method = RequestMethod.GET)
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
		ArrayList<String> mList = lecturerService.getAllModuleID();
		for (String mid : mList)
			System.out.println(mid);
		mv.addObject("modules", mList);
		return mv;
	}

	@RequestMapping(value = { "/sjw/request" }, method = RequestMethod.GET)
	public ModelAndView showRequest(Model model) {
		model.addAttribute("request", new Request());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("requestEnrollment");
		ArrayList<String> mList = lecturerService.getAllModuleID();
		for (String mid : mList)
			System.out.println(mid);
		mav.addObject("modules", mList);
		return mav;
	}

	@RequestMapping(value = { "/sjw/request" }, method = RequestMethod.POST)
	public ModelAndView showRequest(@ModelAttribute("request") Request request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Studentcourse sc = lecturerService.findStudentcourseByPK(request.getStudentID(), request.getModuleID());
		if (sc != null) {
			mav.setViewName("redirect:/sjw/home");
			return mav;
		}
		Module module = new Module();
		module = lecturerService.findModuleByModuleID(request.getModuleID());
		System.out.println(module.getCoursedetail().getCourseName());
		System.out.println("HAHAHAHAHA");
		request.setCourseName(module.getCoursedetail().getCourseName());
		request.setLecturerName(
				module.getLecturer().getUser().getFirstName() + " " + module.getLecturer().getUser().getLastName());
		request.setModuleID(module.getModuleID());
		request.setVenue(module.getVenue());
		System.out.println(request);
		mav.addObject("newRequest", request);
		mav.setViewName("confirmRequest");
		session.setAttribute("REQUEST", request);
		return mav;
	}

	@RequestMapping(value = { "/sjw/confirm/{mid}" }, method = RequestMethod.POST)
	public String showConfirmRequest(@ModelAttribute("request") Request request, HttpSession session,
			@PathVariable String mid) {
		
		Studentcourse sc = new Studentcourse();
		StudentcoursePK scPK = new StudentcoursePK();
		Module module = new Module();
		module = lecturerService.findModuleByModuleID(mid);
		request = (Request) session.getAttribute("REQUEST");
		scPK.setModuleID(mid);
		Student student = lecturerService.findStudentByStudentID(request.getStudentID());
		sc.setStudent(student);
		scPK.setStudentID(student.getStudentID());
		sc.setId(scPK);
		sc.setModule(module);
		sc.setEnrollStatus("Pending");
		sc.setEnrollTime(Calendar.getInstance().getTime());
		//module.getStudentcourses().add(sc);
		// lecturerService.updateModule(module);
		lecturerService.createStudentcourse(sc);
		return "requestSuccess";
	}

}

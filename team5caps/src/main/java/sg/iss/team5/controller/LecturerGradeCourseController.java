package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@ModelAttribute("module")
	public Module createModule() {
		return new Module();
	}

	@RequestMapping(value = "/gradebook", method = RequestMethod.GET)
	public ModelAndView listAllStudentcourse(HttpSession session) {
		ModelAndView mav = new ModelAndView("gradebook6");
		String lid = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();
		ArrayList<Module> sm = new ArrayList<Module>();
		HashMap<String, Module> cList = new HashMap<>();
		sm = lService.findModuleByLecturerId(lid);
		for (Module module : sm) {
			String eachcourse = module.getCoursedetail().getCourseName();
			Module eachmodule = module;
			cList.put(eachcourse, eachmodule);
		}
		mav.addObject("courselist", cList);
		return mav;
	}

	@RequestMapping(value = "/gradebook/exact", method = RequestMethod.POST)
	public ModelAndView listAllStudent(@ModelAttribute("module") Module module, HttpSession session) {
		// Get list of students from module(dropdownlist selected)
		ModelAndView mav = new ModelAndView("gradebook");
		// module = sService.findModulebyID(module.getModuleID());
		module = sService.findModulebyID("0617H0007");
		List<Studentcourse> scList = module.getStudentcourses();
		// module = sService.findModulebyID("0117A0006");

		// get the student list of exact course
		mav.addObject("scList", scList);
		mav.addObject("moduleID", module.getModuleID());
		return mav;

	}

	@RequestMapping(value = "/gradebook/gradeconfirm", method = RequestMethod.POST)
	public ModelAndView showGradeStudent(@ModelAttribute("module") Module module, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("testing");
		String mid = module.getModuleID();
		module = sService.findModulebyID(mid);
		Map<String, String[]> parameters = request.getParameterMap();
		List<Studentcourse> scList = module.getStudentcourses();
		Iterator<Studentcourse> iter = scList.iterator();
		while (iter.hasNext()) {
			Studentcourse sc = iter.next();
			String[] arr = parameters.get(sc.getStudent().getStudentID());
			if (arr[0] == null)
				return new ModelAndView("testingeidt");
			String grade = arr[0];
			if (grade.equals("A") || grade.equals("B") || grade.equals("C")
					|| grade.equals("D") || grade.equals("E") || grade.equals("F")) {
				sc.setGrade(grade);
				lService.updateStudentcourse(sc);
			}
		}
		
		
//		for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
//			System.out.println(entry.getKey().toString() + "/" + entry.getValue().toString());
//		}
//
//		String mid = module.getModuleID();
//		module = sService.findModulebyID(mid);
//		
//		for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
//			if (entry.getValue()[0].equals("A") || entry.getValue()[0].equals("B") || entry.getValue()[0].equals("C")
//					|| entry.getValue()[0].equals("D") || entry.getValue()[0].equals("E")) {
//				Studentcourse sc = iter.next();
//				sc.setGrade(entry.getValue()[0]);
//				lService.updateStudentcourse(sc);
//			}
//
//		}

//		Studentcourse sc = lService.findStudentcourseByPK("S00006", "0117A0006");
//		sc.setGrade(parameters.get("S00006")[0]);
//		lService.updateStudentcourse(sc);
//		System.out.println(sc.getModule().getModuleID());
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

}

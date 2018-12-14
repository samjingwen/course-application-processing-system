package sg.iss.team5.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
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

import sg.iss.team5.caps.SecurityConfigurations;
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
		// Security
		if (!SecurityConfigurations.CheckLectAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		ModelAndView mav = new ModelAndView("gradebook6");
		String lid = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();
		ArrayList<Module> thisyearmodule = new ArrayList<Module>();
		HashMap<String, Module> cList = new HashMap<>();
		ArrayList<Module> allmodule = new ArrayList<Module>();
		thisyearmodule = lService.findModuleByLecturerId(lid);
		// Get current Year

		Date date = new Date();
		int year = date.getYear();
		// get current year module

		for (Module module : allmodule) {
			if (module.getAcademicYear().getYear() == year) {
				thisyearmodule.add(module);
			}
		}
		// get hashmap ,key is coursename ,value is module

		for (Module module : thisyearmodule) {
			String eachcourse = module.getCoursedetail().getCourseName();
			Module eachmodule = module;
			cList.put(eachcourse, eachmodule);
		}
		mav.addObject("courselist", cList);
		return mav;
	}

	@RequestMapping(value = "/gradebook/exact", method = RequestMethod.POST)
	public ModelAndView listAllStudent(@ModelAttribute("module") Module module, HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckLectAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security

		// Get list of students from module(dropdownlist selected)
		ModelAndView mav = new ModelAndView("gradebook");
		module = sService.findModulebyID(module.getModuleID());

		// module = sService.findModulebyID("0617H0007");
		List<Studentcourse> scList = module.getStudentcourses();
		// module = sService.findModulebyID("0117A0006");

		// get the student list of exact course
		mav.addObject("scList", scList);
		mav.addObject("moduleID", module.getModuleID());
		return mav;

	}

	@RequestMapping(value = "/gradebook/gradeconfirm", method = RequestMethod.POST)
	public ModelAndView showGradeStudent(@ModelAttribute("module") Module module, HttpServletRequest request, HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckLectAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		
		ModelAndView mav = new ModelAndView("gradeSuccess");
		String mid = module.getModuleID();
		module = sService.findModulebyID(mid);
		Map<String, String[]> parameters = request.getParameterMap();
		List<Studentcourse> scList = module.getStudentcourses();
		Iterator<Studentcourse> iter = scList.iterator();
		//Update grade for studentcourse
		while (iter.hasNext()) {
			Studentcourse sc = iter.next();
			String[] arr = parameters.get(sc.getStudent().getStudentID());
			if (arr[0] == null)
				return new ModelAndView("gradeFail");
			String grade = arr[0];
			if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("E")
					|| grade.equals("F")) {
				sc.setGrade(grade);
				lService.updateStudentcourse(sc);
			}
		}
		return mav;
	}
}

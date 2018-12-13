package sg.iss.team5.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.FormattedModule;
import sg.iss.team5.model.FormattedSC;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.StudentcoursePK;
import sg.iss.team5.service.AdminService;
import sg.iss.team5.service.StudentService;

@RestController
@RequestMapping(value = "/studentenroll")
public class StudentEnrollCourseController {

	@Autowired
	StudentService stuservice;
	@Autowired
	private AdminService adService;

	@RequestMapping(value = "/modules", method = RequestMethod.GET)
	public ModelAndView listAllNotTaken(HttpSession session) throws ParseException {
		String sid = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();
		Date date = Calendar.getInstance().getTime();
		ArrayList<FormattedModule> mlist = (ArrayList<FormattedModule>) stuservice
				.getFormat(stuservice.findModuleNotEnrolled(sid, date));

		ModelAndView mav = new ModelAndView("availablemods");

		mav.addObject("formattedmodules", mlist);
		return mav;
	}

	@RequestMapping(value = "/enrollin", method = RequestMethod.POST)
	public ModelAndView enrollStudent(@RequestParam("modid") String[] modid, HttpServletRequest request,
			HttpSession session) {
		String sid = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();
		Student s = adService.findStudentById(sid);
		ArrayList<Studentcourse> clist = new ArrayList<Studentcourse>();
		ArrayList<Module> mlist = new ArrayList<Module>();
		for (String current : modid) {
			mlist.add(stuservice.findModulebyID(current));
			if (mlist.contains(stuservice.findModulebyID(current))) {
				ModelAndView mav = new ModelAndView("testing");
				return mav;
			} else {
				mlist.add(stuservice.findModulebyID(current));
			}
			clist = stuservice.enrollCourse(mlist, s);
		}
		for (Studentcourse sc : clist) {
			sc.setId(new StudentcoursePK(sc.getModule().getModuleID(), sc.getStudent().getStudentID()));
			stuservice.saveStudentCourse(sc);
		}
		ModelAndView mav = new ModelAndView("studentenrollment");
		mav.addObject("mlist", mlist);
		return mav;

	}

	@RequestMapping(value = "/currenroll", method = RequestMethod.GET)
	public ModelAndView listAllTaken(HttpSession session) throws ParseException {
		String sid = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();
		ArrayList<FormattedSC> sclist = (ArrayList<FormattedSC>) stuservice
				.getFormatSC(stuservice.findCourseByStudentId(sid));

		ModelAndView mav = new ModelAndView("studentenrollment");
		mav.addObject("sclist", sclist);
		return mav;

	}

}

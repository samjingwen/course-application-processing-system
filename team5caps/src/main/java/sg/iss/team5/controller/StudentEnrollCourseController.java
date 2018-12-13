package sg.iss.team5.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
		// View available modules to enroll
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
		// Student enrollment
		String sid = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();
		Student s = adService.findStudentById(sid);
		ArrayList<Studentcourse> clist = new ArrayList<Studentcourse>();
		ArrayList<Module> mlist = new ArrayList<Module>();
		int check = 0;
		int curcount = stuservice.findSCbyStuandYear(sid).size();

		ArrayList<Module> enmlist = new ArrayList<Module>();
		for (Studentcourse sc : stuservice.findSCbyStuandYear(sid)) {
			enmlist.add(stuservice.findModulebyID(sc.getModule().getModuleID()));
		}

		for (String current : modid) {
			if (mlist.size() < 1) {
				check++;
				mlist.add(stuservice.findModulebyID(current));
			}

			// check for time conflicts 
			//STILL NOT DONE YET
			else if (mlist.contains(stuservice.findModulebyID(current))
					|| enmlist.contains(stuservice.findModulebyID(current))) {
				check = 0;
				JOptionPane.showMessageDialog(null, "You have added modules with conflicting times!", "Conflicts",
						JOptionPane.WARNING_MESSAGE);

			}
			// add module to list for enrollment
			else {
				mlist.add(stuservice.findModulebyID(current));
				check++;
			}
		}

		//check if amount of modules added for the year exceeds 5
		if ((mlist.size() > 5) || (mlist.size() > (5 - curcount))) {
			check = 0;
			JOptionPane.showMessageDialog(null, "You may only add up to 5 modules per year.", "Too many modules!",
					JOptionPane.WARNING_MESSAGE);
		}
		//enroll student in module
		if (check > 0) {
			clist = stuservice.enrollCourse(mlist, s);

			for (Studentcourse sc : clist) {
				sc.setId(new StudentcoursePK(sc.getModule().getModuleID(), sc.getStudent().getStudentID()));
				stuservice.saveStudentCourse(sc);
			}
			JOptionPane.showMessageDialog(null, "Successfully enrolled in module(s)!", "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			ArrayList<FormattedSC> sclist = (ArrayList<FormattedSC>) stuservice
					.getFormatSC(stuservice.findCourseByStudentId(sid));
			ModelAndView mav = new ModelAndView("studentenrollment");
			mav.addObject("sclist", sclist);
			return mav;
			
		// if any of the above fails, return to module selection page	
		} else {
			Date date = Calendar.getInstance().getTime();
			ArrayList<FormattedModule> m2list = (ArrayList<FormattedModule>) stuservice
					.getFormat(stuservice.findModuleNotEnrolled(sid, date));

			ModelAndView mav = new ModelAndView("availablemods");

			mav.addObject("formattedmodules", m2list);
			return mav;
		}

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

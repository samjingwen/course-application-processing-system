package sg.iss.team5.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.FormattedModule;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.User;
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
	public ModelAndView listAllNotTaken(HttpSession session)
			throws ParseException {
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
		for (String s : modid)
			
		
		ModelAndView mav = new ModelAndView("testing");
		mav.addObject("modid", modid);
//		String[] modids = request.getParameterValues("modid");
//		
//		/*ArrayList<Studentcourse> sc = new ArrayList<Studentcourse>();
//		for(String current: modids)
//		{
//			sc.add(new Studentcourse("Enrolled",Calendar.getInstance().getTime(),))
//		}*/
//		ModelAndView mav = new ModelAndView("redirect:/modules/S00006");
//		
		return mav;
	}

	/*
	 * @RequestMapping(value = "/modules/{sid}", method = RequestMethod.POST) public
	 * ModelAndView addAllNotTaken(@PathVariable String sid) throws ParseException {
	 * 
	 * String[] modid = request.getParameterValues("modid") ModelAndView mav = new
	 * ModelAndView("availablemods");
	 * 
	 * mav.addObject("formattedmodules", mlist); return mav; }
	 */

}

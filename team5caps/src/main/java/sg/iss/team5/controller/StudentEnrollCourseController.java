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
import sg.iss.team5.service.StudentService;

@RestController
@RequestMapping(value = "/studentenroll")
public class StudentEnrollCourseController {

	@Autowired
	StudentService stuservice;

	@RequestMapping(value = "/modules/{sid}", method = RequestMethod.GET)
	public ModelAndView listAllNotTaken(@PathVariable String sid, HttpSession session, BindingResult result) throws ParseException {
		String sid2 = ((UserSession) session.getAttribute("USERSESSION")).getUser().getUserID();

		ArrayList<FormattedModule> mlist = (ArrayList<FormattedModule>) stuservice
				.getFormat(stuservice.findModuleNotEnrolled(sid, date));

		ModelAndView mav = new ModelAndView("availablemods");

		mav.addObject("formattedmodules", mlist);
		return mav;
	}

	
	@RequestMapping(value = "/enrollin", method = RequestMethod.POST)
	public ModelAndView enrollStudent(@RequestParam("modid") String[] modid, HttpServletRequest request, HttpSession session)
	{
		for (String s:modid)
			System.out.println(s);
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
	
/*	@RequestMapping(value = "/modules/{sid}", method = RequestMethod.POST)
	public ModelAndView addAllNotTaken(@PathVariable String sid) throws ParseException {

		String[] modid = request.getParameterValues("modid")
		ModelAndView mav = new ModelAndView("availablemods");

		mav.addObject("formattedmodules", mlist);
		return mav;
	}*/


}

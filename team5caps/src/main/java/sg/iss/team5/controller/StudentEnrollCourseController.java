package sg.iss.team5.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.FormattedModule;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.StudentService;

@Controller
@RequestMapping(value = "/studentenroll")
public class StudentEnrollCourseController {

	@Autowired
	StudentService stuservice;

	@RequestMapping(value = "/modules/{sid}", method = RequestMethod.GET)
	public ModelAndView listAllNotTaken(@PathVariable String sid) throws ParseException {

		Date date = Calendar.getInstance().getTime();
		ArrayList<FormattedModule> mlist = (ArrayList<FormattedModule>) stuservice
				.getFormat(stuservice.findModuleNotEnrolled(sid, date));

		ModelAndView mav = new ModelAndView("availablemods");

		mav.addObject("formattedmodules", mlist);
		return mav;
	}

	@RequestMapping(value = "/modules/{sid}", method = RequestMethod.POST, params= {"Enroll"})
	public ModelAndView enrollStudent(@RequestParam("modid") String[] modid, HttpServletRequest request, HttpSession session)
	{
		String[] modids = request.getParameterValues("modid");
		
		/*ArrayList<Studentcourse> sc = new ArrayList<Studentcourse>();
		for(String current: modids)
		{
			sc.add(new Studentcourse("Enrolled",Calendar.getInstance().getTime(),))
		}*/
		ModelAndView mav = new ModelAndView("redirect:/modules/S00006");
		
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

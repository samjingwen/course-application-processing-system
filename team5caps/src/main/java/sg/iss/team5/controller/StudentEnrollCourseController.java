package sg.iss.team5.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.FormattedModule;
import sg.iss.team5.model.Module;
import sg.iss.team5.repository.ModuleRepository;
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

}

package sg.iss.team5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.LecturerService;
import sg.iss.team5.service.StudentService;

//View courses taught & show rating
@Controller
@RequestMapping(value = "/lecturer")
public class LecturerViewCourseController {

	@Autowired
	LecturerService lectservice;
	
	@Autowired
	StudentService studentservice;

	@RequestMapping(value = "/courselist/{lid}", method = RequestMethod.GET)
	public ModelAndView listAllbyLectId(@PathVariable String lid) {
		ArrayList<Module> mlist = lectservice.findPastModuleByLectId(lid);
		ModelAndView mav = new ModelAndView("ViewModules");
		mav.addObject("modules", mlist);
		
		ArrayList<Double> ratingList = new ArrayList<>();
		for (int i=0; i < mlist.size(); i++) {
			Double ratingAverage = lectservice.findLecturerRatingByModuleId(mlist.get(i).getModuleID());
			ratingList.add(ratingAverage);
		}
		mav.addObject("ratings", ratingList);

		ArrayList<String> attList = new ArrayList<>();
		for (int i=0; i < mlist.size(); i++) {
		String attAverage = lectservice.findAttendanceByModuleId(mlist.get(i).getModuleID());
		attList.add(attAverage);
		}
		mav.addObject("attendance", attList);		
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<Module> mlist = lectservice.findModuleByLecturerId("L00002");
		ModelAndView mav = new ModelAndView("ViewModules");
		// ArrayList<Module> mlist = (ArrayList<Module>)lectservice.findAll();
		mav.addObject("modules", mlist);
		
		return mav;
	}

	@RequestMapping(value = "/enrollist/{mid}", method = RequestMethod.GET)
	public ModelAndView findCourseByModuleId(@PathVariable String mid) {
		ArrayList<Studentcourse> mlist = lectservice.findCourseByModuleId(mid);
		ModelAndView mav = new ModelAndView("ViewEnrolment");
		mav.addObject("modules", mlist);
		return mav;
	}
	
	@RequestMapping(value = "/enrollrequest", method = RequestMethod.GET)
	public ModelAndView editStudentPage() {
		ModelAndView mav = new ModelAndView("RequestEnolment");
		mav.addObject("student",studentservice);
		return mav;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

}
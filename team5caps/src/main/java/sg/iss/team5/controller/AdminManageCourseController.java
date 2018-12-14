package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Student;
import sg.iss.team5.service.AdminCourse;


@Controller
@RequestMapping(value = "/admin")
public class AdminManageCourseController {

	@Autowired
	private AdminCourse adminCourse;

	@RequestMapping(value = { "/manage/courses" }, method = RequestMethod.GET)
	public ModelAndView showTesting() {
		ArrayList<Coursedetail> courselist = new ArrayList<Coursedetail>();
		courselist = adminCourse.findAllCoursedetails();
		for (Coursedetail course : courselist) {
			System.out.println(course);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListCourse");
		mv.addObject("cList", courselist);
		return mv;
	}
	
	@RequestMapping(value = "/courses/create", method = RequestMethod.GET)
	public ModelAndView newCoursepage() {
		ModelAndView mav = new ModelAndView("FormCourse", "course", new Coursedetail());
		return mav;
	}
	@RequestMapping(value = "/courses/create", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@ModelAttribute @Valid Coursedetail course, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("FormCourse");
		//course.getUser().setUserID(course.getCourseID());
	/*	course.getUser().setPassword("Password");
		course.getUser().setAccessLevel("Course");
		adminCourse.createCoursedetail(course, course.getUser());*/
		adminCourse.updateCoursedetail(course);
		ModelAndView mav = new ModelAndView("redirect:/admin/manage/courses");
		return mav;
	
	}
	
	@RequestMapping(value = "courses/edit/{courseID}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable String courseID) {
		ModelAndView mav = new ModelAndView("FormCourseEdit");
		mav.addObject("course", adminCourse.findCoursedetail(courseID));
		return mav;
	}

	@RequestMapping(value = "courses/edit/{courseID}", method = RequestMethod.POST)
	public ModelAndView editCourse(@ModelAttribute @Valid Coursedetail course, BindingResult result, @PathVariable String courseID,
			 final RedirectAttributes redirectAttributes) {
		System.out.println("course"+course.toString());
		if (result.hasErrors())
			return new ModelAndView("FormCourseEdit");
		course.setCredits(adminCourse.findCoursedetailById(course.getCourseID()).getCredits());
		adminCourse.updateCoursedetail(course);
		ModelAndView mav = new ModelAndView("redirect:/admin/manage/courses");
		String message = "Course" + course.getCourseID() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}


//	// create new form
//	@RequestMapping(value = "/create", method = RequestMethod.GET)
//	public ModelAndView newCoursePage() {
//		ModelAndView mav = new ModelAndView("FormCourse", "course", new Course());
//		return mav;
//	}
//
//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public ModelAndView createNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
//			final RedirectAttributes redirectAttributes) {
//		if (result.hasErrors())
//			return new ModelAndView("FormCourse");
//		ModelAndView mav = new ModelAndView();
//
//		admincourse.createCourse(course);
//		// String message = "New course " + course.getCourseID() + " was successfully
//		// created.";
//		mav.setViewName("redirect:/lynn/home");
//		return mav;
//	}
//
//	// edit
//	@RequestMapping(value = "/edit/{cid}", method = RequestMethod.GET)
//	public ModelAndView editStudentPage(@PathVariable String cid) {
//		ModelAndView mav = new ModelAndView("FormCourse");
//		mav.addObject("course", admincourse.findCourse(cid));
//		return mav;
//	}
//
//	@RequestMapping(value = "/edit/{cid}", method = RequestMethod.POST)
//	public ModelAndView editStudent(@ModelAttribute @Valid Course student, @PathVariable String cid,
//			BindingResult result, final RedirectAttributes redirectAttributes) {
//		System.out.println("course" + course.toString());
//		if (result.hasErrors())
//			return new ModelAndView("FormCourse");
//		admincourse.updateCourse(course);
//		ModelAndView mav = new ModelAndView("redirect:/lynn/home");
//		String message = "Course" + student.getCourseID() + " was successfully updated.";
//		redirectAttributes.addFlashAttribute("message", message);
//		return mav;
//	}


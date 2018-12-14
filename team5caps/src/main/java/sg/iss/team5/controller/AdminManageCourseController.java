package sg.iss.team5.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
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

import sg.iss.team5.caps.SecurityConfigurations;
import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.service.AdminCourse;;

@Controller
@RequestMapping(value = "/admin")
public class AdminManageCourseController {

	@Autowired
	private AdminCourse adminCourse;

	@RequestMapping(value = { "/manage/courses" }, method = RequestMethod.GET)
	public ModelAndView showTesting(HttpSession session) {
		//Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		//Security
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
	public ModelAndView newCoursepage(HttpSession session) {
		//Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		//Security
		ModelAndView mav = new ModelAndView("FormCourse", "course", new Coursedetail());
		return mav;
	}

	@RequestMapping(value = "/courses/create", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@ModelAttribute @Valid Coursedetail course, BindingResult result, HttpSession session,
			final RedirectAttributes redirectAttributes) {
		//Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		//Security
		if (result.hasErrors())
			return new ModelAndView("FormCourse");

		adminCourse.updateCoursedetail(course);
		ModelAndView mav = new ModelAndView("redirect:/admin/manage/courses");
		return mav;

	}

	@RequestMapping(value = "courses/edit/{courseID}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable String courseID, HttpSession session) {
		//Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		//Security
		ModelAndView mav = new ModelAndView("FormCourseEdit");
		mav.addObject("course", adminCourse.findCoursedetail(courseID));
		return mav;
	}

	@RequestMapping(value = "courses/edit/{courseID}", method = RequestMethod.POST)
	public ModelAndView editCourse(@ModelAttribute @Valid Coursedetail course, BindingResult result,
			@PathVariable String courseID, HttpSession session, final RedirectAttributes redirectAttributes) {
		//Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		//Security
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
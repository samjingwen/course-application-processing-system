package sg.iss.team5.controller;

import java.util.ArrayList;

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

import sg.iss.team5.model.Course;
import sg.iss.team5.service.AdminCourse;



@Controller
public class AdminManageCourseController {
	
	@Autowired
	private AdminCourse admincourse;
	
	@RequestMapping(value = {"/lynn/course"}, method = RequestMethod.GET)
	public ModelAndView showTesting() {
		ArrayList<Course> courselist = new ArrayList<Course>();
		courselist = admincourse.findAllCourse();
		for (Course course:courselist) {
			System.out.println(course);
		}
		System.out.println("HAHAHAHAHAHAH");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("courselist");
		mv.addObject("cList", courselist);
		return mv;
	}
	
	
	//create new form
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("FormCourse", "course", new Course());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("FormCourse");
		ModelAndView mav = new ModelAndView();

		admincourse.createCourse(course);
		//String message = "New course " + course.getCourseID() + " was successfully created.";
		mav.setViewName("redirect:/lynn/home");
		return mav;
	}

	//edit
	@RequestMapping(value = "/edit/{cid}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String cid) {
		ModelAndView mav = new ModelAndView("FormCourse");
		mav.addObject("course",admincourse.findCourse(cid));
		return mav;
	}

	@RequestMapping(value = "/edit/{cid}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Course student, @PathVariable String cid,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		System.out.println("course"+course.toString());
		if (result.hasErrors())
			return new ModelAndView("FormCourse");
		admincourse.updateCourse(course);
		ModelAndView mav = new ModelAndView("redirect:/lynn/home");
		String message = "Course" + student.getCourseID() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}

	
	
	
	
	
	
	
	

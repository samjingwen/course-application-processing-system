package sg.iss.team5.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
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
import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.User;
import sg.iss.team5.service.AdminLecturer;

@Controller
@Transactional
@RequestMapping(value = "/admin")
public class AdminManageLecController {

	@Autowired
	private AdminLecturer adminlecturer;

	@RequestMapping(value = { "/manage/lecturer" }, method = RequestMethod.GET)
	public ModelAndView showTesting(HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		ArrayList<Lecturer> lecturerList = new ArrayList<Lecturer>();
		lecturerList = adminlecturer.findAllLecturers();
		for (Lecturer s : lecturerList) {
			System.out.println(s);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListLecture");
		mv.addObject("lList", lecturerList);
		return mv;
	}

	@RequestMapping(value = { "lecturer/create" }, method = RequestMethod.GET)
	public ModelAndView newCoursepage(HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		String lid = adminlecturer.findAllLecturers().get(adminlecturer.findAllLecturers().size() - 1).getLecturerID();
		int num = Integer.parseInt(lid.substring(1, 6));
		String id = "L" + String.format("%05d", num + 1);
		ModelAndView mav = new ModelAndView("FormLecturer", "lecturer", new Lecturer());
		mav.addObject("LID", id);
		return mav;
	}

	@RequestMapping(value = { "lecturer/create" }, method = RequestMethod.POST)
	public ModelAndView createNewLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			HttpSession session, final RedirectAttributes redirectAttributes) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		if (result.hasErrors())
			return new ModelAndView("FormLecturer");

		lecturer.getUser().setUserID(lecturer.getLecturerID());
		lecturer.getUser().setPassword("Password");
		lecturer.getUser().setAccessLevel("Lecturer");
		adminlecturer.createLecturer(lecturer, lecturer.getUser());
		ModelAndView mav = new ModelAndView("redirect:/admin/manage/lecturer");
		return mav;
	}

	@RequestMapping(value = "lecturer/edit/{lecturerID}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String lecturerID, HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		ModelAndView mav = new ModelAndView("FormLecturerEdit");
		mav.addObject("lecturer", adminlecturer.findLecturer(lecturerID));
		return mav;
	}

	@RequestMapping(value = "lecturer/edit/{lecturerID}", method = RequestMethod.POST)
	public ModelAndView editLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			@PathVariable String lecturerID, HttpSession session, final RedirectAttributes redirectAttributes) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		System.out.println("lecturer" + lecturer.toString());
		if (result.hasErrors())
			return new ModelAndView("FormLecturerEdit");
		User user = lecturer.getUser();
		user.setUserID(lecturer.getLecturerID());
		user.setAccessLevel(adminlecturer.findLecturer(lecturer.getLecturerID()).getUser().getAccessLevel());
		user.setPassword(adminlecturer.findLecturer(lecturer.getLecturerID()).getUser().getPassword());
		adminlecturer.createLecturer(lecturer, user);
		ModelAndView mav = new ModelAndView("redirect:/admin/manage/lecturer");
		String message = "Lecturer" + lecturer.getLecturerID() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.Calendar;

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
import sg.iss.team5.model.Student;
import sg.iss.team5.model.User;
import sg.iss.team5.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminManageStuController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = { "/manage/student" }, method = RequestMethod.GET)
	public ModelAndView displayStudents(HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		ArrayList<Student> myStudentList = new ArrayList<Student>();
		myStudentList = adminService.findAllStudents();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListStudent");
		mv.addObject("sList", myStudentList);
		return mv;
	}

	@RequestMapping(value = { "/student/create" }, method = RequestMethod.GET)
	public ModelAndView newCoursepage(HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		String sid = adminService.findAllStudents().get(adminService.findAllStudents().size() - 1).getStudentID();
		int num = Integer.parseInt(sid.substring(1, 6));
		String id = "S" + String.format("%05d", num + 1);
		ModelAndView mav = new ModelAndView("FormStudent", "student", new Student());
		mav.addObject("SID", id);
		return mav;
	}

	@RequestMapping(value = { "/student/create" }, method = RequestMethod.POST)
	public ModelAndView createNewLecturer(@ModelAttribute Student student, HttpSession session, BindingResult result) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		if (result.hasErrors())
			return new ModelAndView("FormStudent");
		student.setEnrollmentDate(Calendar.getInstance().getTime());
		student.getUser().setUserID(student.getStudentID());
		student.getUser().setPassword("Password");
		student.getUser().setAccessLevel("Student");
		adminService.createStudent(student, student.getUser());

		ModelAndView mav = new ModelAndView("redirect:/admin/manage/student");
		return mav;
	}

	@RequestMapping(value = "/student/edit/{studentID}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String studentID, HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		ModelAndView mav = new ModelAndView("FormStudentEdit");
		mav.addObject("student", adminService.findStudent(studentID));
		return mav;
	}

	@RequestMapping(value = "/student/edit/{studentID}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student, BindingResult result,
			@PathVariable String studentID, HttpSession session, final RedirectAttributes redirectAttributes) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		if (result.hasErrors())
			return new ModelAndView("FormStudentEdit");
		User user = student.getUser();
		user.setUserID(student.getStudentID());
		user.setAccessLevel(adminService.findStudentById(student.getStudentID()).getUser().getAccessLevel());
		user.setPassword(adminService.findStudentById(student.getStudentID()).getUser().getPassword());
		student.setEnrollmentDate(adminService.findStudentById(student.getStudentID()).getEnrollmentDate());
		adminService.createStudent(student, user);
		ModelAndView mav = new ModelAndView("redirect:/admin/manage/student");
		String message = "Student" + student.getStudentID() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
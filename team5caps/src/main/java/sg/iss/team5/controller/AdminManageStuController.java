package sg.iss.team5.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team5.model.Student;
import sg.iss.team5.model.User;
import sg.iss.team5.service.AdminService;

@Controller
public class AdminManageStuController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = { "/lynn/home" }, method = RequestMethod.GET)
	public ModelAndView showTesting() {
		ArrayList<Student> myStudentList = new ArrayList<Student>();
		myStudentList = adminService.findAllStudents();
		for (Student aStudent : myStudentList) {
			System.out.println(aStudent);
		}
		System.out.println("HAHAHAHAHAHAH");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studList");
		mv.addObject("sList", myStudentList);
		return mv;
	}

	// Create Student
	@RequestMapping(value = "/lynn/newstudent", method = RequestMethod.GET)
	public ModelAndView newStudentPage() {
		ModelAndView mav = new ModelAndView("newStudent", "newStudent", new Student());
		return mav;
	}

	@RequestMapping(value = "/lynn/newstudent", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute("student") @Valid Student student, @ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("newStudent");
		ModelAndView mav = new ModelAndView();
		adminService.createStudent(student, user);
		//String message = "New student " + student.getNric() + " was successfully created.";
		mav.setViewName("redirect:/lynn/home");
		return mav;
	}
//
//	//edit
//	@RequestMapping(value = "/edit/{sid}", method = RequestMethod.GET)
//	public ModelAndView editStudentPage(@PathVariable String sid) {
//		ModelAndView mav = new ModelAndView("StudentFormEdit");
//		mav.addObject("student",adminService.findStudent(sid));
//		return mav;
//	}
//
//	@RequestMapping(value = "/edit/{sid}", method = RequestMethod.POST)
//	public ModelAndView editStudent(@ModelAttribute @Valid Course student, @PathVariable String sid,
//			BindingResult result, final RedirectAttributes redirectAttributes) {
//		System.out.println("student"+student.toString());
//		if (result.hasErrors())
//			return new ModelAndView("StudentFormEdit");
//		adminService.updateStudent(student);
//		ModelAndView mav = new ModelAndView("redirect:/lynn/home");
//		String message = "Student" + student.getStudentID() + " was successfully updated.";
//		redirectAttributes.addFlashAttribute("message", message);
//		return mav;
//	}

//	@RequestMapping(value = "/student")
//	@Controller
//	public class StudentController {
//
//		@Autowired
//		StudentService sService;
//
//		@RequestMapping(value = "/list", method = RequestMethod.GET)
//		public ModelAndView listAll() {
//			ModelAndView mav = new ModelAndView("StudentCRUD");
//			ArrayList<Student> students = sService.findAllStudents();
//			mav.addObject("students", students);
//			return mav;
//		}
//
//		@RequestMapping(value = "/create", method = RequestMethod.GET)
//		public ModelAndView newStudentPage() {
//			ModelAndView mav = new ModelAndView("StudentFormNew", "student", new Student());
//			return mav;
//		}
//
//		@RequestMapping(value = "/create", method = RequestMethod.POST)
//		public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
//				final RedirectAttributes redirectAttributes) {
//			if (result.hasErrors())
//				return new ModelAndView("StudentFormNew");
//			ModelAndView mav = new ModelAndView();
//
//			sService.createStudent(student);
//			//String message = "New student " + student.getNric() + " was successfully created.";
//			mav.setViewName("redirect:/student/list");
//			return mav;
//		}
//
//		@RequestMapping(value = "/edit/{sid}", method = RequestMethod.GET)
//		public ModelAndView editStudentPage(@PathVariable String nric) {
//			ModelAndView mav = new ModelAndView("StudentFormEdit");
//			mav.addObject("student", sService.findStudent(nric));
//			return mav;
//		}
//
//		@RequestMapping(value = "/edit/{sid}", method = RequestMethod.POST)
//		public ModelAndView editStudent(@ModelAttribute @Valid Student student, @PathVariable String sid,
//				BindingResult result, final RedirectAttributes redirectAttributes) throws StudentNotFound {
//			System.out.println("student"+student.toString());
//			if (result.hasErrors())
//				return new ModelAndView("StudentFormEdit");
//			sService.updateStudent(student);
//			ModelAndView mav = new ModelAndView("redirect:/student/list");
//			String message = "Student" + student.getStudentID() + " was successfully updated.";
//			redirectAttributes.addFlashAttribute("message", message);
//			return mav;
//		}
//
//		@RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET)
//		public ModelAndView deleteStudent(@PathVariable String nric, final RedirectAttributes redirectAttributes)
//				throws StudentNotFound {
//			Student student = sService.findStudent(sid);
//			sService.removeStudent(student);
//			ModelAndView mav = new ModelAndView("redirect:/student/list");
//			String message = "The student " + student.getStudentID() + " was successfully deleted.";
//			redirectAttributes.addFlashAttribute("message", message);
//			return mav;
//		}
//
//	}

}

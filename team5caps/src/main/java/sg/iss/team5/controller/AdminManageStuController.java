package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
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

import antlr.StringUtils;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.User;
import sg.iss.team5.service.AdminService;

@Controller
@RequestMapping(value = "/student")
public class AdminManageStuController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = { "/studentlist" }, method = RequestMethod.GET)
	public ModelAndView showTesting() {
		ArrayList<Student> myStudentList = new ArrayList<Student>();
		myStudentList = adminService.findAllStudents();
		for (Student aStudent : myStudentList) {
			System.out.println(aStudent);
		}
		System.out.println("HAHAHAHAHAHAH");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListStudent");
		mv.addObject("sList", myStudentList);
		return mv;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public ModelAndView newCoursepage() {
		String sid = adminService.findAllStudents().get(adminService.findAllStudents().size()-1).getStudentID();
		int num = Integer.parseInt(sid.substring(1, 6));
		String id = "S"+String.format("%05d", num+1);
		ModelAndView mav = new ModelAndView("FormStudent", "student", new Student());
		mav.addObject("SID", id);
		return mav;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public ModelAndView createNewLecturer(@ModelAttribute Student student, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("FormStudent");
		//System.out.println(student.getStudentID());
		student.setEnrollmentDate(Calendar.getInstance().getTime());
		student.getUser().setUserID(student.getStudentID());
		student.getUser().setPassword("Password");
		student.getUser().setAccessLevel("Student");
		adminService.createStudent(student, student.getUser());

		ModelAndView mav = new ModelAndView("redirect:/student/studentlist");
		return mav;
	}

	@RequestMapping(value = "/edit/{studentID}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String studentID) {
		ModelAndView mav = new ModelAndView("FormStudentEdit");
		mav.addObject("student", adminService.findStudent(studentID));
		return mav;
	}

	@RequestMapping(value = "/edit/{studentID}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student,BindingResult result, @PathVariable String studentID,
			 final RedirectAttributes redirectAttributes) {
		System.out.println("student" + student.toString());
		if (result.hasErrors())
			return new ModelAndView("FormStudentEdit");
		User user = student.getUser();
		user.setUserID(student.getStudentID());
		user.setAccessLevel(adminService.findStudentById(student.getStudentID()).getUser().getAccessLevel());
		user.setPassword(adminService.findStudentById(student.getStudentID()).getUser().getPassword());
		student.setEnrollmentDate(adminService.findStudentById(student.getStudentID()).getEnrollmentDate());
		//System.out.println(student.get);
		adminService.createStudent(student, user);
		ModelAndView mav = new ModelAndView("redirect:/student/studentlist");
		String message = "Student" + student.getStudentID() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
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

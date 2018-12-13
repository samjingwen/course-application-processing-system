package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.Calendar;

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
import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.User;
import sg.iss.team5.service.AdminLecturer;

@Controller
@Transactional
@RequestMapping(value="/lecturer")
public class AdminManageLecController {

	@Autowired
	private AdminLecturer adminlecturer;

	@RequestMapping(value = { "/lecturelist" }, method = RequestMethod.GET)
	public ModelAndView showTesting() {
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
	
	@RequestMapping(value = { "/create"}, method = RequestMethod.GET)
	public ModelAndView newCoursepage() {
		ModelAndView mav = new ModelAndView("FormLecturer", "lecturer", new Lecturer());
		return mav;
	}
	@RequestMapping(value = { "/create"}, method = RequestMethod.POST)
	public ModelAndView createNewLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("FormLecturer");
		
		
		lecturer.getUser().setUserID(lecturer.getLecturerID());
		lecturer.getUser().setPassword("Password");
		lecturer.getUser().setAccessLevel("Lecturer");
		adminlecturer.createLecturer(lecturer, lecturer.getUser());
		ModelAndView mav = new ModelAndView("redirect:/lecturer/lecturelist");
		return mav;
	}
	
	
	@RequestMapping(value = "/edit/{lecturerID}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String lecturerID) {
		ModelAndView mav = new ModelAndView("FormLecturerEdit");
		mav.addObject("lecturer", adminlecturer.findLecturer(lecturerID));
		return mav;
	}

	@RequestMapping(value = "/edit/{lecturerID}", method = RequestMethod.POST)
	public ModelAndView editLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,  @PathVariable String lecturerID, 
			final RedirectAttributes redirectAttributes) {
		System.out.println("lecturer"+lecturer.toString());
		if (result.hasErrors())
			return new ModelAndView("FormLecturerEdit");
		lecturer.getUser().setUserID(lecturer.getLecturerID());
		adminlecturer.updateLecturer(lecturer);
		ModelAndView mav = new ModelAndView("redirect:/lecturer/lecturelist");
		String message = "Lecturer" + lecturer.getLecturerID() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}


	//create lecturer
//	@RequestMapping(value = "/lynn/lectnew", method = RequestMethod.GET)
//	public ModelAndView createLecturer() {
//		
//	}
	
	
	
	/*@RequestMapping(value = "/leccreate", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("FormStudent");
		ModelAndView mav = new ModelAndView();

		adminlecturer.createLecturer(lecturer);
		String message = "New Lecturer " + lecturer.getLecturerID() + " was successfully created.";
		mav.setViewName("redirect:/lynn/home");
		return mav;
	}

	// edit
	@RequestMapping(value = "/edit/{lid}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String lid) {
		ModelAndView mav = new ModelAndView("FormLecture");
		mav.addObject("lecturer", adminlecturer.findLecturer(lid));
		return mav;
	}

	@RequestMapping(value = "/edit/{lid}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Lecturer lecturer, @PathVariable String lid,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		System.out.println("lecturer" + lecturer.toString());
		if (result.hasErrors())
			return new ModelAndView("FormLecture");
		adminlecturer.updateLecturer(lecturer);
		ModelAndView mav = new ModelAndView("redirect:/lynn/home");
		String message = "Lecturer" + lecturer.getLecturerID() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
*/
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


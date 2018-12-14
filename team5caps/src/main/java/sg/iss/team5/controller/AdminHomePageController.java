package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.caps.SecurityConfigurations;
import sg.iss.team5.model.CanvasjsChartData;
import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.service.AdminService;

@Controller
@Transactional
@RequestMapping(value = "/admin")
public class AdminHomePageController {
	@Autowired
	AdminService adminService;
	CanvasjsChartData canvasjsChartData = new CanvasjsChartData();

	Logger logger = LoggerFactory.getLogger(AdminHomePageController.class);

	@RequestMapping(value = "/homepage")
	public ModelAndView listStudentsNotEnrolled(HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		// get top 7 courses
//		ArrayList<ChartData> chartDataList=adminService.findChartData();
//		int sum=0;
//		for (ChartData chartData : chartDataList) {
//			sum+=chartData.getY();
//		}

//		//get the average and put into string and int list
//		String name =chartDataList.get(1).getLabel();
//		for (int i=0;i<chartDataList.size();i++) {
//			chartDataList.get(i).setY((int)(chartDataList.get(i).getY()/sum*100));
//		}

		ArrayList<Student> studentNotEnrolledList = adminService.findNotEnrolled();
		ModelAndView mav = new ModelAndView("admin_homepage");
		List<List<Map<Object,Object>>> canvasjsDataList = canvasjsChartData.getCanvasjsDataList();
		mav.addObject("dataPointsList", canvasjsDataList);
		mav.addObject("listNotEnrolled", studentNotEnrolledList);
//		mav.addObject("dataPoints", chartDataList);
		return mav;
	}

	@RequestMapping(value = "/manage/courses")
	public ModelAndView listAllCourses(HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		ModelAndView mav = new ModelAndView("admin_courselist");
		ArrayList<Coursedetail> listAllCourse = adminService.getCourseDetailList();
		mav.addObject("listAllCourse", listAllCourse);

		// get quantity of students enrolled
		ArrayList<Integer> capacity = new ArrayList<>();
		for (Coursedetail current : listAllCourse) {
			capacity.add(adminService.getEnrolledCapacity(current.getCourseID()));
		}
		mav.addObject("enrolledCapacity", capacity);
		return mav;
	}

	@RequestMapping(value = "/manage/approval")
	public ModelAndView approveStudent(HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		ArrayList<Studentcourse> sclist = adminService.findByEnrollStatus("Pending");
		ModelAndView mav = new ModelAndView("admin_approve");
		mav.addObject("studentcourse", sclist);
		return mav;
	}

	@RequestMapping(value = "/manage/approval/{mid}/{sid}", method = RequestMethod.POST)
	public String changeStudentStatus(@PathVariable String mid, @PathVariable String sid, @RequestParam String act,
			HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return "redirect:/home/login";
		// Security

		Studentcourse sc = adminService.findByModuleIDCourseID(mid, sid);
		if (act.equals("Approve")) {
			sc.setEnrollStatus("Enrolled");
		} else if (act.equals("Reject")) {
			sc.setEnrollStatus("Reject");
		}
		System.out.println(act);
		System.out.println(sc);
		adminService.save(sc);

		return "admin_successful";
	}

	@RequestMapping(value = "/manage/courses/{cid}")
	public ModelAndView listStudentsInCourse(@PathVariable String cid, HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security

		ArrayList<Studentcourse> sclist = adminService.findCourseByCourseId(cid);
		ModelAndView mav = new ModelAndView("admin_coursedetails");
		mav.addObject("studentcourse", sclist);
		return mav;
	}

	@RequestMapping(value = "/manage/courses/{mid}/{sid}", method = RequestMethod.GET)
	public ModelAndView dropStudent(@PathVariable String mid, @PathVariable String sid, HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return new ModelAndView("redirect:/home/login");
		// Security
		Student student = adminService.findStudentById(sid);
		Module module = adminService.findByModuleID(mid);
		ModelAndView mav = new ModelAndView("admin_dropstudent");
		mav.addObject("student", student);
		mav.addObject("module", module);
		return mav;
	}

	@RequestMapping(value = "/manage/courses/{mid}/{sid}", method = RequestMethod.POST)
	public String dropStudentConfirm(@PathVariable String mid, @PathVariable String sid, HttpSession session) {
		// Security
		if (!SecurityConfigurations.CheckAdminAuth(session))
			return "redirect:/home/login";
		// Security
		Studentcourse sc = adminService.findByModuleIDCourseID(mid, sid);
		adminService.removeStudentCourse(sc);
		return "admin_successful";
	}
}

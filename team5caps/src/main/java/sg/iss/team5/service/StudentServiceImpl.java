package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.repository.CoursedetailRepository;
import sg.iss.team5.repository.ModuleRepository;
import sg.iss.team5.repository.StudentcourseRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentcourseRepository studentcourseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	CoursedetailRepository coursedetailRepository;

	public ArrayList<Studentcourse> findCourseByStudentId(String sid) {
		return (ArrayList<Studentcourse>) studentcourseRepository.findCourseByStudentId(sid);
	}

	public int saveStudentCourse(Studentcourse sc) {
		studentcourseRepository.save(sc);
		return 1;
	}

	public ArrayList<Module> findAllModule() {
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findAll();
		return mlist;
	}

	public ArrayList<Module> findModuleByStudentId(String sid) {
		ArrayList<Module> slist = (ArrayList<Module>) moduleRepository.findModuleByStudentId(sid);
		return slist;

	}

	public ArrayList<Module> findModuleByAcademicYear(Date d) {
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findModuleByAcademicYear(d);
		return mlist;

	}

	public ArrayList<Module> findModuleByLecturerId(String lid) {
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findModuleByLecturerId(lid);
		return mlist;

	}

	public ArrayList<Module> findModuleNotEnrolled(String sid, Date year) {
		year = Calendar.getInstance().getTime();
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findModuleNotEnrolled(sid, year);
		return mlist;
	}

	@Override
	public ArrayList<Coursedetail> findAllCoursedetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getDay(ArrayList<Module> mods) {
		ArrayList<String> daylist = new ArrayList<String>();
		String day = "Monday";
		for (Module current : mods) {
			switch (current.getDayofWeek()) {
			case 1:
				day = "Monday";
				break;
			case 2:
				day = "Tuesday";
				break;
			case 3:
				day = "Wednesday";
				break;
			case 4:
				day = "Thursday";
				break;
			case 5:
				day = "Friday";
				break;
			default:
				break;
			}
			daylist.add(day);
		}

		return daylist;
	}

	public double getGpa(ArrayList<Studentcourse> courses) {
		double gpa = 0;
		for (Studentcourse course : courses) {
			switch (course.getGrade()) {
			case "A":
				gpa += 5.0;
				break;
			case "B":
				gpa += 4.0;
				break;
			case "C":
				gpa += 3.0;
				break;
			case "D":
				gpa += 2.0;
				break;
			case "E":
				gpa += 1.0;
				break;
			default:
				break;
			}
		}
		gpa /= courses.size();
		return gpa;
	}

}

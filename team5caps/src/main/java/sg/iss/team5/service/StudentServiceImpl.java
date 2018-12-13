package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.FormattedModule;
import sg.iss.team5.model.FormattedSC;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.StudentcoursePK;
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
		studentcourseRepository.saveAndFlush(sc);
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
		return coursedetailRepository.findAllCoursedetail();
	}

	public String getDay(Module mods) {
		String day = "Monday";
		switch (mods.getDayofWeek()) {
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

		return day;
	}

	public String getTime(Module mods) {
		String Time = "Morning";
		switch (mods.getTimeslot()) {
		case 1:
			Time = "Morning";
			break;
		case 2:
			Time = "Afternoon";
			break;
		case 3:
			Time = "Evening";
			break;
		default:
			break;
		}

		return Time;
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

	public int getYear(Module mods) {
		return mods.getAcademicYear().getYear() + 1900;
	}

	public ArrayList<FormattedModule> getFormat(ArrayList<Module> mods) {
		ArrayList<FormattedModule> fmlist = new ArrayList<FormattedModule>();
		for (Module current : mods) {
			fmlist.add(new FormattedModule(current, getDay(current), getTime(current), getYear(current)));
		}
		return fmlist;
	}

	public Coursedetail enrollStudent(Coursedetail cd) {
		return coursedetailRepository.saveAndFlush(cd);
	}

	public ArrayList<FormattedSC> getFormatSC(ArrayList<Studentcourse> sc) {
		ArrayList<FormattedSC> sclist = new ArrayList<FormattedSC>();
		for (Studentcourse current : sc) {
			sclist.add(new FormattedSC(current, getTime(current.getModule()), getYear(current.getModule()),
					getDay(current.getModule())));
		}
		return sclist;
	}

	@Override
	public ArrayList<Studentcourse> enrollCourse(ArrayList<Module> mod, Student stu) {

		ArrayList<Studentcourse> cdlist = new ArrayList<Studentcourse>();
		for (Module current : mod) {
			cdlist.add(new Studentcourse("Enrolled", Calendar.getInstance().getTime(), stu, current));
		}

		return cdlist;
	}

	public Module findModulebyID(String mid) {
		Module mod = moduleRepository.findByModuleID(mid);

		return mod;
	}
}

package sg.iss.team5.model;

import java.util.Date;
import java.util.List;


public class FormattedModule {
	String Day;
	String Time;
	String moduleID;

	Date academicYear;

	int dayofWeek;

	int timeslot;

	String venue;

	Coursedetail coursedetail;

	Lecturer lecturer;

	List<Studentcourse> studentcourses;

	public FormattedModule(Module mod, String day, String time) {

		this.moduleID = mod.getModuleID();
		this.academicYear = mod.getAcademicYear();
		this.dayofWeek = mod.getDayofWeek();
		this.timeslot = mod.getTimeslot();
		this.venue = mod.getVenue();
		this.coursedetail = mod.getCoursedetail();
		this.lecturer = mod.getLecturer();
		Day = day;
		Time = time;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getModuleID() {
		return moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}

	public Date getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Date academicYear) {
		this.academicYear = academicYear;
	}

	public int getDayofWeek() {
		return dayofWeek;
	}

	public void setDayofWeek(int dayofWeek) {
		this.dayofWeek = dayofWeek;
	}

	public int getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Coursedetail getCoursedetail() {
		return coursedetail;
	}

	public void setCoursedetail(Coursedetail coursedetail) {
		this.coursedetail = coursedetail;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public List<Studentcourse> getStudentcourses() {
		return studentcourses;
	}

	public void setStudentcourses(List<Studentcourse> studentcourses) {
		this.studentcourses = studentcourses;
	}

}

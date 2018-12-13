package sg.iss.team5.model;

import java.math.BigDecimal;
import java.util.Date;

public class FormattedSC extends Studentcourse {

	private Student student;
	private String moduleID;
	private String moduleName;
	private BigDecimal attendance;
	private String grade;
	private String time;
	private String venue;
	private int year;
	private String day;
	private Module module;

	public Student getStudent() {
		return student;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getModuleID() {
		return moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public BigDecimal getAttendance() {
		return attendance;
	}

	public void setAttendance(BigDecimal attendance) {
		this.attendance = attendance;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Module getMod() {
		return module;
	}

	public void setMod(Module mod) {
		this.module = mod;
	}

	public FormattedSC(Studentcourse sc, String time, int year, String day) {
		super();
		this.student = sc.getStudent();
		this.moduleID = sc.getModule().getModuleID();
		this.moduleName = sc.getModule().getCoursedetail().getCourseName();
		this.attendance = sc.getAttendance();
		this.grade = sc.getGrade();
		this.time = time;
		this.venue = sc.getModule().getVenue();
		this.year = year;
		this.day = day;
		this.module = sc.getModule();
	}

}

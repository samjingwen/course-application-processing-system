package sg.iss.team5.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the modules database table.
 * 
 */
@Entity
@Table(name="modules")
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String moduleID;

	@Temporal(TemporalType.DATE)
	private Date academicYear;

	private int dayofWeek;

	private int timeslot;

	private String venue;

	//bi-directional many-to-one association to Coursedetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CourseID")
	private Coursedetail coursedetail;

	//bi-directional many-to-one association to Lecturer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LecturerID")
	private Lecturer lecturer;

	//bi-directional many-to-one association to Studentcourse
	@OneToMany(mappedBy="module")
	private List<Studentcourse> studentcourses;

	public Module() {
	}

	public String getModuleID() {
		return this.moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}

	public Date getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(Date academicYear) {
		this.academicYear = academicYear;
	}

	public int getDayofWeek() {
		return this.dayofWeek;
	}

	public void setDayofWeek(int dayofWeek) {
		this.dayofWeek = dayofWeek;
	}

	public int getTimeslot() {
		return this.timeslot;
	}

	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}

	public String getVenue() {
		return this.venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Coursedetail getCoursedetail() {
		return this.coursedetail;
	}

	public void setCoursedetail(Coursedetail coursedetail) {
		this.coursedetail = coursedetail;
	}

	public Lecturer getLecturer() {
		return this.lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public List<Studentcourse> getStudentcourses() {
		return this.studentcourses;
	}

	public void setStudentcourses(List<Studentcourse> studentcourses) {
		this.studentcourses = studentcourses;
	}

	public Studentcourse addStudentcours(Studentcourse studentcours) {
		getStudentcourses().add(studentcours);
		studentcours.setModule(this);

		return studentcours;
	}

	public Studentcourse removeStudentcours(Studentcourse studentcours) {
		getStudentcourses().remove(studentcours);
		studentcours.setModule(null);

		return studentcours;
	}

}
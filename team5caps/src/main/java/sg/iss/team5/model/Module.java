package sg.iss.team5.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	@ManyToOne
	@JoinColumn(name="CourseID")
	private Coursedetail coursedetail;

	//bi-directional many-to-one association to Lecturer
	@ManyToOne
	@JoinColumn(name="LecturerID")
	private Lecturer lecturer;

	//bi-directional many-to-one association to Studentcourse
	@OneToMany(fetch = FetchType.EAGER, mappedBy="module")
	private List<Studentcourse> studentcourses;

	public Module() {
		super();
	}
	

	public Module(String moduleID, Date academicYear, int dayofWeek, int timeslot, String venue,
			Coursedetail coursedetail, Lecturer lecturer) {
		super();
		this.moduleID = moduleID;
		this.academicYear = academicYear;
		this.dayofWeek = dayofWeek;
		this.timeslot = timeslot;
		this.venue = venue;
		this.coursedetail = coursedetail;
		this.lecturer = lecturer;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academicYear == null) ? 0 : academicYear.hashCode());
		result = prime * result + dayofWeek;
		result = prime * result + timeslot;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (academicYear == null) {
			if (other.academicYear != null)
				return false;
		} else if (!academicYear.equals(other.academicYear))
			return false;
		if (dayofWeek != other.dayofWeek)
			return false;
		if (timeslot != other.timeslot)
			return false;
		return true;
	}




	
	
}
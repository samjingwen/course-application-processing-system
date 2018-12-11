package sg.iss.team5.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the studentcourse database table.
 * 
 */
@Entity
@NamedQuery(name="Studentcourse.findAll", query="SELECT s FROM Studentcourse s")
public class Studentcourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentcoursePK id;

	private BigDecimal attendance;

	private String enrollStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enrollTime;

	private String grade;

	private int lecturerRating;

	//bi-directional many-to-one association to Module
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ModuleID")
	private Module module;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="StudentID")
	private Student student;

	public Studentcourse() {
	}

	public StudentcoursePK getId() {
		return this.id;
	}

	public void setId(StudentcoursePK id) {
		this.id = id;
	}

	public BigDecimal getAttendance() {
		return this.attendance;
	}

	public void setAttendance(BigDecimal attendance) {
		this.attendance = attendance;
	}

	public String getEnrollStatus() {
		return this.enrollStatus;
	}

	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}

	public Date getEnrollTime() {
		return this.enrollTime;
	}

	public void setEnrollTime(Date enrollTime) {
		this.enrollTime = enrollTime;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getLecturerRating() {
		return this.lecturerRating;
	}

	public void setLecturerRating(int lecturerRating) {
		this.lecturerRating = lecturerRating;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
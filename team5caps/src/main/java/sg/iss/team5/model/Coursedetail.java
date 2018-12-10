package sg.iss.team5.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the coursedetails database table.
 * 
 */
@Entity
@Table(name="coursedetails")
@NamedQuery(name="Coursedetail.findAll", query="SELECT c FROM Coursedetail c")
public class Coursedetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String courseID;

	private String courseName;

	private BigDecimal credits;

	private String description;

	private int maxVacancy;

	private int minVacancy;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="coursedetail")
	private List<Module> modules;

	public Coursedetail() {
	}

	public String getCourseID() {
		return this.courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxVacancy() {
		return this.maxVacancy;
	}

	public void setMaxVacancy(int maxVacancy) {
		this.maxVacancy = maxVacancy;
	}

	public int getMinVacancy() {
		return this.minVacancy;
	}

	public void setMinVacancy(int minVacancy) {
		this.minVacancy = minVacancy;
	}

	public List<Module> getModules() {
		return this.modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Module addModule(Module module) {
		getModules().add(module);
		module.setCoursedetail(this);

		return module;
	}

	public Module removeModule(Module module) {
		getModules().remove(module);
		module.setCoursedetail(null);

		return module;
	}

}
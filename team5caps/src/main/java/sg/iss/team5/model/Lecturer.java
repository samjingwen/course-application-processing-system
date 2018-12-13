package sg.iss.team5.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lecturers database table.
 * 
 */
@Entity
@Table(name="lecturers")
@NamedQuery(name="Lecturer.findAll", query="SELECT l FROM Lecturer l")
public class Lecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String lecturerID;

	private String position;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="LecturerID")
	private User user;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="lecturer")
	private List<Module> modules;

	public Lecturer() {
	}

	public String getLecturerID() {
		return this.lecturerID;
	}

	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Module> getModules() {
		return this.modules;
	}

/*	public void setModules(List<Module> modules) {
		this.modules = modules;
	}*/

	public Module addModule(Module module) {
		getModules().add(module);
		module.setLecturer(this);

		return module;
	}

	public Module removeModule(Module module) {
		getModules().remove(module);
		module.setLecturer(null);

		return module;
	}

}
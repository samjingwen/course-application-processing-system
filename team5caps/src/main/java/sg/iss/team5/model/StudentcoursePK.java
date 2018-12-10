package sg.iss.team5.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the studentcourse database table.
 * 
 */
@Embeddable
public class StudentcoursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String moduleID;

	@Column(insertable=false, updatable=false)
	private String studentID;

	public StudentcoursePK() {
	}
	public String getModuleID() {
		return this.moduleID;
	}
	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}
	public String getStudentID() {
		return this.studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentcoursePK)) {
			return false;
		}
		StudentcoursePK castOther = (StudentcoursePK)other;
		return 
			this.moduleID.equals(castOther.moduleID)
			&& this.studentID.equals(castOther.studentID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moduleID.hashCode();
		hash = hash * prime + this.studentID.hashCode();
		
		return hash;
	}
}
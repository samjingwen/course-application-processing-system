package sg.iss.team5.model;

public class Request {
	private String studentID;
	private String studentName;
	private String moduleID;
	private String courseName;
	private String lecturerName;
	private String venue;
	
	public Request() {
		super();
	}
	
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getModuleID() {
		return moduleID;
	}
	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getLecturerName() {
		return lecturerName;
	}
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "Request [studentID=" + studentID + ", studentName=" + studentName + ", moduleID=" + moduleID
				+ ", courseName=" + courseName + ", lecturerName=" + lecturerName + ", venue=" + venue + "]";
	}
	
}

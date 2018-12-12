package sg.iss.team5.service;

import java.util.ArrayList;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.User;

public interface AdminService {

	ArrayList<Student> findNotEnrolled();

	ArrayList<Student> findAllStudents();

	Student findStudentById(String sid);

	Student createStudent(Student student, User user);

	Student updateStudent(Student student);

	ArrayList<Lecturer> findAllLecturers();

	Lecturer findLecturerById(String lid);

	Lecturer createLecturer(Lecturer lecturer);

	Lecturer updateLecturer(Lecturer lecturer);

	ArrayList<Coursedetail> findAllCoursedetails();

	Coursedetail findCoursedetailById(String cid);

	Coursedetail createCoursedetail(Coursedetail cd);

	Coursedetail updateCoursedetail(Coursedetail cd);

	Student findStudent(String nric);

	void removeStudent(Student s);

	ArrayList<Coursedetail> getCourseDetailList();

	Integer getEnrolledCapacity(String courseId);

	ArrayList<Studentcourse> findCourseByCourseId(String cid);

	Module findByModuleID(String mid);

	void removeModule(Module m);
	
	Studentcourse findByModuleIDCourseID(String mid,String sid);
	
	void removeStudentCourse(Studentcourse sc);
	
	User createUser(User u);
}

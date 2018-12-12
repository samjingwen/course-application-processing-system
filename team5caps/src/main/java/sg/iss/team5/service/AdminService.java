package sg.iss.team5.service;


import java.util.ArrayList;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
public interface AdminService {

	ArrayList<Student> findNotEnrolled();
	ArrayList<Student> findAllStudents();
		
		Student findStudentById(String sid);
		
		Student createStudent(Student student);

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


}

package sg.iss.team5.service;

import java.util.ArrayList;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;

import java.util.ArrayList;

import sg.iss.team5.model.Student;

public interface AdminService {

	ArrayList<Student> findNotEnrolled();

	ArrayList<Student> findAllStudents();

	Student findStudent(String nric);

	Student createStudent(Student s);

	Student updateStudent(Student s);

	void removeStudent(Student s);
	
	ArrayList<Coursedetail> getCourseDetailList();
	
	Integer getEnrolledCapacity(String courseId);
	
	ArrayList<Studentcourse> findCourseByCourseId(String cid);
}

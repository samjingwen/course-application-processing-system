package sg.iss.team5.service;

import java.util.ArrayList;

import sg.iss.team5.model.Student;

import java.util.ArrayList;

import sg.iss.team5.model.Student;

public interface AdminService {

	public ArrayList<Student> findNotEnrolled();

	ArrayList<Student> findAllStudents();

	Student findStudent(String nric);

	Student createStudent(Student s);

	Student updateStudent(Student s);

	void removeStudent(Student s);

}

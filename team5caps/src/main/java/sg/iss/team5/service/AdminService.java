package sg.iss.team5.service;

import java.util.ArrayList;

import sg.iss.team5.model.Student;

public interface AdminService {

	public ArrayList<Student> findNotEnrolled();
}

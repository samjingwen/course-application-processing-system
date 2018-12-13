package sg.iss.team5.service;

import java.util.ArrayList;

import javax.validation.Valid;

import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.User;


public interface AdminLecturer {
	ArrayList<Lecturer> findAllLecturers();

	Lecturer findLecturer(String lid);
	Lecturer updateLecturer(Lecturer l);
	
	ArrayList<Lecturer> findLecturersByCriteria(Lecturer lecturer);

	void removeLecturer(Lecturer l);

	Lecturer createLecturer(Lecturer l);

	Lecturer createLecturer(Lecturer student, User user);

	
}

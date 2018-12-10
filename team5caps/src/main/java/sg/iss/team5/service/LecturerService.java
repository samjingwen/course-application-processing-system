package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.databind.Module;

import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Studentcourse;

public interface LecturerService {
	
	ArrayList<Module> findModuleByLecturerId(String lid );
	
	int gradeCourse(Studentcourse sc);
	
	ArrayList<Module> findModuleByAcademicYear(Date year);

}

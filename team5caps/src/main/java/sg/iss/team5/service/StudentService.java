package sg.iss.team5.service;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.Module;

import sg.iss.team5.model.Studentcourse;

public interface StudentService {
	ArrayList<Studentcourse> findCourseByStudentId(String sid);
	
	int saveStudentCourse(Studentcourse sc);
	
	ArrayList<Module> findAllModule();
	
	ArrayList<Module> findModuleByStudentId(String sid);

}

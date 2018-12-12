package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;

public interface LecturerService {
	
	ArrayList<Module> findModuleByLecturerId(String lid );
	
	int gradeCourse(Studentcourse sc);
	
	ArrayList<Module> findAllModule();
	
	ArrayList<Module> findModuleByAcademicYear(Date i);
	
	Double findLecturerRatingByModuleId(String mid);
	
	String findAttendanceByModuleId(String mid);
	
	ArrayList<Studentcourse> findCourseByModuleId(String mid);
	
	ArrayList<Module> findModuleIdbyLectid(String lid);
	
	ArrayList<Module> findPastModuleByLectId(String lid);
	
	ArrayList<Studentcourse> findAllStudentcourse();

}


package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.FormattedModule;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;


public interface StudentService {
	ArrayList<Studentcourse> findCourseByStudentId(String sid);
	
	int saveStudentCourse(Studentcourse sc);
	
	ArrayList<Module> findAllModule();
	
	ArrayList<Module> findModuleByStudentId(String sid);
	
	ArrayList<Module> findModuleByAcademicYear(Date d);
	
	ArrayList<Module> findModuleNotEnrolled(String sid, Date d);
	
	ArrayList<Coursedetail> findAllCoursedetail();

	ArrayList<Module> findModuleByLecturerId(String lid);

	double getGpa(ArrayList<Studentcourse> courses);
	
	String getDay(Module mods);
	
	String getTime(Module mods);
	
	int getYear(Module mods);
	
	ArrayList<FormattedModule> getFormat(ArrayList<Module> mods);

	ArrayList<Studentcourse> enrollCourse(ArrayList<Module> mod, Student stu);
	
	Module findModulebyID(String mid);

}

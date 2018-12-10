package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.Module;

import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.repository.ModuleRepository;
import sg.iss.team5.repository.StudentcourseRepository;

@Service
@Transactional
public class LecturerServiceImpl implements LecturerService {

	@Resource
	private StudentcourseRepository studentcourseRepository;
	private ModuleRepository moduleRepository;
	
	public ArrayList<Module> findModuleByLecturerId(String lid) {
		// TODO Auto-generated method stub
		return moduleRepository.findModuleByLecturerId(lid);
	}
	
	public int gradeCourse(Studentcourse sc) {
		// TODO Auto-generated method stub
		studentcourseRepository.save(sc);
		return 1;
	}
		
	public ArrayList<Module> findModuleByAcademicYear(Date year) {
		// TODO Auto-generated method stub
		return moduleRepository.findModuleByAcademicYear(year);
	}
	
	
}

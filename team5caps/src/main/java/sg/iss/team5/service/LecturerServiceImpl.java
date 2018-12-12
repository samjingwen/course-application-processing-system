package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sg.iss.team5.model.Module;
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
		return moduleRepository.findModuleByLecturerId(lid);
	}
	
	public int gradeCourse(Studentcourse sc) {
		studentcourseRepository.save(sc);
		return 1;
	}
		
	public ArrayList<Module> findModuleByAcademicYear(Date year) {
		return moduleRepository.findModuleByAcademicYear(year);
	}

	@Override
	public ArrayList<Module> findAllModule() {
		return (ArrayList<Module>)moduleRepository.findAll();
	}
	
	
}

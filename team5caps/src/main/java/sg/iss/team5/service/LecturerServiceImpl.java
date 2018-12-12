package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.repository.ModuleRepository;
import sg.iss.team5.repository.StudentcourseRepository;

@Service
@Transactional
public class LecturerServiceImpl implements LecturerService {

	@Autowired
	private StudentcourseRepository studentcourseRepository;
	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public ArrayList<Module> findModuleByLecturerId(String lid) {
		// TODO Auto-generated method stub
		return moduleRepository.findModuleByLecturerId(lid);
	}

	@Override
	public int gradeCourse(Studentcourse sc) {
		// TODO Auto-generated method stub
		studentcourseRepository.save(sc);
		return 1;
	}

	@Override
	public ArrayList<Module> findModuleByAcademicYear(Date year) {
		// TODO Auto-generated method stub
		return moduleRepository.findModuleByAcademicYear(year);
	}

	@Override
	public ArrayList<Module> findAllModule() {
		// TODO Auto-generated method stub
		return (ArrayList<Module>) moduleRepository.findAll();
	}

	@Override
	public Double findLecturerRatingByModuleId(String mid) {
		return studentcourseRepository.findLecturerRatingByModuleId(mid);
	}

	@Override
	public String findAttendanceByModuleId(String mid) {
		// TODO Auto-generated method stub
		return studentcourseRepository.findAttendanceByModuleId(mid);
	}

	@Override
	public ArrayList<Studentcourse> findCourseByModuleId(String mid) {
		// TODO Auto-generated method stub
		return (ArrayList<Studentcourse>) studentcourseRepository.findByModule_ModuleIDContaining(mid);
	}

	@Override
	public ArrayList<Module> findModuleIdbyLectid(String lid) {
		// TODO Auto-generated method stub
		return (ArrayList<Module>) moduleRepository.findModuleByLecturerId(lid);
	}
	
	@Override
	public ArrayList<Studentcourse> findAllStudentcourse() {
		return studentcourseRepository.findAllStudentcourse();
	}

	@Override
	public Module findModuleByModuleID(String mid) {
		return moduleRepository.findByModuleID(mid);
	}

	@Override
	public Studentcourse createStudentcourse(Studentcourse studentcourse) {
		return studentcourseRepository.save(studentcourse);
	}
	
	
	
}

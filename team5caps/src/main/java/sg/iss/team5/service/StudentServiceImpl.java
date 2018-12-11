package sg.iss.team5.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.repository.ModuleRepository;
import sg.iss.team5.repository.StudentcourseRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentcourseRepository studentcourseRepository;
	@Autowired
	ModuleRepository moduleRepository;

	public ArrayList<Studentcourse> findCourseByStudentId(String sid) {
		return (ArrayList<Studentcourse>) studentcourseRepository.findCourseByStudentId(sid);
	}

	public int saveStudentCourse(Studentcourse sc) {
		studentcourseRepository.save(sc);
		return 1;
	}

	public ArrayList<Module> findAllModule() {
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findAll();
		return mlist;
	}

	public ArrayList<Module> findModuleByStudentId(String sid) {
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findModuleByStudentId(sid);
		return mlist;

	}

	public ArrayList<Module> findModuleByAcademicYear(Date d) {
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findModuleByAcademicYear(d);
		return mlist;

	}

	public ArrayList<Module> findModuleByLecturerId(String lid) {
		ArrayList<Module> mlist = (ArrayList<Module>) moduleRepository.findModuleByLecturerId(lid);
		return mlist;

	}

}

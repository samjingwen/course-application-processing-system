package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.Lecturer;
import sg.iss.team5.repository.LecturerRepository;
import sg.iss.team5.repository.UserRepository;


@Service
public class AdminLecturerImpl implements AdminLecturer {

	@Resource
	LecturerRepository LecturerRepository;
	@Resource
	UserRepository userRepository;

	@Override
	public ArrayList<Lecturer> findAllLecturers() {
		return LecturerRepository.findAllLecturers();
	}

	@Override
	@Transactional
	public Lecturer findLecturer(String lid) {
		Lecturer student = LecturerRepository.findLecturerById(lid);
		System.out.println(student.toString());
		return student;
	}

	@Override
	public Lecturer createLecturer(Lecturer l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lecturer updateLecturer(Lecturer l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLecturer(Lecturer l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Lecturer> findLecturersByCriteria(Lecturer lecturer) {
		// TODO Auto-generated method stub
		return null;
	}
}
package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.Lecturer;

import sg.iss.team5.model.User;
import sg.iss.team5.repository.LecturerRepository;
import sg.iss.team5.repository.UserRepository;



@Service
public class AdminLecturerImpl implements AdminLecturer {

	@Autowired
	LecturerRepository LecturerRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public ArrayList<Lecturer> findAllLecturers() {
		return LecturerRepository.findAllLecturers();
	}

	@Override
	@Transactional
	public Lecturer findLecturer(String lid) {
		Lecturer lecturer = LecturerRepository.findLecturerById(lid);
		//System.out.println(student.toString());
		return lecturer;
	}

	@Transactional
	public Lecturer createLecturer(Lecturer lecturer, User user) {
		userRepository.saveAndFlush(user);
		return LecturerRepository.saveAndFlush(lecturer);
	}
	@Override
	public Lecturer updateLecturer(Lecturer l) {
		// TODO Auto-generated method stub
	
		return LecturerRepository.save(l);
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

	@Override
	public Lecturer createLecturer(Lecturer l) {
		// TODO Auto-generated method stub
		return null;
	}
}
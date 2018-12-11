package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.Student;
import sg.iss.team5.repository.StudentRepository;
import sg.iss.team5.repository.UserRepository;


import sg.iss.team5.model.Student;
import sg.iss.team5.repository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	StudentRepository studentRepository;

	public ArrayList<Student> findNotEnrolled(){
		return studentRepository.findNotEnrolled();
	}
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ArrayList<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	@Override
	@Transactional
	public Student findStudent(String sid) {
		Student student = studentRepository.findStudentById(sid);
		System.out.println(student.toString());
		return student;
	}

}
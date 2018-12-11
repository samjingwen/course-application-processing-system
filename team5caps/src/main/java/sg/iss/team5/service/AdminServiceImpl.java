package sg.iss.team5.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.team5.model.Student;
import sg.iss.team5.repository.StudentRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	StudentRepository studentRepository;

	public ArrayList<Student> findNotEnrolled(){
		return studentRepository.findNotEnrolled();
	}
}

package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.Student;
import sg.iss.team5.repository.StudentRepository;
import sg.iss.team5.repository.UserRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	StudentRepository studentRepository;
	@Resource
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

	@Override
	public Student createStudent(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStudent(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Student> findStudentsByCriteria(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
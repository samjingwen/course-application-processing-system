package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.repository.CoursedetailRepository;
import sg.iss.team5.repository.LecturerRepository;
import sg.iss.team5.repository.StudentRepository;
import sg.iss.team5.repository.StudentcourseRepository;
import sg.iss.team5.repository.UserRepository;

import sg.iss.team5.model.Student;
import sg.iss.team5.repository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CoursedetailRepository coursedetailRepository;
	@Autowired
	LecturerRepository lecturerRepository;
	@Autowired
	StudentcourseRepository studentcourseRepository;

	// Student
	@Override
	public ArrayList<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}
	
	public ArrayList<Student> findNotEnrolled() {
		return studentRepository.findNotEnrolled();
	}

	public ArrayList<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	public Student findStudent(String sid) {
		Student student = studentRepository.findStudentById(sid);
		System.out.println(student.toString());
		return student;
	}

	@Transactional
	public Student createStudent(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Transactional
	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Transactional
	public void removeStudent(Student student) {
		studentRepository.delete(student);
	}

	public ArrayList<Coursedetail> getCourseDetailList() {
		return coursedetailRepository.findAllCoursedetail();
	}

	public Integer getEnrolledCapacity(String courseId) {
		return coursedetailRepository.getCurrentEnrolledCapacity(courseId);
	}

	public ArrayList<Studentcourse> findCourseByCourseId(String cid) {
		System.out.println(cid);
		return studentcourseRepository.findByModule_ModuleIDContaining(cid);
//		return studentcourseRepository.findCourseByCourseId(cid);
	}
}
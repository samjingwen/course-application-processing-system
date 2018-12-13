package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import sg.iss.team5.model.ChartData;
import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.User;
import sg.iss.team5.repository.CoursedetailRepository;
import sg.iss.team5.repository.LecturerRepository;
import sg.iss.team5.repository.ModuleRepository;
import sg.iss.team5.repository.StudentRepository;
import sg.iss.team5.repository.StudentcourseRepository;
import sg.iss.team5.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	LecturerRepository lecturerRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CoursedetailRepository coursedetailRepository;
	@Autowired
	StudentcourseRepository studentcourseRepository;
	@Autowired
	ModuleRepository moduleRepository;

	// Student
	@Override
	public ArrayList<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	public ArrayList<Student> findNotEnrolled() {
		return studentRepository.findNotEnrolled();
	}

	@Override
	public Student findStudentById(String sid) {
		Student student = studentRepository.findByStudentID(sid);
		return student;
	}

	@Override
	@Transactional
	public Student createStudent(Student student, User user) {
		userRepository.saveAndFlush(user);
		return studentRepository.saveAndFlush(student);
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public ArrayList<Lecturer> findAllLecturers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lecturer findLecturerById(String lid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lecturer createLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lecturer updateLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Coursedetail> findAllCoursedetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coursedetail findCoursedetailById(String cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coursedetail createCoursedetail(Coursedetail cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coursedetail updateCoursedetail(Coursedetail cd) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Coursedetail> getCourseDetailList() {
		return new ArrayList<Coursedetail>(coursedetailRepository.findAll());
	}

	public Integer getEnrolledCapacity(String courseId) {
		return coursedetailRepository.getCurrentEnrolledCapacity(courseId);
	}

	public ArrayList<Studentcourse> findCourseByCourseId(String cid) {
		System.out.println(cid);
		return studentcourseRepository.findCourseByCourseId(cid);
	}

	@Override
	public Student findStudent(String nric) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStudent(Student s) {
		studentRepository.delete(s);
	}

	public Module findByModuleID(String mid) {
		return moduleRepository.findByModuleID(mid);
	}

	public void removeModule(Module m) {
		moduleRepository.delete(m);
	}

	public Studentcourse findByModuleIDCourseID(String mid, String sid) {
		return studentcourseRepository.findFirstByModule_ModuleIDAndStudent_StudentID(mid, sid);
	}

	public void removeStudentCourse(Studentcourse sc) {
		studentcourseRepository.delete(sc);
	}

	@Override
	public User createUser(User u) {
		return userRepository.save(u);
	}
	
	public int countByCourseID(String cid) {
		return countByCourseID(cid);
	}
	
	public ArrayList<Studentcourse> findAllStudentcourse() {
		return (ArrayList<Studentcourse>) studentcourseRepository.findAll();
	}
	
	public ArrayList<Studentcourse> findByEnrollStatus(String status){
		return studentcourseRepository.findByEnrollStatus(status);
	}
	
	public void save(Studentcourse sc) {
		studentcourseRepository.save(sc);
	}
	
	public ArrayList<ChartData> findChartData(){
		return coursedetailRepository.findChartData();
	}
}
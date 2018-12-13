package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.User;
import sg.iss.team5.repository.CoursedetailRepository;

import sg.iss.team5.repository.UserRepository;


@Service
public class AdminCourseImpl implements AdminCourse {

	@Resource
	CoursedetailRepository coursedetailRepository;
	@Resource
	UserRepository userRepository;
	@Override
	public ArrayList<Coursedetail> findAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Coursedetail> findAllCoursedetails() {
		return coursedetailRepository.findAllCoursedetail();
	}
	
	@Override
	@Transactional
	public Coursedetail createCoursedetail(Coursedetail cd, User user) {
		userRepository.saveAndFlush(user);
		return coursedetailRepository.saveAndFlush(cd);
	}
	
	
	@Override
	public Coursedetail findCoursedetailById(String cid) {
		Coursedetail course = coursedetailRepository.findCoursesById(cid);
		//System.out.println(student.toString());
		return course;// TODO Auto-generated method stub
		
	}
	/*public Coursedetail createCoursedetail(Coursedetail cd) {
		// TODO Auto-generated method stub
		return null;*/
	
	@Override
	public Coursedetail updateCoursedetail(Coursedetail cd) {
		// TODO Auto-generated method stub
	/*coursedetailRepository.saveAndFlush(cd);*/
		return coursedetailRepository.save(cd);
	}
	@Override
	public ArrayList<Coursedetail> getCourseDetailList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getEnrolledCapacity(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Coursedetail findCoursedetail(String courseID) {
		// TODO Auto-generated method stub
		return coursedetailRepository.findCoursesById(courseID);
	}

	
	}

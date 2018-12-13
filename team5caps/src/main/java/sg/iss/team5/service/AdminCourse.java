package sg.iss.team5.service;

import java.util.ArrayList;

import javax.validation.Valid;

import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.User;

public interface AdminCourse {

	ArrayList<Coursedetail> findAllCourses();

	ArrayList<Coursedetail> findAllCoursedetails();

	Coursedetail findCoursedetailById(String cid);

	Coursedetail createCoursedetail(Coursedetail cd, User user);

	Coursedetail updateCoursedetail(Coursedetail cd);

	ArrayList<Coursedetail> getCourseDetailList();

	Integer getEnrolledCapacity(String courseId);

	Object findCoursedetail(String courseID);



}

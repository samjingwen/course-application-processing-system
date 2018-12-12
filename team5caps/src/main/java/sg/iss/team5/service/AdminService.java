package sg.iss.team5.service;


import java.util.ArrayList;


import sg.iss.team5.model.Course;
public interface AdminService {

		ArrayList<Course> findAllStudents();

		Course findStudent(String nric);

		Course createStudent(Course s);

		Course updateStudent(Course s);

		void removeStudent(Course s);

		ArrayList<Course> findStudentsByCriteria(Course student);


}

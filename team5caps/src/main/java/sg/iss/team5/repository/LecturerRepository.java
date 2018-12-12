package sg.iss.team5.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Lecturer;
import sg.iss.team5.model.Course;


public interface LecturerRepository extends JpaRepository<Lecturer, String>{

	Lecturer findLecturerById(String lid);
	@Query(value = "select * from lecturers", nativeQuery = true)
	ArrayList<Lecturer> findAllLecturers();
	


}

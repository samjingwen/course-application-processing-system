package sg.iss.team5.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.iss.team5.model.Lecturer;


public interface LecturerRepository extends JpaRepository<Lecturer, String>{

	@Query(value = "select * from lecturers l where l.lecturerid =: 'lid'", nativeQuery = true)
	Lecturer findLecturerById(String lid);
	
	@Query(value = "select * from lecturers", nativeQuery = true)
	ArrayList<Lecturer> findAllLecturers();
	


}

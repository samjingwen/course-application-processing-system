package sg.iss.team5.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.iss.team5.model.Coursedetail;

public interface CoursedetailRepository extends JpaRepository<Coursedetail, String> {

	@Query(value = "select * from Coursedetails c", nativeQuery = true)
	ArrayList<Coursedetail> findAllCoursedetail();
}

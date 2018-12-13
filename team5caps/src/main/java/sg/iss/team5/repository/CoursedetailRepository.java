package sg.iss.team5.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.ChartData;
import sg.iss.team5.model.Coursedetail;

public interface CoursedetailRepository extends JpaRepository<Coursedetail, String> {

//	@Query(value = "select * from Coursedetails c", nativeQuery = true)
//	ArrayList<Coursedetail> findAllCoursedetail();
	
	//select sc.moduleid,count (sc.studentid) from studentcourse sc group by sc.moduleid where sc.moduleid like '%A0006' and year(sc.enrolltime)=YEAR(CURDATE())
	@Query(value= "select count(*) from studentcourse sc where sc.moduleid like '%:courseid' and year (sc.enrolltime) = YEAR(CURDATE())",nativeQuery=true)
	Integer getCurrentEnrolledCapacity(@Param("courseid") String courseId);
	
	@Query(value="select cs.coursename, count(*) from coursedetails cs\r\n" + 
			"inner join modules m on cs.courseid=m.courseid\r\n" + 
			"inner join studentcourse sc on m.moduleid=sc.moduleid\r\n" + 
			"group by cs.coursename\r\n" + 
			"order by count(*) desc\r\n" + 
			"")
	ArrayList<ChartData> findChartData();
	
		@Query(value="select * from coursedetail where coursedetailid = :cid", nativeQuery = true)
	Coursedetail findCoursesById(@Param("cid") String cid);
}

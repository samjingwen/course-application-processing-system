package sg.iss.team5.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.StudentcoursePK;

public interface StudentcourseRepository extends JpaRepository<Studentcourse, StudentcoursePK> {
	@Query(value="select * from studentcourse s where s.studentid = ':sid'", nativeQuery = true)
	ArrayList<Studentcourse> findCourseByStudentId(@Param("sid") String sid);

	@Query(value="select * from studentcourse sc where sc.moduleid like '%:cid'", nativeQuery = true)
	ArrayList<Studentcourse> findCourseByCourseId(@Param("cid") String cid);
}

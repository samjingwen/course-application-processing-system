package sg.iss.team5.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.StudentcoursePK;

public interface StudentcourseRepository extends JpaRepository<Studentcourse, StudentcoursePK> {

	@Query(value="select * from studentcourse s where s.studentid = :sid", nativeQuery = true)
	ArrayList<Studentcourse> findCourseByStudentId(@Param("sid") String sid);

	@Query(value="select * from studentcourse sc where sc.moduleid like %:cid", nativeQuery = true)
	ArrayList<Studentcourse> findCourseByCourseId(@Param("cid") String cid);
	
	@Query(value = "select ROUND(avg(lecturerrating),2) FROM studentcourse ,modules m where m.moduleid in (select distinct moduleid from modules \r\n" + 
			"where moduleid =:mid and academicyear < year(curdate()))", nativeQuery = true)
	Double findLecturerRatingByModuleId(@Param("mid") String mid);

	@Query(value = "select concat(ROUND((avg(attendance)*100),2),' %')FROM studentcourse, modules m where m.moduleid in (select distinct moduleid from modules \r\n"
			+ "where moduleid =:mid and academicyear < year(curdate()))", nativeQuery = true)
	String findAttendanceByModuleId(@Param("mid") String mid);
	
	ArrayList<Studentcourse> findByModule_ModuleIDContaining(String cid);
	
	@Query(value="select * from studentcourse", nativeQuery=true)
	ArrayList<Studentcourse> findAllStudentcourse();

	
}

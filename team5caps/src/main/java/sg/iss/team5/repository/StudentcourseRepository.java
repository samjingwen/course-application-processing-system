package sg.iss.team5.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Module;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.StudentcoursePK;

public interface StudentcourseRepository extends JpaRepository<Studentcourse, StudentcoursePK> {
	@Query(value = "select * from studentcourse s where s.studentid = :sid", nativeQuery = true)
	ArrayList<Studentcourse> findCourseByStudentId(@Param("sid") String sid);

	@Query(value = "select * from studentcourse sc where sc.moduleid like %:cid", nativeQuery = true)
	ArrayList<Studentcourse> findCourseByCourseId(@Param("cid") String cid);

	// updated the query for rating
	@Query(value = "select ROUND(avg(lecturerrating),2) from studentcourse join modules on studentcourse.moduleid = modules.moduleid where studentcourse.moduleid=:mid", nativeQuery = true)
	Double findLecturerRatingByModuleId(@Param("mid") String mid);

	@Query(value = "select * from studentcourse s where s.moduleid = :mid", nativeQuery = true)
	ArrayList<Studentcourse> findCourseByModuleId(@Param("mid") String mid);

	// updated the query for attendance
	@Query(value = "select concat(ROUND((avg(attendance)*100),2),' %') from studentcourse join modules on studentcourse.moduleid = modules.moduleid where studentcourse.moduleid=:mid", nativeQuery = true)
	String findAttendanceByModuleId(@Param("mid") String mid);

	ArrayList<Studentcourse> findByModule_ModuleIDContaining(String cid);

	@Query(value = "select * from studentcourse", nativeQuery = true)
	ArrayList<Studentcourse> findAllStudentcourse();

	@Query(value = "select * from studentcourse sc where sc.moduleid in(select moduleid from modules where lecturerid= :lid", nativeQuery = true)
	ArrayList<Studentcourse> findModulesByLecturerId(@Param("lid") String lid);

	Studentcourse findFirstByModule_ModuleIDAndStudent_StudentID(String mid, String sid);

	@Query(value = "select * from studentcourse sc where sc.moduleid = :mid and sc.studentid = :sid", nativeQuery = true)
	Studentcourse findStudentcourseByPK(@Param("mid") String mid, @Param("sid") String sid);
	
	// ArrayList<Studentcourse> findByModule_ModuleIDContaining(String cid);

	// EC 13 Dec
	@Query(value = "select * from javateam5.studentcourse sc where sc.studentid = :sid and sc.moduleid in (select moduleid from modules where academicyear = year(curdate())) ", nativeQuery = true)
	ArrayList<Studentcourse> findModbyStuandYear(@Param("sid") String sid);
	
	
}

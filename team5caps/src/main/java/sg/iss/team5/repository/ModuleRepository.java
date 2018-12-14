package sg.iss.team5.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Module;

public interface ModuleRepository extends JpaRepository<Module, String> {

	@Query(value = "select * from modules m where m.moduleid in (select moduleid from studentcourse s where s.studentid = :sid)", nativeQuery = true)
	ArrayList<Module> findModuleByStudentId(@Param("sid") String sid);
	
	@Query(value = "select * from modules m where m.lecturerid = :lid", nativeQuery = true)
	ArrayList<Module> findModuleByLecturerId(@Param("lid") String lid);
	
	@Query(value="select * from modules m where m.academicYear = :year", nativeQuery = true)
	ArrayList<Module> findModuleByAcademicYear(@Param("year") Date year);
	
	@Query(value = "select * from modules m where m.courseid not in (select distinct courseid from modules m "
			+ "where m.moduleid in (select distinct moduleid from studentcourse where studentid = :sid and (grade != 'F' or grade is null))) "
			+ "and m.academicyear = :year", nativeQuery = true)
	ArrayList<Module> findModuleNotEnrolled(@Param("sid") String sid, @Param("year") Date year);
	
	@Query(value ="select moduleid from modules where lecturerid = :lid", nativeQuery=true)
	ArrayList<Module> findModuleIdbyLectid(@Param("lid") String lid);

	//@Query(value = "select * from modules m where m.courseid not in (select distinct courseid from modules m where m.moduleid in (select distinct moduleid from studentcourse where studentid = :sid and grade != 'F')) and m.academicyear = :year", nativeQuery = true)
	//ArrayList<Module> findModuleNotEnrolled(@Param("sid") String sid, @Param("year") Date year);
	
	//added by Zan 12-Dec
	@Query(value="select * from modules m where m.academicYear< year(curdate()) and m.lecturerid = :lid", nativeQuery = true)
	ArrayList<Module> findPastModuleByLectId(@Param("lid") String lid);
	
	Module findByModuleID(String mid);
	
	long countByCoursedetail_CourseID(String cid);
	
	@Query(value = "select moduleid from modules", nativeQuery = true)
	ArrayList<String> getAllModuleID();
	
	// added by Zan 13-Dec
	@Query(value = "select * from modules m where m.academicYear= year(curdate()) and m.lecturerid = :lid", nativeQuery = true)
	ArrayList<Module> findCurentModuleByLectId(@Param("lid") String lid);

	@Query(value = "select * from modules m where m.moduleid = :mid", nativeQuery = true)
	Module findModuleById(@Param("mid") String mid);
	
	//ChartData
	@Query(value = "SELECT distinct courseid FROM modules",nativeQuery=true)
	ArrayList<String> findAvailableModuleID();
}

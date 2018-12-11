package sg.iss.team5.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Module;


public interface ModuleRepository extends JpaRepository<Module, String> {

	@Query(value = "select * from modules m where m.moduleid in(select s.moduleid from studentcourse s where s.studentid = :sid)", nativeQuery = true)
	ArrayList<Module> findModuleByStudentId(@Param("sid") String sid);
	
	@Query(value = "select * from modules m where m.lecturerid = :lid", nativeQuery = true)
	ArrayList<Module> findModuleByLecturerId(@Param("lid") String lid);
	
	@Query(value="select * from modules m where m.academicYear = :year", nativeQuery = true)
	ArrayList<Module> findModuleByAcademicYear(@Param("year") Date year);
	
}

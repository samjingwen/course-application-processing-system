package sg.iss.team5.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.Module;


public interface ModuleRepository extends JpaRepository<Module, String> {

	@Query("select m from module m where m.moduleid in(select s.moduleid from studentcourse s where s.studentid = :sid)")
	ArrayList<Module> findModuleByStudentId(@Param("sid") String sid);
	
	@Query("select m from Module m where m.lecturer = :lid")
	ArrayList<Module> findModuleByLecturerId(@Param("lct") String lid);
	
	@Query("select m from Module m where m.academicYear = :year")
	ArrayList<Module> findModuleByAcademicYear(@Param("lct") Date year);
}

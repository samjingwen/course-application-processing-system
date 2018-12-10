package sg.iss.team5.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fasterxml.jackson.databind.Module;

public interface ModuleRepository extends JpaRepository<Module, String> {

	@Query("select m from module m where m.moduleid in(select s.moduleid from studentcourse s where s.studentid = :sid)")
	ArrayList<Module> findModuleByStudentId(@Param("sid") String sid);
}

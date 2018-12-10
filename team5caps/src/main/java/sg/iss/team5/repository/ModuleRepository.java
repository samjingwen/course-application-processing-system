package sg.iss.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.databind.Module;

public interface ModuleRepository extends JpaRepository<Module, String> {

}

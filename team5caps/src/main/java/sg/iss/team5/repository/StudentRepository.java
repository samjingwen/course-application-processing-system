package sg.iss.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}

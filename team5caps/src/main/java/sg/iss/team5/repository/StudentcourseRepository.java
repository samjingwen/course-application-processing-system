package sg.iss.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.StudentcoursePK;

public interface StudentcourseRepository extends JpaRepository<Studentcourse, StudentcoursePK> {

}

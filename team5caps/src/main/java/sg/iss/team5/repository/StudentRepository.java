package sg.iss.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
//
//	List<Course> findByNameAndId(String name, Long id);
//
//	List<Course> findByName(String name);
//
//	List<Course> countByName(String name);
//
//	List<Course> findByNameOrderByIdDesc(String name);
//
//	List<Course> deleteByName(String name);
//
//	@Query("Select  c  From Course c where name like '%100 Steps'")
//	List<Course> courseWith100StepsInName();
//
//	@Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)
//	List<Course> courseWith100StepsInNameUsingNativeQuery();
//
//	@Query(name = "query_get_100_Step_courses")
//	List<Course> courseWith100StepsInNameUsingNamedQuery();
}

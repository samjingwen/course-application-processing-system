package sg.iss.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query("SELECT u FROM User u WHERE u.userID=:userid AND u.password=:password")
	User findUserByIdPwd(@Param("userid") String userid, @Param("password") String password);
    
	@Query("SELECT u FROM User u WHERE u.userID=:userid")
	User findUserByUserId(@Param("userid") String userid);
	
}

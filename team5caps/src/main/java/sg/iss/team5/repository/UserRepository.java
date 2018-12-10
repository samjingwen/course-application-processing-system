package sg.iss.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}

package sg.iss.team5.service;

import java.util.ArrayList;

import sg.iss.team5.model.User;

public interface UserService {

	ArrayList<User> findAllUsers();

	//User findUser(String userId);

	User createUser(User user);

	User changeUser(User user);

	String getAccessLevelForUser(String userId);

	User authenticate(String userid, String password);
}

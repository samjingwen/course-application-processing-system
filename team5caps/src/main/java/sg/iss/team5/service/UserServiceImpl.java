package sg.iss.team5.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5.model.User;
import sg.iss.team5.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository userRepository;
	
	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ul = (ArrayList<User>) userRepository.findAll();
		return ul;
	}

//	@Transactional
//	public User findUser(String userId) {
//		return userRepository.findOne(userId);
//	}

	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	@Transactional
	public User changeUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Transactional
	public void removeUser(User user) {
		userRepository.delete(user);
	}
	
	@Transactional
	public User authenticate(String uname, String pwd) {
		User u = userRepository.findUserByIdPwd(uname, pwd);
		return u;
	}

	@Override
	public String getAccessLevelForUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

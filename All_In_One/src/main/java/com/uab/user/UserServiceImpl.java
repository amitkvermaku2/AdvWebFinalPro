package com.uab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
    public User createUser(User user) {
		user.setRole("user");
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
    	return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
    	user.setRole("user");
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
    @Override
    public User findByUsername(Long username) {
        return userRepository.findByUserId(username);
    }
}

package com.project.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;


@Service
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}
	
	public User getOneUserById(Long userId) {
		// custom excepetion
		return userRepository.findById(userId).orElse(null);
	}
	
	public User updateOneUSer(Long userId,User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		} else {
			return null;
		}
	}
	
	public void deleteOneUser(Long userId) {
		userRepository.deleteById(userId);
	}

}

package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import com.project.questapp.responses.UserResponse;
import com.project.questapp.services.UserService;

@RestController
@RequestMapping("/users") //ana path adı
public class UsersController {
	private UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
	}

	@GetMapping("/{userId}")
	public UserResponse getOneUser(@PathVariable Long userId) {
		// custom excepetion ekle
		return new UserResponse(userService.getOneUserById(userId));
	}

	@PutMapping("/{userId}")
	public User updateOneUSer(@PathVariable Long userId, @RequestBody User newUser) {
		
			return userService.updateOneUSer(userId, newUser);
		}


	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteOneUser(userId);
	}
	
	@GetMapping("/activity/{userId}")
	public List<Object> getUserActivity(@PathVariable Long userId){
		
		return userService.getUserActivity(userId);
 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

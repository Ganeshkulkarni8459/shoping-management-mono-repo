package org.dnyanyog.controller;

import org.dnyanyog.dto.User;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {
	@Autowired
	UserManagementService userService;

	@PostMapping(path = "/api/v1/user/add/update", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public UserResponse userService(@RequestBody UserRequest userRequest) {
		return userService.addUpdateUser(userRequest);
	}

	@GetMapping(path = "/api/v1/user/search/{userId}")
	public User getSingleUser(@PathVariable Long userId) {

		return userService.getSingleUser(userId);
	}
	@DeleteMapping(path="/api/v1/user/delete/{userId}")
	public User deleteUser(@PathVariable Long userId) {
		
		return userService.deleteUser(userId);
	}
}

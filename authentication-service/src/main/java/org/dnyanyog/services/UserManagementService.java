package org.dnyanyog.services;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.User;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {

	@Autowired
	UsersRepository userRepo;// ask spring to give object of 'Query class for users' i.e. UserRepository

	public UserResponse addUpdateUser(UserRequest request) {

		UserResponse response = new UserResponse(); // create object to send response back

		Users usersTable = new Users();

		if (request.getUsername() != null) {
			Optional<Users> existsUser = userRepo.findById(request.getUserId());

			if (existsUser.isPresent()) {
				Users user = existsUser.get();

				user.setAge(request.getAge());
				user.setEmail(request.getEmail());
				user.setPassword(request.getPassword());
				user.setUsername(request.getUsername());

				user = userRepo.save(user);

				response.setMessage("User Updated Successfuly");
				response.setStatus("Success");
				response.setUserId(user.getUserID());

				return response;
			}
		}
		usersTable.setAge(request.getAge());
		usersTable.setEmail(request.getEmail());
		usersTable.setPassword(request.getPassword());
		usersTable.setUsername(request.getUsername());

		usersTable = userRepo.save(usersTable);

		response.setMessage("User Added Successfuly");
		response.setStatus("Success");
		response.setUserId(usersTable.getUserID());

		return response;
	}

	public User getSingleUser(Long userId) {

		User userResponse = new User();

		Optional<Users> receivedData = userRepo.findById(userId);

		if (receivedData.isEmpty()) {
			userResponse.setStatus("fail");
			userResponse.setMessage("User Found");
		} else {
			Users user = receivedData.get();
			userResponse.setMessage("User Found");
			userResponse.setStatus("Success");
			userResponse.setEmail(user.getEmail());
			userResponse.setUsername(user.getUsername());
			userResponse.setPassword(user.getPassword());
			userResponse.setUserId(user.getUserID());
			userResponse.setAge(user.getAge());
		}
		return userResponse;
	}

	public UserResponse deleteUser(Long userId) {

		UserResponse response = new UserResponse();

		Optional<Users> existingUser = userRepo.findById(userId);

		if (existingUser.isPresent()) {
			Users user = existingUser.get();
			userRepo.delete(user);

			response.setMessage("User Deleted Successfully");
			response.setStatus("Success");
			response.setUserId(user.getUserID());
		} else {
			response.setMessage("User Not Found");
			response.setStatus("Failed");
		}
		return response;
	}
}

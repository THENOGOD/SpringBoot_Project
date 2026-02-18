package com.example.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public List<UserResponse> findAll() {
		return userService.findAll();
	}

	@GetMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
	public UserResponse findById(@PathVariable Integer userId) {
		return userService.findById(userId);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public UserResponse create(@RequestBody CreateUserRequest request) {
		return userService.createUser(request);
	}

	@PatchMapping(value = "/{userId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public UserResponse update(@PathVariable Integer userId, @RequestBody CreateUserRequest request) {
		return userService.update(userId, request);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer userId) {
		userService.delete(userId);
	}
}

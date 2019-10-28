package com.harrybooks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harrybooks.model.User;
import com.harrybooks.repository.IUserRepository;

@Service
public class UserService {
	private final IUserRepository userRepository;
	
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public User findByUser(String user) {
		List<User> findByUserl = this.userRepository.findByUserl(user);
		return findByUserl.get(0);
	}
}

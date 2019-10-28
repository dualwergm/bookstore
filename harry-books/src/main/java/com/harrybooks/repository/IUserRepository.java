package com.harrybooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrybooks.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	public List<User> findByUserl(String userl);
}

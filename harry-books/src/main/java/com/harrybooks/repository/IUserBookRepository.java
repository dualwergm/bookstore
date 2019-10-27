package com.harrybooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrybooks.model.UserBook;

public interface IUserBookRepository extends JpaRepository<UserBook, Long>{
}

package com.harrybooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrybooks.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long>{
}

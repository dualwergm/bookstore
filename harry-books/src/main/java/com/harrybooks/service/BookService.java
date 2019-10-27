package com.harrybooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harrybooks.model.Book;
import com.harrybooks.repository.IBookRepository;

@Service
public class BookService {
	private final IBookRepository bookRepository;

	public BookService(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional
	public Book update(Book book) {
		return this.bookRepository.save(book);
	}

	@Transactional(readOnly = true)
	public Book findById(Long id) {
		Optional<Book> findById = this.bookRepository.findById(id);
		return findById.isPresent() ? findById.get() : null;
	}

	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}
	
	public List<Book> findByIds(Iterable<Long> ids) {
		return this.bookRepository.findAllById(ids);
	}
}

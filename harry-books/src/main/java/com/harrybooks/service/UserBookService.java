package com.harrybooks.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harrybooks.model.UserBook;
import com.harrybooks.repository.IUserBookRepository;

@Service
public class UserBookService {
	private final IUserBookRepository userBookRepository;
	public UserBookService(IUserBookRepository userBookRepository) {
		this.userBookRepository = userBookRepository;
	}
	
	@Transactional
	public UserBook create(UserBook userBook) {
		return this.userBookRepository.save(userBook);
	}
}

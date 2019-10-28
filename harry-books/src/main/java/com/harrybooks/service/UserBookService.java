package com.harrybooks.service;

import java.util.List;

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
	public List<UserBook> createAll(List<UserBook> userBookList) {
		return this.userBookRepository.saveAll(userBookList);
	}
}

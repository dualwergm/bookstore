package com.harrybooks.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.harrybooks.model.Book;
import com.harrybooks.model.User;
import com.harrybooks.model.UserBook;
import com.harrybooks.repository.IUserBookRepository;
import com.harrybooks.util.Utils;

@Service
public class UserBookService {
	private final IUserBookRepository userBookRepository;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	public UserBookService(IUserBookRepository userBookRepository) {
		this.userBookRepository = userBookRepository;
	}
	
	@Transactional
	public List<UserBook> createAll(List<UserBook> userBookList) {
		return this.userBookRepository.saveAll(userBookList);
	}
	
	public List<UserBook> buildShoppingList(JsonNode root){
		int index = 0;
		List<Long> bookIds = Utils.stringToLongList(root.path("ids").asText());
		List<Integer> bookAmounts = Utils.stringToIntegerList(root.path("amounts").asText());
		List<UserBook> userBookList = new ArrayList<UserBook>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUser(auth.getName());
		for(Long bookId: bookIds) {
			UserBook userBook = new UserBook();
			Book book = bookService.findById(bookId);
			book.setAvailable(book.getAvailable() - bookAmounts.get(index));
			userBook.setBook(book);
			userBook.setUser(user);
			userBook.setAmount(bookAmounts.get(index));
			userBookList.add(userBook);
			index++;
		}
		return userBookList;
	}
}

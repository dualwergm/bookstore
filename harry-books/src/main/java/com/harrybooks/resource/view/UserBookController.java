package com.harrybooks.resource.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.harrybooks.model.Book;
import com.harrybooks.model.UserBook;
import com.harrybooks.service.BookService;
import com.harrybooks.service.UserBookService;
import com.harrybooks.util.Utils;

@RestController
@RequestMapping("shopping")
public class UserBookController {
	
	@Autowired
	private UserBookService userBookService;
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/save")
	public ModelAndView getBooks(@RequestParam String jparams) {
		ModelAndView mav = new ModelAndView("redirect:/book/list");
		JsonNode root = Utils.getJNodeParams(jparams);
		List<UserBook> buildShoppingList = buildShoppingList(root);
		userBookService.createAll(buildShoppingList);
		return mav;
	}
	
	private List<UserBook> buildShoppingList(JsonNode root){
		int index = 0;
		List<Long> bookIds = Utils.stringToLongList(root.path("ids").asText());
		List<Integer> bookAmounts = Utils.stringToIntegerList(root.path("amounts").asText());
		List<UserBook> userBookList = new ArrayList<UserBook>();
		for(Long bookId: bookIds) {
			UserBook userBook = new UserBook();
			Book book = bookService.findById(bookId);
			book.setAvailable(book.getAvailable() - bookAmounts.get(index));
			userBook.setBook(book);
			userBook.setAmount(bookAmounts.get(index));
			userBookList.add(userBook);
			index++;
		}
		return userBookList;
	}
}

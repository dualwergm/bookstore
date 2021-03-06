package com.harrybooks.resource.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.harrybooks.model.Book;
import com.harrybooks.service.BookService;
import com.harrybooks.util.Utils;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public ModelAndView getBooks() {
		ModelAndView mav = new ModelAndView();
		List<Book> findAll = bookService.findAll();
		mav.addObject("bookList", findAll);
		mav.setViewName("books");
		return mav;
	}
	
	@GetMapping("/shopping")
	public ModelAndView getShoppingList(@RequestParam String jparams) {
		ModelAndView mav = new ModelAndView();
		JsonNode root = Utils.getJNodeParams(jparams);
		List<Book> bookList = bookService.findByIds(Utils.stringToLongList(root.path("ids").asText()));
		mav.addObject("shopping", bookService.loadAmountToShopping(bookList, Utils.stringToIntegerList(root.path("amounts").asText())));
		mav.setViewName("shopping");
		return mav;
	}
}

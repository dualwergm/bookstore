package com.harrybooks.resource.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.harrybooks.model.Book;
import com.harrybooks.service.BookService;

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
		List<Long> list = new ArrayList<Long>();
		list.add(Long.valueOf(1));
		list.add(Long.valueOf(2));
		List<Book> findAll = bookService.findByIds(list);
		mav.addObject("bookList", findAll);
		mav.setViewName("books");
		return mav;
	}
	
	
}

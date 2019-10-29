package com.harrybooks.resource.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.harrybooks.model.UserBook;
import com.harrybooks.service.UserBookService;
import com.harrybooks.util.Utils;

@RestController
@RequestMapping("shopping")
public class UserBookController {
	
	@Autowired
	private UserBookService userBookService;
	
	
	@GetMapping("/save")
	public ModelAndView getBooks(@RequestParam String jparams) {
		ModelAndView mav = new ModelAndView("redirect:/book/list");
		JsonNode root = Utils.getJNodeParams(jparams);
		List<UserBook> buildShoppingList = userBookService.buildShoppingList(root);
		userBookService.createAll(buildShoppingList);
		return mav;
	}
}

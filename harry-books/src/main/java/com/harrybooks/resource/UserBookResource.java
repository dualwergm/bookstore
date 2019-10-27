package com.harrybooks.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harrybooks.model.UserBook;
import com.harrybooks.resource.vo.UserBookVO;
import com.harrybooks.service.UserBookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/book")
@Api(tags = "User books")
public class UserBookResource {
	private final UserBookService userBookService;

	public UserBookResource(UserBookService userBookService) {
		this.userBookService = userBookService;
	}

	@PostMapping
	@ApiOperation(value = "Add book to user", notes = "Service to add a book to user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Book added"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<UserBook> createUserBook(@RequestBody UserBookVO userBookVO) {
		UserBook userBook = new UserBook();
		return new ResponseEntity<UserBook>(this.userBookService.create(userBook), HttpStatus.CREATED);
	}
}

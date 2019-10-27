package com.harrybooks.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harrybooks.model.Book;
import com.harrybooks.resource.vo.BookVO;
import com.harrybooks.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/book")
@Api(tags = "Books")
public class BookResource {
	private final BookService bookService;

	public BookResource(BookService bookService) {
		this.bookService = bookService;
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update book", notes = "Service to update a book")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Book updated successfully"),
			@ApiResponse(code = 404, message = "Book not found") })
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, BookVO bookVO) {
		Book book = this.bookService.findById(id);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		book.setAvailable(bookVO.getAvailable());
		return new ResponseEntity<>(this.bookService.update(book), HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "Book list", notes = "Get all books")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Books found"),
			@ApiResponse(code = 404, message = "Books not found") })
	public ResponseEntity<List<Book>> findAll() {
		return ResponseEntity.ok(this.bookService.findAll());
	}
}

package com.harrybooks.resource.vo;

import com.harrybooks.model.Book;
import com.harrybooks.model.User;

import lombok.Data;

@Data
public class UserBookVO {
	private Long id;
	private User user;
	private Book book;
}

package com.harrybooks.resource.vo;

import com.harrybooks.model.Book;

import lombok.Data;

@Data
public class ShoppingItemVO {
	private Long id;
	private String title;
	private int amount;
	private int available;
	private double price;
	private double partialTotal;
	
	public void toVO(Book book, int amountToBuy) {
		setId(book.getId());
		setTitle(book.getTitle());
		setAmount(amountToBuy);
		setPrice(book.getPrice());
		setAvailable(book.getAvailable());
		setPartialTotal(amountToBuy * book.getPrice());
	}
}

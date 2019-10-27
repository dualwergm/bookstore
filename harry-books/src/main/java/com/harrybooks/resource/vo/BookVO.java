package com.harrybooks.resource.vo;

import lombok.Data;

@Data
public class BookVO {
	private Long id;
	private String code;
	private String title;
	private double price;
	private int available;
}

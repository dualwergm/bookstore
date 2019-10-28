package com.harrybooks.resource.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ShoppingVO {
	private List<ShoppingItemVO> itemList = new ArrayList<ShoppingItemVO>();
	private double total;
}

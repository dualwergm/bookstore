package com.harrybooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harrybooks.model.Book;
import com.harrybooks.repository.IBookRepository;
import com.harrybooks.resource.vo.ShoppingItemVO;
import com.harrybooks.resource.vo.ShoppingVO;

@Service
public class BookService {
	private final IBookRepository bookRepository;

	public BookService(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional
	public Book update(Book book) {
		return this.bookRepository.save(book);
	}

	@Transactional(readOnly = true)
	public Book findById(Long id) {
		Optional<Book> findById = this.bookRepository.findById(id);
		return findById.isPresent() ? findById.get() : null;
	}

	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}
	
	public List<Book> findByIds(Iterable<Long> ids) {
		return this.bookRepository.findAllById(ids);
	}
	
	public ShoppingVO loadAmountToShopping(List<Book> bookList, List<Integer> amountList){
		int counter = 0;
		double total = 0;
		ShoppingVO shoppingVO = new ShoppingVO();
		for(Book book: bookList) {
			ShoppingItemVO shoppingItemVO = new ShoppingItemVO();
			shoppingItemVO.toVO(book, amountList.get(counter));
			shoppingVO.getItemList().add(shoppingItemVO);
			total += shoppingItemVO.getPartialTotal();
			counter++;
		}
		shoppingVO.setTotal(total);
		return shoppingVO;
	}
}

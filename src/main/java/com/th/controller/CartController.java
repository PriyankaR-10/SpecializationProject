package com.th.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.th.model.Book;
import com.th.model.Userscart;
import com.th.repository.BookRepository;
import com.th.repository.UsersCartRepository;

/**
 * This class allows you to add, delete, get and find a book by id in a user's cart
 * @author Rohith S
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	
	
	@Autowired
	UsersCartRepository usersCartRepository;
	@Autowired
	BookRepository bookRepository;
	
	/**
	 * getAllBooksFromCart displays all books to the user under cart
	 * @return ResponseEntity<List<Book>> returns a list of books
	 */
	@GetMapping("/getAllBooks")
	public  ResponseEntity<List<Book>> getAllBooksFromCart(){
		
		List<Book> blist = bookRepository.findAll();
		return new ResponseEntity<List<Book>>(blist,HttpStatus.OK);
	}
	
	/**
	 * addBookToCart adds a book to the respective user's cart
	 * @param userscart adds a book to the Userscart table
	 * @return ResponseEntity<Userscart> shows the details of the book that was added to the cart
	 */
	@PostMapping("/book")
	public ResponseEntity<Userscart> addBookToCart(@RequestBody Userscart userscart){
		Userscart  userscartSaved= usersCartRepository.save(userscart);
		return new ResponseEntity<Userscart>(userscartSaved,HttpStatus.OK);
	}
	
	/** 
	 * deleteBookById deletes a book from the user's cart
	 * @param bookId unique ID of the book
	 * @return ResponseEntity<Book> no content else returns not found 
	 */
	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<Userscart> deleteBookById(@PathVariable int bookId){
		
		if(usersCartRepository.existsById(bookId)) {
			usersCartRepository.deleteById(bookId);
			return new ResponseEntity<Userscart>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<Userscart>(HttpStatus.NOT_FOUND);
			
	}
	
	
	

}

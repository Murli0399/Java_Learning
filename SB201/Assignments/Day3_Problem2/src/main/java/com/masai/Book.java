package com.masai;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String name;
	private String author;
	private String publication;
	private String category;
	private int pages;
	private int price;
	private LocalDateTime timestamp;

	public Book(int bookId, String name, String author, String publication, String category, int pages, int price,
			LocalDateTime timestamp) {
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.pages = pages;
		this.price = price;
		this.timestamp = timestamp;
	}

	public Book(String name, String author, String publication, String category, int pages, int price,
			LocalDateTime timestamp) {
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.pages = pages;
		this.price = price;
		this.timestamp = timestamp;
	}

	public Book() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Book Id: " + bookId + ", Name: " + name + ", Author: " + author + ", Publication: " + publication
				+ ", Category: " + category + ", Pages: " + pages + ", Price: " + price + ", TimeStamp: " + timestamp;
	}

}
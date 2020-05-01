package service.model;

import dao.Entity.Read_Book;

public class Read_BookProfile {
	private Read_Book readBook;
	private String Author;
	public Read_BookProfile() {}
	
	public Read_BookProfile(Read_Book readBook,String Author) {
	 
		this.readBook=readBook;
		this.Author=Author;
	}
	
	public Read_Book getRead_Book() {
		return readBook;
	}
	public void SetRead_Book(Read_Book readBook) {
		this.readBook=readBook;
	}
	public String getAuthor() {
		return Author;
	}
	public void SetAuthor(String Author) {
		this.Author=Author;
	}
}

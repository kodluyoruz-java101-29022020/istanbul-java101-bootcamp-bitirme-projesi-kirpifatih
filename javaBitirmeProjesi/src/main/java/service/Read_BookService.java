package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Entity.Read_Book;
import dao.Jpa.Read_BookRepository;
import service.model.Read_BookContext;
import service.model.Read_BookProfile;

@Service
public class Read_BookService{
	
	@Autowired
	private   Read_BookRepository read_BookRepository;
	
	 
	public Read_Book findByid_Read(Long id_Read) {
		
		return read_BookRepository.findWithid_Read(id_Read);
	}
	
	public List<Read_Book> getAllRead_BookList() {
		
		return read_BookRepository.getAllRead_BookList();
	}
	
	public List<Read_BookProfile> getAllRead_BookProfileList(int upperLimit) {
		
		return read_BookRepository.getAllRead_BookProfileList(PageRequest.of(0, upperLimit));
	}
	
	@Transactional
	public Long save(Read_BookContext read_BookContext) {
		
		Long maxId = read_BookRepository.findMaxId() + 1;
		
		Read_Book read_Book = new Read_Book();
		read_Book.setid_Read(maxId);
		read_Book.setTitle(read_BookContext.getTitle());
		read_Book.setPressYear(read_BookContext.getPressYear());
		read_Book.setDescription(read_BookContext.getDescription());
		read_Book.setAuthor(read_BookContext.getAuthor());
		
		read_Book = read_BookRepository.save(read_Book);
	
		
		return read_Book.getid_Read();
	}
	
	
}
package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.Entity.Read_Book;
import service.Read_BookService;
import service.model.Read_BookContext;
import service.model.Read_BookProfile;

@RestController
@RequestMapping("/application")
public class Read_BookController {
	@Autowired
	private Read_BookService read_BookService;
	
	@RequestMapping(value = "/read_Book/{id}", method = RequestMethod.GET)
	public Read_Book findByid_Read(@PathVariable("id") Long id) {
		
		return read_BookService.findByid_Read(id);
	}
	@RequestMapping(value = "/read_Book/list", method = RequestMethod.GET)
	public List<Read_Book> getAllEmployeeList() {
		
		return read_BookService.getAllRead_BookList();
	}
	
	@RequestMapping(value = "/read_Book/profile/list", method = RequestMethod.GET)
	public ResponseEntity<List<Read_BookProfile>> 
		getAllRead_BookProfileList(@RequestParam("size") Integer upperLimit, HttpServletRequest httpRequest) {
		
		String apikey = (String)httpRequest.getHeader("x-api-key");
		
		if(apikey == null) {
			throw new RuntimeException("Set x-api-key error!!!");
		}
		else if(!apikey.equals("FATIH")) {
			throw new RuntimeException("Invalid x-api-key error!!!");
		}
		
		List<Read_BookProfile> profiles = read_BookService.getAllRead_BookProfileList(upperLimit);
		
		ResponseEntity<List<Read_BookProfile>> response = 
				new ResponseEntity<List<Read_BookProfile>>(profiles, HttpStatus.UNAUTHORIZED);
		
		return response;
	}
	@RequestMapping(value = "/read_Book", method = RequestMethod.POST)
	public Long save(@RequestBody Read_BookContext read_BookContext) {
		
		return read_BookService.save(read_BookContext);
	}
	

}

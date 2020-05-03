package integration.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dao.Entity.Read_Book;
import dao.Jpa.Read_BookRepository;
import service.model.Read_BookProfile;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class Read_BookRepositoryIT {
	
	@Autowired
	private Read_BookRepository read_BookRepository;
	
	
	@Test
	@Order(1)
	public void selectEmployeeByEmpNo() {
		
		Long maxId = read_BookRepository.findMaxId();
		Read_Book read_Book = read_BookRepository.findWithid_Read(maxId);
		
		Assert.assertNotNull(read_Book);
		Assert.assertTrue(read_Book.getid_Read() > 0);
	}
	
	@Test
	@Order(2)
	public void selectAllEmployeeProfileList() {
		
		List<Read_BookProfile> read_BookProfileList = read_BookRepository.getAllRead_BookProfileList(PageRequest.of(0, 1));
		
		Assert.assertEquals(read_BookProfileList.size(), 1);
	}
	
	
	@Test
	@Transactional
	@Rollback(false) //true
	@Order(3)
	public void saveRead_Book() {
		
		Long maxId = read_BookRepository.findMaxId();
		Long newRead_BookId = maxId + 1;
		
		Read_Book read = new Read_Book();
		 read.setid_Read(newRead_BookId);
		 read.setTitle("veranda öyküleri");
		 read.setDescription("Hoş kitap");
		 read.setPressYear(new Date());
		 read.setAuthor("herman melville");
		
		read_BookRepository.save(read);
		
		read = read_BookRepository.findWithid_Read(newRead_BookId);
		
		Assert.assertNotNull(read);
		Assert.assertTrue(read.getid_Read() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(false) //true
	@Order(4)
	public void updateEmployee() {
		
		Long maxId = read_BookRepository.findMaxId();
		Read_Book read = read_BookRepository.findWithid_Read(maxId);
		
		 read.setTitle("veranda öyküleri");
		 read.setDescription("Hoş kitap");
		 
		
		read_BookRepository.save(read);
		
		read = read_BookRepository.findWithid_Read(maxId);
		
		Assert.assertEquals("Dikenli yolun yolcusu", read.getTitle());
		Assert.assertEquals("hoş kitap", read.getDescription());
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(5)
	public void deleteEmployee() {
		
		Long maxId = read_BookRepository.findMaxId();
		Read_Book read = read_BookRepository.findWithid_Read(maxId);
		
		read_BookRepository.delete(read);
		
		read = read_BookRepository.findWithid_Read(maxId);
		
		Assert.assertNull(read);
	}

}

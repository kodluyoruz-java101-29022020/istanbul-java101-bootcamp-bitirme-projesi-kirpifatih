package mock.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import dao.Entity.Read_Book;
import dao.Jpa.Read_BookRepository;
import service.Read_BookService;
import service.model.Read_BookContext;

@RunWith(MockitoJUnitRunner.class)
public class Read_BookServiceMT {

	@Mock
    private Read_BookRepository read_BookRepository;
	
	
	@InjectMocks
	private Read_BookService read_BookService;
	
	
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void queryEmployee() {
		
		Read_Book read = new Read_Book();
	    read.setid_Read(10L);
	    read.setTitle("veranda öyküleri");
	    read.setDescription("Hoş kitap");
	    read.setPressYear(new Date());
	    read.setAuthor("herman melville");
	    
	    Read_Book read3 = new Read_Book();
	    read3.setid_Read(10L);
	    read3.setTitle("Fatih sultan mehmet");
	    read3.setDescription("Hoş kitap");
	    read3.setPressYear(new Date());
	    read3.setAuthor("Mustafa uslu");
		 
	    Mockito
	    	.when(read_BookRepository.findWithid_Read(10L))
	    	.thenReturn(read);
	    
	    Mockito
	    	.when(read_BookRepository.findWithid_Read(11L))
	    	.thenReturn(read3);
	    
		
		Read_Book read2 = read_BookService.findByid_Read(11L);
		
		Assert.assertNotNull(read2);
		Assert.assertTrue(read2.getid_Read() > 0);
	}
	
	
	@Test
	public void queryAllEmployees() {
		
		Read_Book read = new Read_Book();
	    read.setid_Read(10L);
	    read.setTitle("veranda öyküleri");
	    read.setDescription("Hoş kitap");
	    read.setPressYear(new Date());
	    read.setAuthor("herman melville");
	    
	    Read_Book read3 = new Read_Book();
	    read3.setid_Read(10L);
	    read3.setTitle("Fatih sultan mehmet");
	    read3.setDescription("Hoş kitap");
	    read3.setPressYear(new Date());
	    read3.setAuthor("Mustafa uslu");
		 
	    
	    
		List<Read_Book> read_book = Arrays.asList(read,read3);
		
		Mockito
			.when(read_BookRepository.getAllRead_BookList())
			.thenReturn(read_book);
		
		
		
		List<Read_Book> read_Book2 =read_BookService.getAllRead_BookList();
		
		Assert.assertNotNull(read_Book2);
		Assert.assertTrue(read_Book2.size() > 0);
	}
	
	@Test
	public void saveRead_Book() {
		
		Read_BookContext readContext = new Read_BookContext();
		readContext.setid_Read(10L);
	    readContext.setTitle("veranda öyküleri");
	    readContext.setDescription("Hoş kitap");
	    readContext.setPressYear(new Date());
	    readContext.setAuthor("herman melville");
		
	    Long maxRead_BookId = 100L;
	    
		Read_Book read = new Read_Book();
	    read.setid_Read(maxRead_BookId + 1);
	    read.setTitle(readContext.getTitle());
	    read.setDescription(readContext.getDescription());
	    read.setAuthor(readContext.getAuthor());
	    read.setPressYear(readContext.getPressYear());
		
	    Mockito
			.when(read_BookRepository.findMaxId())
			.thenReturn(maxRead_BookId);
	    
		Mockito
			.when(read_BookRepository.save(read))
			.thenReturn(read);
		
		
		long readId = read_BookService.save(readContext);
		
		Assert.assertEquals(101L, readId);
	}
	
   private void prepareMockTestRuleRead_BookQueryByid_Read() {
		
	   Read_Book read = new Read_Book();
	    read.setid_Read(10L);
	    read.setTitle("veranda öyküleri");
	    read.setDescription("Hoş kitap");
	    read.setPressYear(new Date());
	    read.setAuthor("herman melville");
		 
	    Mockito
	    	.when(read_BookRepository.findWithid_Read(10L))
	    	.thenReturn(read);
		
	}
   private void prepareMockTestRuleRead_BookProfiles() {
		
		Read_Book read1 = new Read_Book();
		 read1.setid_Read(10L);
		    read1.setTitle("veranda öyküleri");
		    read1.setDescription("Hoş kitap");
		    read1.setPressYear(new Date());
		    read1.setAuthor("herman melville");
	    
		    Read_Book read2 = new Read_Book();
			 read1.setid_Read(10L);
			    read2.setTitle("veranda öyküleri");
			    read2.setDescription("Hoş kitap");
			    read2.setPressYear(new Date());
			    read2.setAuthor("herman melville");
	    
	    
		List<Read_Book> read_Book = Arrays.asList(read1,read2);
		
		Mockito
			.when(read_BookRepository.getAllRead_BookList())
			.thenReturn(read_Book);
		
	}
   private void prepareMockTestRuleRead_BookSave(Read_BookContext readContext) {
		
		Long read_BookId = 100L;
		Read_Book read = new Read_Book();
		read.setid_Read(read_BookId + 1);
	    read.setTitle(readContext.getTitle());
	    read.setDescription(readContext.getDescription());
	    read.setAuthor(readContext.getAuthor());
	    read.setPressYear(readContext.getPressYear());
	    Mockito
			.when(read_BookRepository.findMaxId())
			.thenReturn(read_BookId);
	    
		Mockito
			.when(read_BookRepository.save(read))
			.thenReturn(read);
	}
}



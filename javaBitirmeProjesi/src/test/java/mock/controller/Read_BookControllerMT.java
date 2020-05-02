package mock.controller;

import java.util.Arrays;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import controller.Read_BookController;
import service.Read_BookService;
import service.model.Read_BookProfile;

@RunWith(MockitoJUnitRunner.class)
public class Read_BookControllerMT {
	
	@Mock
	private Read_BookService read_BookService;
	
	@InjectMocks
	private Read_BookController read_BookController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllRead_BookProfileListWithApiKey() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("x-api-key", "Fatih");
        
		
		List<Read_BookProfile> profiles = Arrays.asList(new Read_BookProfile());
		
		Mockito
			.when(read_BookService.getAllRead_BookProfileList(1))
			.thenReturn(profiles);
        
        
		ResponseEntity<List<Read_BookProfile>> read_BookList = read_BookController.getAllRead_BookProfileList(1, request);
	
        Assert.assertTrue(HttpStatus.UNAUTHORIZED.equals(read_BookList.getStatusCode()));
        Assert.assertEquals(1, read_BookList.getBody().size());
	}
	
	private void prepareMockTestRuleRead_BookProfileList() {
		
		List<Read_BookProfile> profiles = Arrays.asList(new Read_BookProfile());
		
		Mockito
			.when(read_BookService.getAllRead_BookProfileList(1))
			.thenReturn(profiles);
	}
}

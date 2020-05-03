package integration.controller;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import dao.Entity.Read_Book;
import service.model.Read_BookContext;
import service.model.Read_BookProfile;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class Read_BookControllerIT {

	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int tomcatPortNo;
	
	
	@Test
	@Order(1)
	public void testRestTemplate() {
		
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);
		
		System.out.println(tomcatPortNo);
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(response.getBody().length() > 0);
	}
	@Test
	@Order(2)
	public void findRead_BookById() {
		
		String url = prepareRead_BookRestServiceRootUrl() + "read_Book/10003";
		
		ResponseEntity<Read_Book> response = restTemplate.getForEntity(url, Read_Book.class);
		
		Read_Book read = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(10003 == read.getid_Read());
	}
	
	@Test
	@Order(3)
	public void saveRead_Book() {
		
		String url = prepareRead_BookRestServiceRootUrl() + "read_Book";
		
		Read_BookContext read = new Read_BookContext();
		 read.setTitle("veranda öyküleri");
		 read.setDescription("Hoş kitap");
		 read.setPressYear(new Date());
		 read.setAuthor("herman melville");
		
		ResponseEntity<Long> response = restTemplate.postForEntity(url, read, Long.class);
		
		Long id_Read = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertNotNull(id_Read);
	}
	
	@Test
	@Order(4)
	public void getAllRead_BookProfileList() {
		
		String url = prepareRead_BookRestServiceRootUrl() + "read_Book/profile/list?size=1";
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("x-api-key", "Fatih");
		
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(httpHeaders);
		
		ResponseEntity<List<Read_BookProfile>> response = restTemplate.exchange(
				url, 
				HttpMethod.GET, 
				httpEntity, 
				new ParameterizedTypeReference<List<Read_BookProfile>>() {} );
		
		List<Read_BookProfile> profiles = response.getBody();
		
		Assert.assertTrue(HttpStatus.UNAUTHORIZED.equals(response.getStatusCode()));
		Assert.assertNotNull(profiles);
		Assert.assertEquals(1, profiles.size());
	}
	
	private String prepareRead_BookRestServiceRootUrl() {
		
		return "http://localhost:" + tomcatPortNo + "/company/";
	}
	
}

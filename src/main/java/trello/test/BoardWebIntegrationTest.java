package trello.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import trello.domain.Board;
import trello.domain.BoardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class BoardWebIntegrationTest extends WebIntegrationTest{
	@Autowired
	private BoardRepository boardRepository;
	private RestTemplate template;
	
	@Before
	public void setup() {
		template = new RestTemplate();
	}
	
	@Test
	public void createObject() throws Exception {
		Board board = new Board("name");
		System.out.println(baseUrl());
		Board actual = template.postForObject(baseUrl() + "/project", board, Board.class);
	}
	
	@Test
	public void createEntity() throws Exception {
		Board board = new Board("name");
		ResponseEntity<Board> responseEntity = template.postForEntity("http://localhost:8080/project" + "/project", board, Board.class);
		assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
		HttpHeaders headers = responseEntity.getHeaders();
	}
}

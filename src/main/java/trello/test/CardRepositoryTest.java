package trello.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trello.domain.CardRepository;

public class CardRepositoryTest extends IntegrationTest {
	@Autowired
	private CardRepository cardRepository;

	@Test
	public void crud() throws Exception {
//		assert.equals(obj)
	}
}
package trello.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trello.domain.Card;
import trello.domain.CardRepository;

public class CardRepositoryTest extends IntegrationTest {
	@Autowired
	private CardRepository cardRepository;

	@Test
	public void crud() throws Exception {
		 cardRepository.save(new Card("chiho", "chihio"));
		 assertEquals(1, cardRepository.count());
	}
}
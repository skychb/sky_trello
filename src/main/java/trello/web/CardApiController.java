package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trello.domain.trello.BoardRepository;
import trello.domain.trello.Card;
import trello.domain.trello.CardRepository;
import trello.domain.trello.List;
import trello.domain.trello.ListRepository;

@RestController
@RequestMapping("/api/card")
public class CardApiController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Card createCard(String cardName, String description, long listId){
		List list = listRepository.findOne(listId);
		Card cardNew = new Card(cardName, description, list);
		cardRepository.save(cardNew);
		return cardNew;
	}
}

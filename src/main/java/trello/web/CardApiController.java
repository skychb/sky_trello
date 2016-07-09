package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trello.domain.BoardRepository;
import trello.domain.Card;
import trello.domain.CardRepository;
import trello.domain.List;
import trello.domain.ListRepository;

@RestController
@RequestMapping("/api/card")
public class CardApiController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Card createCard(String cardName, String description, long listId){
		List list = listRepository.findOne(listId);
		Card cardNew = new Card(cardName, description, list);
		cardRepository.save(cardNew);
		return cardNew;
	}

}

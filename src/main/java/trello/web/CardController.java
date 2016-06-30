package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import trello.domain.CardRepository;
import trello.domain.CommentRepository;

@Controller
public class CardController {
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
}

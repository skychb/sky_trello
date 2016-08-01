package trello.web;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trello.domain.trello.Card;
import trello.domain.trello.CardRepository;
import trello.domain.trello.Comment;
import trello.domain.trello.CommentRepository;

@RestController
@RequestMapping(value="/api/comment")
public class CommentApiController {
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Comment addComment(long cardId, String userName, String contents, Timestamp timestamp){
		Card card = cardRepository.findOne(cardId);
		Comment comment = new Comment(timestamp, userName, card, contents);
		commentRepository.save(comment);
		return comment;
	}
}

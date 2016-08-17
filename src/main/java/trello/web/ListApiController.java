package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trello.domain.trello.Board;
import trello.domain.trello.BoardRepository;
import trello.domain.trello.List;
import trello.domain.trello.ListRepository;

@RestController
@RequestMapping(value="/project/{id}")
public class ListApiController {
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ListRepository listRepository;
	
	@RequestMapping(value = "/api/addList", method = RequestMethod.POST)
	public ResponseEntity<Void> addList(@RequestBody String listName, @PathVariable long id) {
		Board board = boardRepository.findOne(id);
		listRepository.save(new List(listName, board));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
//		List saved = listRepository.save(list);
//		return new ResponseEntity<List>(saved, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{listId}", method = RequestMethod.GET)
	public ResponseEntity<List> show(@PathVariable long listId) {
		List list = listRepository.findOne(listId);
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}
}

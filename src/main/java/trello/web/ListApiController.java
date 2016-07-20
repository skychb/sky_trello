package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trello.domain.Board;
import trello.domain.BoardRepository;
import trello.domain.List;
import trello.domain.ListRepository;

@RestController
@RequestMapping(value="/api/list")
public class ListApiController {
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ListRepository listRepository;
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.POST)
	public ResponseEntity<List> moreList(@RequestBody List list, @PathVariable long id) {
		List saved = listRepository.save(list);
		return new ResponseEntity<List>(saved, HttpStatus.CREATED);
	}
}

package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public List addList(String listName, long boardId){
		Board board = boardRepository.findOne(boardId);
		List listNew = new List(listName, board);
		listRepository.save(listNew);
		return listNew;
	}
}

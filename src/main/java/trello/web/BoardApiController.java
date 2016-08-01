package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trello.domain.trello.Board;
import trello.domain.trello.BoardRepository;

@RestController
@RequestMapping("/api/board")
public class BoardApiController {
	@Autowired
	private BoardRepository boardRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Board createBoard(String boardName) {
		Board board = new Board(boardName);
		boardRepository.save(board);
		return board;
	}

	// 나중에 고쳐라.
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public ResponseEntity<Board> addBoard(@RequestBody Board board) {
		Board newBoard = boardRepository.save(board);
		return new ResponseEntity<Board>(newBoard, HttpStatus.CREATED);
	}
}

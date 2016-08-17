package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trello.domain.trello.Board;
import trello.domain.trello.BoardRepository;

//controller, RestController의 차이를 알아야지 ㅠ 앞에거는 html, 뒤에거는 json을 받아오잖
@RestController
public class BoardController {
	@Autowired
	private BoardRepository boardRepository;

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ResponseEntity<Board> projectMain(@RequestBody Board board) {
		Board saved = boardRepository.save(board);
		return new ResponseEntity<Board>(saved, HttpStatus.CREATED);
	}
	
//	@RequestMapping(method=RequestMethod.DELETE)
//	public String delete(Board board){
//		boardRepository.delete(board);
//		return "redirect:/project";
//	}
}

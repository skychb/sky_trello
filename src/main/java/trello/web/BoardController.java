package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trello.domain.Board;
import trello.domain.BoardRepository;
import trello.domain.CardRepository;
import trello.domain.ListRepository;

//controller, RestController의 차이를 알아야지 ㅠ 앞에거는 html, 뒤에거는 json을 받아오잖
@Controller
public class BoardController {
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private ListRepository listRepository;
	@Autowired
	private CardRepository cardRepository;

	@RequestMapping(value="/project", method = RequestMethod.GET)
	public String projectMain(Model model) {
		model.addAttribute("board", boardRepository.findAll());
		return "projectMain";
	}

	@RequestMapping(value="/project/{id}", method = RequestMethod.GET)
	public String getPage(Model model, @PathVariable long id){
		model.addAttribute("board", boardRepository.findOne(id));
		model.addAttribute("list", listRepository.findByBoardId(id));
//		model.addAttribute("card", cardRepository.findByListId(listId));
		return "page";
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public String home(@RequestParam String board_name) {
		Board board = new Board(board_name);
		boardRepository.save(board);
		return "redirect:/project";
	}
	
	@RequestMapping(value = "/project", method=RequestMethod.DELETE)
	public String delete(Board board){
		boardRepository.delete(board);
		return "redirect:/project";
	}
}

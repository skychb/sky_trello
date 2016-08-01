package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trello.domain.trello.BoardRepository;

@Controller
public class HomeController {
	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String home() {
		return "index";
	}
//@AuthenticationPricipal User user 이런식으로 기존에 넣을 수 있어여 
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public String page() {
		return "page";
	}
	
	@RequestMapping(value="/project", method=RequestMethod.GET)
	public String getProjects(Model model){
		model.addAttribute("board", boardRepository.findAll());
		return "projectMain";
	}
	
	@RequestMapping(value="/project/{id}", method = RequestMethod.GET)
	public String getPage(@PathVariable long id, Model model){
		model.addAttribute("board", boardRepository.findOne(id));
		return "page";
	}
}

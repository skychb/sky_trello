package trello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trello.domain.CardRepository;
import trello.domain.List;
import trello.domain.ListRepository;

@Controller
public class ListController {
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@RequestMapping(value = "/project/{id}", method=RequestMethod.POST)
	public String projectMain(@RequestParam String list_name){
		List list = new List(list_name);
		listRepository.save(list);
		return "redirect:/project/{id}";
	}
	
	@RequestMapping(value="/project/{id}", method=RequestMethod.DELETE)
	public String deleteList(List list){
		listRepository.delete(list);
		return "redirect:/project/{id}";
	}
}

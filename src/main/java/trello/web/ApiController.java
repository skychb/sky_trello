package trello.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

@RestController
public class ApiController {
	@RequestMapping("/info")
	public Map<String, Object> info(HttpServletRequest req){
		Map<String, Object> infos = Maps.newHashMap();
		infos.put("port", req.getServerPort());
		return infos;
	}
}

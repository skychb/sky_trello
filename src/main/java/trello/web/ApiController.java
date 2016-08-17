package trello.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

@RequestMapping("/info")
@RestController
public class ApiController {
	public Map<String, Object> info(HttpServletRequest req){
		Map<String, Object> info = Maps.newHashMap();
		info.put("port", req.getServerPort());
		return info;
	}
}

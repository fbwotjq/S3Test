package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired S3Wrapper s3Wrapper;
	
	@GetMapping("/")
	@ResponseBody public Map<String, Object> home() {
		Map<String, Object> map = new HashMap<>();
		map.put("result", s3Wrapper.list());
		return map;
	}
	
}

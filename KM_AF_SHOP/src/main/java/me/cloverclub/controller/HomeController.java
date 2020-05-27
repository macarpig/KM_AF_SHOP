package me.cloverclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	@GetMapping("/")
	public String getIndex() {
		log.info("getIndex()");
		
		return "index";
	}
	
}
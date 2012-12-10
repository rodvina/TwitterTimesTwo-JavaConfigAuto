package com.habuma.ttt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//TODO:  RO - add this to a new DweetController
//@Controller
public class AddDweetController {

	private final DweetRepository dweetRepository;

	public AddDweetController(DweetRepository dweetRepository) {
		this.dweetRepository = dweetRepository;
	}
	
	@RequestMapping(value="/dweets", method=RequestMethod.POST)
	public String addDweet(String message) {
		dweetRepository.saveDweet(message);
		return "redirect:/dweets";
	}
	
}

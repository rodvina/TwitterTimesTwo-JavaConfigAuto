package com.habuma.ttt;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//TODO:  RO - add this to a new DweetController
//@Controller
public class DweetListController {

	private final DweetRepository dweetRepository;

	public DweetListController(DweetRepository dweetRepository) {
		this.dweetRepository = dweetRepository;
	}
	
	@RequestMapping(value="/dweets", method=RequestMethod.GET)
	public String showDweets(Model model) {
		List<Dweet> recentDweets = dweetRepository.findRecentDweets();
		model.addAttribute(recentDweets);
		return "dweetList";
	}
	
}

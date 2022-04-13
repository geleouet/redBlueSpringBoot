package me.egaetan.redblue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBlueController {

	@Autowired
	RedBlueService service;
	
	@GetMapping("/red")
	public RedBlueResponse red() {
		service.increment(true);
		return new RedBlueResponse(service.score());
	}

	@GetMapping("/blue")
	public RedBlueResponse blue() {
		service.increment(false);
		return new RedBlueResponse(service.score());
	}

	@GetMapping("/reset")
	public RedBlueResponse reset() {
		service.reset();
		return new RedBlueResponse(service.score());
	}
	
}

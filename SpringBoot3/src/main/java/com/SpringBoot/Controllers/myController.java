package com.SpringBoot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {
	@GetMapping("/")
	@ResponseBody
	public String getMessage() {
		return "Hello Spring";
	}

}

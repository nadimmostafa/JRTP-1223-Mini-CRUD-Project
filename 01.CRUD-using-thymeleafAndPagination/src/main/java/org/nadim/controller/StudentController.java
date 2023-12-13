package org.nadim.controller;

import org.nadim.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	// show register page
	
	//@RequestMapping(value = "/show", method = RequestMethod.GET)
	@GetMapping("/show")
	public String loadRegisterPage() {
		return "StudentRegister";
	}
}

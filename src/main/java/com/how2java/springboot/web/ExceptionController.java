package com.how2java.springboot.web;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	@RequestMapping("/exception")
	public String exception(Model m) throws Exception {
		m.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
        throw new Exception("some exception");
	}
}

package com.how2java.springboot.web;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloJspController {

	@RequestMapping("hellojsp")
	public String hello(Model m) {
		m.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
		return "hello";
	}
}

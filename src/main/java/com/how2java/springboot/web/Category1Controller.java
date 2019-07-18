package com.how2java.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.springboot.mapper.Category1Mapper;
import com.how2java.springboot.mapper.Category2Mapper;
import com.how2java.springboot.pojo.Category1;

@Controller
public class Category1Controller {
	//mybatis 注解方式
	@Autowired Category1Mapper category1Mapper;
	
	//mybatis xml配置
	@Autowired Category2Mapper category2Mapper;
	
	@RequestMapping("/listCategory1")
	public String listCategory(Model m) {
//		List<Category1> cs = category1Mapper.findAll();
		List<Category1> cs = category2Mapper.findAll();
		
		m.addAttribute("cs", cs);
        
        return "listCategory";
	}
	
}

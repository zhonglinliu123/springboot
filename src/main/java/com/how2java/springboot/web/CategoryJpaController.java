package com.how2java.springboot.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.CategoryJpa;

@Controller
public class CategoryJpaController {   //JPA
	@Autowired CategoryDAO categoryDAO;
	
	@RequestMapping("/listCategoryJpa")
	public String listCategory(Model m) {
		List<CategoryJpa> cs = categoryDAO.findAll();
		
		m.addAttribute("cs",cs);
		
		return "listCategory";
	}
	
	//分页
	@RequestMapping("/listCategoryJpaFenye")
	public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		start = start<0?0:start;
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page<CategoryJpa> page =categoryDAO.findAll(pageable);
		m.addAttribute("page", page);
	    return "listCategoryJpaFenye";
	}
	
	@RequestMapping("/addCategoryJpa")
	public String addCategory(CategoryJpa c) {
		categoryDAO.save(c);
		return "redirect:listCategoryJpaFenye";
	}
	
	@RequestMapping("/deleteCategoryJpa")
	public String deleteCategory(CategoryJpa c) {
		categoryDAO.delete(c);
		return "redirect:listCategoryJpaFenye";
	}
	
	@RequestMapping("/updateCategoryJpa")
	public String updateCategory(CategoryJpa c) {
		categoryDAO.save(c);
		return "redirect:listCategoryJpaFenye";
	}
	
	@RequestMapping("/editCategoryJpa")
	public String editCategory(int id,Model m) {
		CategoryJpa c = categoryDAO.getOne(id);
		m.addAttribute("c", c);
		return "editCategory";
	}
}

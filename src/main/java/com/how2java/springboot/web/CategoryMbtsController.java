package com.how2java.springboot.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMbts1Mapper;
import com.how2java.springboot.mapper.CategoryMbts2Mapper;
import com.how2java.springboot.pojo.CategoryMbts;

@Controller
public class CategoryMbtsController {
	//mybatis 注解方式
	@Autowired CategoryMbts1Mapper categoryMbts1Mapper;
	
	//mybatis xml配置
	@Autowired CategoryMbts2Mapper categoryMbts2Mapper;
	
	@RequestMapping("/listCategoryMbts")
	public String listCategory(Model m) {
//		List<CategoryMbts> cs = categoryMbts1Mapper.findAll();
		List<CategoryMbts> cs = categoryMbts2Mapper.findAll();
		
		m.addAttribute("cs", cs);
        
        return "listCategory";
	}
	
	// mybatis分页
	@RequestMapping("/listCategoryMbtsFenye")
	public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
	    PageHelper.startPage(start,size,"id desc");
	    List<CategoryMbts> cs=categoryMbts1Mapper.findAll();
	    PageInfo<CategoryMbts> page = new PageInfo<>(cs);
	    m.addAttribute("page", page);         
	    return "listCategoryMbtsFenye";
	}
	
	@RequestMapping("/addCategoryMbts")
	public String listCategory(CategoryMbts c) {
		categoryMbts1Mapper.save(c);
		return "redirect:listCategoryMbtsFenye";
	}
	
	@RequestMapping("/deleteCategoryMbts")
	public String deleteCategory(CategoryMbts c) {
		categoryMbts1Mapper.delete(c.getId());
		return "redirect:listCategoryMbtsFenye";
	}
	
	@RequestMapping("/updateCategoryMbts")
	public String updateCategory(CategoryMbts c) {
		categoryMbts1Mapper.update(c);
		return "redirect:listCategoryMbtsFenye";
	}
	
	@RequestMapping("/editCategoryMbts")
	public String listCategory(int id,Model m) {
		CategoryMbts c= categoryMbts1Mapper.get(id);
		m.addAttribute("c", c);
		return "editCategory";
	}
}

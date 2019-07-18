package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.how2java.springboot.pojo.Category1;

@Mapper
public interface Category1Mapper {
	
	@Select("select * from category_ ")
	List<Category1> findAll();
}

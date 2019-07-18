package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.how2java.springboot.pojo.Category1;

@Mapper
public interface Category2Mapper {

	List<Category1> findAll();
}

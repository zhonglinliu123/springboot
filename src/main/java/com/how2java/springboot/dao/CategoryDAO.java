package com.how2java.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.how2java.springboot.pojo.CategoryJpa;

public interface CategoryDAO extends JpaRepository<CategoryJpa,Integer>{

}

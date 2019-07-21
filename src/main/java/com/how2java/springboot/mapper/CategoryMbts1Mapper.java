package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.how2java.springboot.pojo.CategoryMbts;

@Mapper
public interface CategoryMbts1Mapper {
	
	@Select("select * from category_ ")
	List<CategoryMbts> findAll();
	
	@Insert(" insert into category_ ( name ) values (#{name}) ")
    public int save(CategoryMbts category); 
     
    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);
         
    @Select("select * from category_ where id= #{id} ")
    public CategoryMbts get(int id);
       
    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(CategoryMbts category); 
}

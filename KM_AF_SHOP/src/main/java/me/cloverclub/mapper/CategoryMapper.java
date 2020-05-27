package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.CategoryVO;

public interface CategoryMapper {
	
	 //카테고리
	public List<CategoryVO> category() throws Exception;

}

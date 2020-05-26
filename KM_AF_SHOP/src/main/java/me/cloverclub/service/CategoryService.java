package me.cloverclub.service;

import java.util.List;

import me.cloverclub.vo.CategoryVO;

public interface CategoryService {
	
	//카테고리
	public List<CategoryVO> category() throws Exception;
}

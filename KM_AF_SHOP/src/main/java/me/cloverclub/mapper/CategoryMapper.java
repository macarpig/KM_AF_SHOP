package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.CategoryVO;

public interface CategoryMapper {
	
	 //ī�װ�
	public List<CategoryVO> category() throws Exception;
	
	//1차분류 추가
	public void addCate1(CategoryVO category) throws Exception;
	
	//2차분류 추가
	public void addCate2(CategoryVO category) throws Exception;
}

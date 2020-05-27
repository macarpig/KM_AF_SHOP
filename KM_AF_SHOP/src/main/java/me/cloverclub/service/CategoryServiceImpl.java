package me.cloverclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.CategoryMapper;
import me.cloverclub.vo.CategoryVO;

@Log4j
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private CategoryMapper mapper;


	@Override
	public List<CategoryVO> category() throws Exception {

		return mapper.category();
	}
}

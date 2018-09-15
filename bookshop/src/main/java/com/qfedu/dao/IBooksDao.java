package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.Books;

public interface IBooksDao {

	public List<Books> findAll();
	
	public int count();
	
	// 分页查询
	public List<Books> findByIndexAndSize(Map<String, Object> info);
	
	public Books findById(int bid);
	
	public void update(Books books);
}

package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.Books;
import com.qfedu.vo.PageBean;

public interface IBooksService {

	public List<Books> findAll();
	
	public PageBean<Books> findEmpByPage(int page);
	
	public Books findById(int id);
	
	public void update(Books books);
}

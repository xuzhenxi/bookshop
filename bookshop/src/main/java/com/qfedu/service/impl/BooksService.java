package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.IBooksDao;
import com.qfedu.entity.Books;
import com.qfedu.service.IBooksService;
import com.qfedu.vo.PageBean;

@Service
public class BooksService implements IBooksService{

	@Autowired
	IBooksDao booksDao;
	
	@Override
	public List<Books> findAll() {
		List<Books> list = null;
		
		try {
			list = booksDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public PageBean<Books> findEmpByPage(int page) {
		// TODO Auto-generated method stub
		System.out.println("kkkkkkk");
		PageBean<Books> pageInfo = new PageBean<>();
		
		pageInfo.setCurrentPage(page);
		
		// 获取表中的记录总数
		int count = booksDao.count();
		// 计算总页数
		if(count % pageInfo.getPageSize() == 0){
			pageInfo.setTotalPage(count / pageInfo.getPageSize());
		}else{
			pageInfo.setTotalPage(count / pageInfo.getPageSize()+ 1);
		}
		// 根据页码计算分页查询时的开始索引
		int index = (page - 1) * pageInfo.getPageSize();
		Map<String, Object> map = new HashMap<>();
		map.put("index", index);
		map.put("size", pageInfo.getPageSize());
		List<Books> list = booksDao.findByIndexAndSize(map);
		pageInfo.setPageInfos(list);
		
		return pageInfo;
	}

	@Override
	public Books findById(int id) {
		
		Books books = null;
		try {
			books = booksDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}

	@Override
	public void update(Books books) {
		
		if (books == null) {
			throw new RuntimeException("输入图书为空，修改失败");
		}
		
		try {
			booksDao.update(books);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

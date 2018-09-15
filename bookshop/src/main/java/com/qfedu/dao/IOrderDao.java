package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.Books;
import com.qfedu.entity.Order;

public interface IOrderDao {

	public void add(Order order);
	
	public int count();
	
	// 分页查询
	public List<Order> findByIndexAndSize(Map<String, Object> info);
	
	public List<Order> findByUserName(String userName);
}

package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.Order;
import com.qfedu.vo.PageBean;

public interface IOrderService {

	public void add(Order order);
	
	public PageBean<Order> findOrderByPage(int page);
	
	public List<Order> findByUserName(String userName);
}

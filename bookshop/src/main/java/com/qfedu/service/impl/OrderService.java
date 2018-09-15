package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.qfedu.dao.IOrderDao;
import com.qfedu.entity.Books;
import com.qfedu.entity.Order;
import com.qfedu.service.IOrderService;
import com.qfedu.vo.PageBean;

@Controller
public class OrderService implements IOrderService{

	
	@Autowired
	IOrderDao orderDao;
	
	@Override
	public void add(Order order) {

		if (order == null) {
			throw new RuntimeException("订单为空，添加失败");
		}
		
		try {
			orderDao.add(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public PageBean<Order> findOrderByPage(int page) {
		// TODO Auto-generated method stub
		System.out.println("kkkkkkk");
		PageBean<Order> pageInfo = new PageBean<>();
		
		pageInfo.setCurrentPage(page);
		
		// 获取表中的记录总数
		int count = orderDao.count();
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
		List<Order> list = orderDao.findByIndexAndSize(map);
		pageInfo.setPageInfos(list);
		
		return pageInfo;
	}


	@Override
	public List<Order> findByUserName(String userName) {
		List<Order> list = null;
		
		try {
			list = orderDao.findByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}

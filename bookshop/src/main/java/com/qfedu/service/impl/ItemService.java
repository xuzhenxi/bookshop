package com.qfedu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.IItemsDao;
import com.qfedu.entity.Items;
import com.qfedu.service.IItemsService;

@Service
public class ItemService implements IItemsService{

	@Autowired
	IItemsDao itemDao;
	
	@Override
	public void add(Items items) {

		if (items == null) {
			throw new RuntimeException("购物车为空，添加失败");
		}
		
		try {
			itemDao.add(items);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Items findByBidAndUserName(Map<String, Object> map) {
		Items items = null;
		
		try {
			items = itemDao.findByBidAndUserName(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	}

	@Override
	public void update(Items items) {
		if (items == null) {
			throw new RuntimeException("购物车为空，添加失败");
		}
		
		try {
			itemDao.update(items);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Items> findByUserName(String userName) {

		List<Items> list = null;
		
		try {
			list= itemDao.findByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return list;
	}

	@Override
	public Items findByIid(int iid) {
		Items items = null;
		
		try {
			items = itemDao.findByIid(iid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	}

}

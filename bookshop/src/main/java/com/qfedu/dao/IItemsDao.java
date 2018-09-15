package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.Items;

public interface IItemsDao {

	public void add(Items item);
	
	public Items findByIid(int iid);
	
	public Items findByBidAndUserName(Map<String, Object> map);
	
	public void update(Items items);
	
	public List<Items> findByUserName(String userName);
}

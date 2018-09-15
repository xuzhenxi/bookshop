package com.qfedu.service;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.Items;

public interface IItemsService {

	public void add(Items items);
	
	public Items findByBidAndUserName(Map<String, Object> map);
	
	public void update(Items items);
	
	public List<Items> findByUserName(String userName);
	
	public Items findByIid(int iid); 
}

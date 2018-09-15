package com.qfedu.dao;

import java.util.List;

import com.qfedu.entity.Resources;



public interface IResourcesDao {

	
	public List<Resources> findByUname(String uname);

	public List<String> findRoleByUname(String uname);
	
	public List<String> findPermitByUname(String uname);
}

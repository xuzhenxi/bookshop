package com.qfedu.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {

	private Integer oid;
	private String userName;
	private Date ocreateDate;
	private float money;
	private Integer ostatus;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
	public Date getOcreateDate() {
		return ocreateDate;
	}
	public void setOcreateDate(Date ocreateDate) {
		this.ocreateDate = ocreateDate;
	}
	
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Integer getOstatus() {
		return ostatus;
	}
	public void setOstatus(Integer ostatus) {
		this.ostatus = ostatus;
	}
	List<Items> items;
	
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

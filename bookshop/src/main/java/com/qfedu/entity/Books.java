package com.qfedu.entity;

public class Books {
	private Integer bid;
	private String bookName;
	private float b_price;
	private String image;
	private Integer stock;
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getB_price() {
		return b_price;
	}
	public void setB_price(float b_price) {
		this.b_price = b_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}

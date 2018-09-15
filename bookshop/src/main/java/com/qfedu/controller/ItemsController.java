package com.qfedu.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.entity.Books;
import com.qfedu.entity.Items;
import com.qfedu.service.IBooksService;
import com.qfedu.service.IItemsService;
import com.qfedu.util.JsonUtil;
import com.qfedu.vo.JsonBean;

@Controller
public class ItemsController {

	@Autowired
	IItemsService itemService;
	
	@Autowired
	IBooksService booksService;
	
	@RequestMapping("/addItems")
	public String addItems(Integer[] bid, HttpSession session) {
		Items items = null;
		Books books = new Books();
		String userName = (String) session.getAttribute("userName");
		for (Integer id : bid) {
			Map<String, Object> map = new HashMap<>();
			map.put("bid", id);
			map.put("userName", userName);
			items = itemService.findByBidAndUserName(map);
			
			books = booksService.findById(id);
			
			//通过商品id和
			if (items != null) {
				items.setCount(items.getCount() + 1);
				items.setPrice(books.getB_price());
				items.setTotal_price(items.getCount() * items.getPrice());
				itemService.update(items);
			} else {
				items = new Items();
				
				
				items.setState(0);
				items.setUserName(userName);
				items.setBooks(books);
				items.setPrice(books.getB_price());
				items.setCount(1);
				items.setTotal_price(books.getB_price());
				items.setCreateDate(new Date());
				itemService.add(items);
			}
		}
			
		try {
			return "redirect:/shopping.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/index.html";
		}
	}
	
	
	@RequestMapping("/findUserCart")
	@ResponseBody
	public JsonBean findUserCart(HttpSession session) {
	
		List<Items> list = new ArrayList<Items>();
		String userName = (String) session.getAttribute("userName");
		
		try {
			list = itemService.findByUserName(userName);
			return JsonUtil.JsonBeanS(1, list);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.JsonBeanS(0, e.getMessage());
		}
		
	}
	
	
	
	
}

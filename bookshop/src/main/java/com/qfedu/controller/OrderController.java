package com.qfedu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.entity.Books;
import com.qfedu.entity.Items;
import com.qfedu.entity.Order;
import com.qfedu.service.IBooksService;
import com.qfedu.service.IItemsService;
import com.qfedu.service.IOrderService;
import com.qfedu.util.JsonUtil;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.PageBean;

@Controller
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IItemsService itemsService;
	
	@Autowired
	IBooksService booksService;
	
	@RequestMapping("/addOrder")
	public String add(Integer[] iid, Integer[] count, HttpSession session) {
		
		Order order = new Order();
		String userName = (String) session.getAttribute("userName");
		Integer money = 0;
		for (int i = 0; i < iid.length; i++) {
			Items it = itemsService.findByIid(iid[i]);
			 money +=  (int)it.getPrice() * count[i];
		}
		
		order.setUserName(userName);
		order.setMoney(money);
		order.setOstatus(1);
		order.setOcreateDate(new Date());
		
		try {
			//添加订单
			orderService.add(order);
			
			Items items = null;
			Books books = null;
			//获取订单id
			int oid = order.getOid();
			for (Integer i : iid) {
				//获取要结算的购物车
				items = itemsService.findByIid(i);
				//获取购物车中的商品
				books = booksService.findById(items.getBooks().getBid());
				if(books.getStock() - items.getCount() < 0) {
					return "redirect:/error.html";
				}
				
				items.setOid(oid);
				items.setCreateDate(new Date());
				items.setState(1);
				//修改购物车（添加订单id、修改订单生成时间、修改购物车状态为已结算状态1）
				itemsService.update(items);
				
				books.setStock(books.getStock() - items.getCount());
				//修改商品库存
				booksService.update(books);
			}
			
			return "redirect:/shopping-success.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/shopping.html";
		}
		
		
	}
	
	@RequestMapping("findOrderByUserName")
	@ResponseBody
	public JsonBean findOrderByUserName(HttpSession session) {
		
		List<Order> info = null;
				
		String userName = (String) session.getAttribute("userName");
		try {
			info = orderService.findByUserName(userName);
			return JsonUtil.JsonBeanS(1, info);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.JsonBeanS(0, e.getMessage());
		}

	}
	

}

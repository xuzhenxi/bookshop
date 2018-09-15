package com.qfedu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.entity.Books;
import com.qfedu.service.IBooksService;
import com.qfedu.util.JsonUtil;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.PageBean;

@Controller
public class BooksController {

	@Autowired
	IBooksService bookService;
	
	@RequestMapping("/index")
	public String first() {
		return "index";
	}
	
	@RequestMapping("/findAllBooks")
	@ResponseBody
	public JsonBean findAll() {
		List<Books> list = null;
		try {
			list = bookService.findAll();
			return JsonUtil.JsonBeanS(1, list);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.JsonBeanS(0, e.getMessage());
			
		}
		
	}
	
	@RequestMapping("/findBooksByPage")
	@ResponseBody
	public JsonBean findByIndexAndSize(int page) {
		PageBean<Books> list = null;
		try {
			list = bookService.findEmpByPage(page);
			return JsonUtil.JsonBeanS(1, list);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.JsonBeanS(0, e.getMessage());
			
		}
		
	}
}

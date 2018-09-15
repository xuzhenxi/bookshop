package com.qfedu.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

// 将请求参数中日期字符串，转为Date对象
// 泛型中的第一个参数，表示要处理的字符串，第二个参数，表示要转换到的类型
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		
		if (source == null || source.isEmpty()) {
			return null;
		}
	   
		SimpleDateFormat[] sdfs = new SimpleDateFormat[] {
				new SimpleDateFormat("YYYY-MM-dd"),
				new SimpleDateFormat("YYYY/MM/dd"),
				new SimpleDateFormat("YYYYMMdd"),
				new SimpleDateFormat("YYYY.MM.dd"),
		};
		
		for (SimpleDateFormat sdf : sdfs) {
			
			//受检异常
			try {
				return sdf.parse(source);
			} catch (java.text.ParseException e) {
				continue;
			}
		}
		
		return null;
	}

}

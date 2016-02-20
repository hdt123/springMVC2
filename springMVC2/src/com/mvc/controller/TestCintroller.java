package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp/*")
public class TestCintroller {

	@RequestMapping("/test.do")
	public String test(){
		
		System.out.println("======");
		return "/index";
	}
}

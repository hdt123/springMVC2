package com.mvc.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.entity.User;
import com.mvc.service.UserService;
import com.mvc.util.ImageUtil;
import com.mvc.util.JsonUtils;


@Controller
public class LoginController{

	@Resource
	private UserService userService;
	
	@RequestMapping("/createImage.do")
	public void createImage(
			HttpServletResponse response, HttpSession session)
			throws Exception {
		
		User u = userService.findById(1);
		System.out.println(u.getUsername());
		Map<String, BufferedImage> imageMap = ImageUtil.createImage();
		String code = imageMap.keySet().iterator().next();
		session.setAttribute("imageCode", code);
		
		BufferedImage image = imageMap.get(code);
		
		response.setContentType("image/jpeg");
		OutputStream ops = response.getOutputStream();
		ImageIO.write(image, "jpeg", ops);
		ops.close();
	}
	
	@RequestMapping("/login.do")
	@ResponseBody	
	public String login(String adminCode,String password,String code,HttpSession session){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		String imageCode = (String) session.getAttribute("imageCode");
		String str = "admin";
		if(!(str.equals(adminCode))){
			map.put("flag", 1);
			return JsonUtils.map2json(map);
		}
		else if (!(str.equals(password))){
			map.put("flag", 2);
			return JsonUtils.map2json(map);
		}
		
		else if(code==null||!code.equalsIgnoreCase(imageCode)){
			map.put("flag", 3);
			return JsonUtils.map2json(map);
		}else{
			map.put("flag", 0);
			return JsonUtils.map2json(map);
		}
	}
	
}

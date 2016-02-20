package com.mvc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;



public class JsonUtils {
	
	
public static Gson gson = new Gson();

	public static Map<String,Integer> mapFromJson(String json){
		
		return gson.fromJson(json, new TypeToken<Map<String,Integer>>(){}.getType());
	}
	
	
	
	public static String map2json(Map<String, Object> map){
		if(map.size() == 0){
			return null;
		}
		return gson.toJson(map);
		
	}
	
	public static String obj2Json(Object obj){		
		String json = gson.toJson(obj);
		return json;		
	}
	


	public static List<String> picListfromjson(String json){
		
	/*	System.out.println("json:"+json);*/
		List<String> list;
		try {
			list = gson.fromJson(json, List.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
		
		
	}

	

	
}

package com.qa.util;

import com.google.gson.Gson;

public class JSONUtil {
	//GSON  library used to convert objects to json vice/versa
	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) 
	{//converts object to JSON
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) 
	{//converts JSON to object		
		return gson.fromJson(jsonString, clazz);
		
	}

}
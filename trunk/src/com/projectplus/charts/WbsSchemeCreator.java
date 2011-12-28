package com.projectplus.charts;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WbsSchemeCreator {
	
	/**
	 * 建構WbsTree的JSON字串
	 * @param elements
	 * @return
	 */
	public static String createWbsTree(ArrayList<WbsScheme> elements){
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		return gson.toJson(elements);
		
	}
	
	/**
	 * 建構WbsScheme
	 * @param level : 該節點階層
	 * @param name : 該節點名稱 
	 * @param descript : 該節點描述
	 * @return WbsScheme節點
	 */
	public static WbsScheme createWbsScheme(String parent ,int level, String name, String descript){
		
		WbsScheme wbsScheme = new WbsScheme();
		wbsScheme.parent = parent;
		wbsScheme.name = name;
		wbsScheme.descript = descript;
		wbsScheme.level = level;
		return wbsScheme;
		
	}
}

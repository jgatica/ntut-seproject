package com.seproject.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONWriter {

	/**
	 * 傳送JSON格式資料到Comet伺服器
	 * @param outputStream : 輸出到伺服器的流
	 * @param result ： 輸出物件
	 * @throws IOException
	 */
	public static void sendJSONRequest(OutputStream outputStream, Object result)
			throws IOException {

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String jsonstr = gson.toJson(result);
		BufferedOutputStream out = new BufferedOutputStream(outputStream, 1024 * 8);
		out.write(jsonstr.getBytes());
		out.flush();
		out.close();
		
	}
	
}

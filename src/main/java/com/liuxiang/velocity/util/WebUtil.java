package com.liuxiang.velocity.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.liuxiang.velocity.filter.ActionFilter;

public class WebUtil {
	
	public static void sendResponseObject(Object object) {
		PrintWriter writer = getResponseWriter();
		writer.write(JSON.toJSONString(object));
		writer.close();
	}
	
	public static void sendResponseArray(Object array) {
		PrintWriter writer = getResponseWriter();
		writer.write(JSON.toJSONString(array));
		writer.close();
	}
	
	public static void sendMessage(String message) {
		PrintWriter writer = getResponseWriter();
		writer.write(message);
		writer.close();
	}
	private static PrintWriter getResponseWriter() {
		try {
			HttpServletResponse response = (HttpServletResponse) ActionFilter.threadLocalResponse.get();
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			return response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

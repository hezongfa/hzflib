package com.hzf.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.hzf.utils.print.FQL;

public class JsonExplain {

	public static <T> List<T> explainListJson(String josnData, Class<T[]> clazz) {
		try {
			T[] arr = new Gson().fromJson(josnData, clazz);
			return Arrays.asList(arr);
		} catch (Exception e) {
			FQL.e(e.toString());
			return new ArrayList<T>();
		}
		// or return Arrays.asList(new
		// Gson().fromJson(s, clazz)); for a
		// one-liner
	}

	public static <T> Object explainJson(String jsonData, Class<T> c) {
		Gson gson = new Gson();
		Object obj = gson.fromJson(jsonData, c);
		return obj;
	}

	/**
	 * JSon数据解析
	 * 
	 * @param josnData
	 * @param key
	 * @return
	 */
	public static String getStringValue(String response, String key) {

		try {
			JSONObject ob = new JSONObject(response);
			String value = ob.getString(key);
			if ("null".equals(value)) {
				value = "";
			}
			return value;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			FQL.e(e.toString());
			return "";
		}
	}

	/**
	 * JSon数据解析
	 * 
	 * @param josnData
	 * @param key
	 * @return
	 */
	public static Integer getIntValue(String response, String key) {

		try {
			JSONObject ob = new JSONObject(response);
			int value = ob.getInt(key);
			return value;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			FQL.e(e.toString());
			return -1;
		}
	}

	/**
	 * JSon数据解析
	 * 
	 * @param josnData
	 * @param key
	 * @return
	 */
	public static Long getLongValue(String response, String key) {

		try {
			JSONObject ob = new JSONObject(response);
			return ob.getLong(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			FQL.e(e.toString());
			return -1l;
		}
	}

	/**
	 * JSon数据解析
	 * 
	 * @param josnData
	 * @param key
	 * @return
	 */
	public static Double getDoubleValue(String response, String key) {

		try {
			JSONObject ob = new JSONObject(response);
			double value = ob.getDouble(key);
			return value;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			FQL.e(e.toString());
			return -1d;
		}
	}
}

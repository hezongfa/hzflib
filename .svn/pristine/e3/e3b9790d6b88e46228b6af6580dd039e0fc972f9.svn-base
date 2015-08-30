package com.hzf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.text.format.DateFormat;

public class DateUtil {
	/**
	 * 转换时间格式
	 * 
	 * @param timestamp
	 * @param format
	 *            MM-DD
	 * @return
	 */
	public static String getStringByFormat(long timestamp, String format) {
		// Log.d("getStandardTime", "getStandardTime-----" + timestamp);
		if (timestamp != 0)
			return DateFormat.format(format, timestamp).toString();
		return "";
	}

	/**
	 * 格式化时间转换为毫秒单位时间
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static long timeformat2million(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		long milliontime = -1l;
		try {
			long millionSeconds = sdf.parse(time).getTime();
			milliontime = millionSeconds;// 毫秒
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return milliontime;
	}

}

package com.hzf.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.content.Context;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import com.hzf.utils.print.FQL;

public class SysUtil {
	static String TAG = "SysUtil";

	public static String getIMEI(Context context) {
		String imei = "";
		TelephonyManager telephonemanage = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		try {
			// edit1.setText("MIEI: " + telephonemanage.getDeviceId()
			// + "\n SimSSN " + telephonemanage.getSimSerialNumber()
			// + "\n IMSI " + telephonemanage.getSubscriberId());

			imei = telephonemanage.getDeviceId();
			FQL.d(TAG, "getIMEI---IMEI=" + imei);
			if ("".equals(imei) || "Unknown".equals(imei) || "0".equals(imei)
					|| imei.length() < 15 || "000000000000000".equals(imei)) {
				imei = getLocalMacAddress(context);
			}
			return imei;
		} catch (Exception e) {
			imei = getLocalMacAddress(context);
			e.printStackTrace();
		}
		// L.d(TAG, "getIMEI---IMEI=" + imei);
		return imei;
	}

	public static String getLocalIpAddress() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						// L.d(TAG, "getLocalIpAddress---HostAddress="
						// + inetAddress.getHostAddress().toString());
						return inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (SocketException ex) {
			// Log.e("WifiPreference IpAddress", ex.toString());
		} catch (Exception ex) {
		}
		return "";
	}

	public static String getLocalMacAddress(Context context) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		// L.d(TAG, "getLocalMacAddress----MacAddress=" + info.getMacAddress());
		return info.getMacAddress();
	}

	public static String getProductModel() {
		try {
			// L.d(TAG, "getProductModel----�ֻ��ͺ�=" + android.os.Build.MODEL);
			return android.os.Build.MODEL;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String getProductVersion() {
		try {
			// L.d(TAG, "getProductVersion----�ֻ�sdk�汾="
			// + android.os.Build.VERSION.RELEASE);
			return android.os.Build.VERSION.RELEASE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static int getProductAPIVersion() {
		try {
			// L.d(TAG, "getProductAPIVersion----�ֻ�api�汾="
			// + android.os.Build.VERSION.SDK_INT);
			return android.os.Build.VERSION.SDK_INT;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public static SensorManager getSensorManager(Context context) {

		SensorManager sm = (SensorManager) context
				.getSystemService(Context.SENSOR_SERVICE);

		return sm;
	}

}

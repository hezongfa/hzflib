package com.hzf.utils.http;

import android.content.Context;

import com.hzf.utils.NetUtil;
import com.hzf.utils.print.FQT;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class HttpClient {
	private static HttpUtils mHttpUtils;
	private int connTimeout = 20000;
	String userAgent = "hzf";
	private static HttpClient mHttpClient;
	private Context context;

	public HttpClient(Context context) {
		mHttpUtils = new HttpUtils(connTimeout, userAgent);
		this.context = context;
	}

	public static HttpClient getInstance(Context context) {
		if (mHttpClient == null) {
			mHttpClient = new HttpClient(context);
		}
		return mHttpClient;
	}

	public void send(String url, RequestCallBack<String> callBack) {
		send(HttpRequest.HttpMethod.POST, url, new RequestParams(), callBack);
	}

	public void send(RequestParams params, String url,
			RequestCallBack<String> callBack) {
		send(HttpRequest.HttpMethod.POST, url, params, callBack);
	}

	private void send(HttpMethod mHttpMethod, String url, RequestParams params,
			RequestCallBack<String> callBack) {
		if (NetUtil.checkNetworkInfo(context)) {
			mHttpUtils.send(mHttpMethod, url, params, callBack);
		} else {
			FQT.showShort(context, "网络连接失败，请检查网络！");
		}
	}
}

package com.hzf.utils.encryption;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import android.util.Base64;

public class Base64Util {
	/**
	 * content参数先用Gzip进行字符串压缩,之后用Base64编码,最后用url进行编码
	 * 
	 * @param content
	 * @return
	 * @throws IOException
	 *             创建日期:2014年5月22日
	 */
	public static String compressBase64URLEncode(String content)
			throws IOException {
		content = (null == content) ? "" : content.trim();
		// 1.用Gzip进行字符串压缩
		// 压缩前:content={}
		byte[] gZip = GZip.gZip(content);
		// 2.用Base64编码
		// byte[] result = Base64.encodeBase64(gZip);
		byte[] result = Base64.encode(gZip, Base64.DEFAULT);
		// 3.用url进行编码
		String afterBase64 = new String(result);
		// 编码前afterUrlEncode=H4sIAAAAAAAAAKuuBQBDv6ajAgAAAA==
		String afterUrlEncode = URLEncoder.encode(afterBase64, "UTF-8"); // 采用UTF-8编码
		// 编码后afterUrlEncode=H4sIAAAAAAAAAKuuBQBDv6ajAgAAAA%3D%3D

		return afterUrlEncode;
	}

	/**
	 * 对内容进行url解码，反向Base64编码，解缩
	 * 
	 * @param content
	 * @return
	 * @throws IOException
	 *             创建日期:2014年5月22日
	 */
	public static String deCompressBase64URLEncode(String content)
			throws IOException {
		// 1.反url编码
		content = URLDecoder.decode(content, "UTF-8"); // 采用UTF-8编码
		// 2.反Base64编码
		// byte[] data = Base64.decodeBase64(content);
		byte[] data = Base64.decode(content, Base64.DEFAULT);
		// 3.反压缩
		content = new String(GZip.unGZip(data));

		return content;
	}

}

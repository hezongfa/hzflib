package com.hzf.utils.encryption;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZip {

	/**
	 * gZip压缩方法
	 * 
	 * @throws IOException
	 */
	public static byte[] gZip(String content) throws IOException {
		ByteArrayOutputStream gzipOut = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(gzipOut);
		gzip.write(content.getBytes());
		gzip.close();
		return gzipOut.toByteArray();
	}

	/**
	 * gZip解压方法
	 */
	public static byte[] unGZip(byte[] data) {
		byte[] b = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			GZIPInputStream gzip = new GZIPInputStream(bis);
			byte[] buf = new byte[1024];
			int num = -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((num = gzip.read(buf, 0, buf.length)) != -1) {
				baos.write(buf, 0, num);
			}
			b = baos.toByteArray();
			baos.flush();
			baos.close();
			gzip.close();
			bis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}
}

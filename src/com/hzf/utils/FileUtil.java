package com.hzf.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;

/**
 * 
 * FileUtil.java
 * 
 * @author zongfa_he
 * @version
 * @since 2014-7-15 下午7:42:46
 * @description 文件工具
 * 
 */
public class FileUtil {

	/**
	 * 删除文件或文件夹
	 * 
	 * @param file
	 */
	public static void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			} else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		} else {
			// L.d("deletefile", "文件不存在");
		}
	}

	/**
	 * 创建目录
	 * 
	 * @param file
	 */
	public static void mkFile(File file) {
		if (file.exists()) { // 判断文件是否存在
		} else {
			file.mkdirs();
		}
	}

	/**
	 * 保存图片
	 * 
	 * @param path
	 * @param fileName
	 * @param bitmap
	 */
	public static void saveFile(String path, String fileName, Bitmap bitmap) {

		try {
			File dirFile = new File(path);
			File saveimg = new File(path + fileName);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(saveimg));
			if (bitmap != null) {
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
			}
			bos.flush();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static File byte2File(byte[] bfile, String filePath,String fileName) {  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
            File dir = new File(filePath);  
            if(!dir.exists()){//判断文件目录是否存在  
                dir.mkdirs();  
            }  
            file = new File(filePath+fileName);  
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(bfile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bos != null) {  
                try {  
                    bos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        }  
        return file;
    }  
}

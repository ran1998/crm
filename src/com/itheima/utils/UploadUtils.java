package com.itheima.utils;

import java.util.UUID;

public class UploadUtils {
	/**
	 * get filename
	 * @param filename
	 * @return
	 */
	public static String getUuidFileName(String filename) {
		int idx = filename.lastIndexOf(".");
		String extension = filename.substring(idx);
		return UUID.randomUUID().toString().replace("-", "")+extension;
	}
	
	public static String getPathName(String uuidFileName) {
		int code1 = uuidFileName.hashCode();
		int d1 = code1 & 0xf;
		int code2 = code1 >>> 4;
		int d2 = code2 & 0xf; // 作为二级目录
		return "/"+d1+"/"+d2;
	}
	
	public static void main(String args[]) {
		System.out.println(getUuidFileName("1.jpg"));
	}
}

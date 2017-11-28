package kr.co.blueauction.product.util;

import java.io.File;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadImageUtil {
	
	public static Logger logger = LoggerFactory.getLogger(UploadImageUtil.class);
	
	public static String uploadImage(String uploadPath, String actualFileName, byte[] fileData) throws Exception {
		
		return null;
	}
	
	private static String makePath(String uploadPath) {
		
		Calendar calendar = Calendar.getInstance();
		
		String year = File.separator + Calendar.YEAR;
		
		return null;
	}
	
}

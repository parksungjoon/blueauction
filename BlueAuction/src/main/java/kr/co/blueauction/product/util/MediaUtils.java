package kr.co.blueauction.product.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

/**
 * 업로드 파일의 종류 판별을 위한 유틸 클래스
 * 
 * @author 최명승
 * @since 2017. 11. 21.
 */

public class MediaUtils {

private static Map<String, MediaType> mediaMap;
	
	static {
		
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
		
	}
	
	/**
	 * 업로드 파일이 이미지 파일인지 확인
	 * 
	 * @param type 업로드된 파일의 확장자
	 * @return 매개변수와 일치하는 값 / 일치하는 값이 없으면 NULL 리턴
	 */
	public static MediaType getMediaType(String type){
		return mediaMap.get(type.toUpperCase());
	}
	
}

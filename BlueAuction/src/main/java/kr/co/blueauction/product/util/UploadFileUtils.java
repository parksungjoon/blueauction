package kr.co.blueauction.product.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import kr.co.blueauction.product.util.MediaUtils;
import kr.co.blueauction.product.util.UploadFileUtils;

/**
 * 업로드 파일의 저장을 위한 유틸 클래스
 * 
 * @author 최명승
 * @since 2017. 11. 21.
 */

public class UploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	/**
	 * 업로드 파일 저장 및 썸네일 / 아이콘 생성
	 * 
	 * @param uploadPath 업로드된 파일이 저장될 기본 경로
	 * @param originalName 업로드된 파일의 이름
	 * @param fileData 업로드된 파일의 실제 바이너리 데이터
	 * @return 저장될 파일의 이름
	 * @throws Exception
	 */
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath + savedPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		
		String uploadedFileName = null;
		
		if (MediaUtils.getMediaType(formatName) != null) {
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		return uploadedFileName;
	}
	
	/**
	 * 업로드된 파일이 이미지가 아닐 경우 출력할 아이콘 생성
	 * 
	 * @param uploadPath 실제 파일이 저장될 기본 경로
	 * @param path 업로드된 파일이 저장될 날짜별 폴더 경로
	 * @param fileName 고유번호가 부가된 파일의 이름
	 * @return 아이콘 파일의 이름
	 * @throws Exception
	 */
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
		
		String iconName = uploadPath + path + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	/**
	 * 업로드 파일이 저장될 날짜별 폴더 경로 생성
	 * 
	 * @param uploadPath 파일이 실제 저장될 기본 경로
	 * @return 업로드 파일이 저장될 날짜별 폴더 경로
	 */
	private static String calcPath(String uploadPath) {
		
		Calendar calendar = Calendar.getInstance();
		
		String yearPath = File.separator + calendar.get(Calendar.YEAR);
		
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.MONTH ) + 1);
		
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}
	
	/**
	 * 업로드 파일이 저장될 디렉토리 생성
	 * 
	 * @param uploadPath 파일이 실제 저장될 기본 경로
	 * @param paths 업로드 파일이 저장될 날짜별 폴더 경로
	 */
	private static void makeDir(String uploadPath, String...paths) {
		
		if (new File(uploadPath + paths[paths.length -1]).exists()) {
			return;
		}
		
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if (! dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	
	/**
	 * 업로드된 이미지 파일의 썸네일 생성
	 * 
	 * @param uploadPath 파일이 실제 저장될 기본 경로
	 * @param path 업로드 파일이 저장될 날짜별 폴더 경로
	 * @param fileName 고유번호가 부가된 파일명
	 * @return 썸네일 이름
	 * @throws Exception
	 */
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		
		File newFile = new File(thumbnailName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
}

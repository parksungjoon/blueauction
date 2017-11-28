package kr.co.blueauction.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.blueauction.product.util.MediaUtils;
import kr.co.blueauction.product.util.UploadFileUtils;

@Controller
@RequestMapping("/product/attach/*")
public class UploadController {
	
	Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name = "uploadPath")
	private String uploadPath;
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		
		UUID uid = UUID.randomUUID(); // 중복 방지를 위한 고유 키값 생성
		
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ResponseEntity<String> uploadImages(MultipartFile file) throws Exception {
		
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		
		InputStream in = null;
		
		ResponseEntity<byte[]> entity = null;
		
		try {
		
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		MediaType mType = MediaUtils.getMediaType(formatName);
		
		HttpHeaders headers = new HttpHeaders();
		
		in = new FileInputStream(uploadPath + fileName);
		
		if (mType != null) {
			headers.setContentType(mType);
		} else {
			fileName = fileName.substring(fileName.indexOf("_") + 1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("utf-8"), "ISO-8859-1") + "\"");
		}
		
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {
		
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		MediaType mType = MediaUtils.getMediaType(formatName);
		
		if (mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}
		
		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteAllFiles", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files) {
		
		if (files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
		
		for (String fileName : files) {
			
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			if (mType != null) {
				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}
			
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		}
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
}

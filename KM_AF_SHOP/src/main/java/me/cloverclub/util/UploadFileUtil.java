package me.cloverclub.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtil {
	static final int THUMB_HEIGHT = 300;
	static final int THUMB_WIDTH = 300;
	
	public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception {
		UUID uuid = UUID.randomUUID();
		
		String newFileName = uuid + "_" + fileName;
		String imgPath = uploadPath + ymdPath;
		
		File target = new File(imgPath, newFileName);
		FileCopyUtils.copy(fileData, target);
		
		String thumbFileName = "s_" + newFileName;
		File image = new File(imgPath + File.separator + newFileName);
		
		File thumbnail = new File(imgPath + File.separator + "s" + File.separator + thumbFileName);
		
		if(image.exists()) {
			
		}
	}
}

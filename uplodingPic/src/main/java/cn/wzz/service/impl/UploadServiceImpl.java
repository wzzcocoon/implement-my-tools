package cn.wzz.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import cn.wzz.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	private Logger LOGGER = LoggerFactory.getLogger(UploadServiceImpl.class);
	
	@Value("${file.root.path}")
	private String rootPath;

	@Override
	public void processPic(MultipartFile[] fileUploads, String fileFolder, String chunk, String chunks) {
		for (MultipartFile fileUpload : fileUploads) {
			if (null != chunk && null != chunks) {
				String filePath = fileFolder + "/temp";
				String dirName = rootPath + filePath;
				File file = new File(dirName);
				InputStream inputStream = null;
				FileOutputStream outputStream = null;
				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					inputStream = fileUpload.getInputStream();
					outputStream = new FileOutputStream(dirName + "/" + fileUpload.getOriginalFilename() + "_" + chunk);
					byte[] buffer = new byte[1024 * 1024];
					int len = 0;
					while ((len = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, len);
						outputStream.flush();
					}
					outputStream.close();
					inputStream.close();
					
					if (Integer.valueOf(chunk) + 1 == Integer.valueOf(chunks)) {
						SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddhhmmss");
						String originalFilename = fileUpload.getOriginalFilename();
						String newFile = sFormat.format(Calendar.getInstance().getTime()) + new Random().nextInt(1000)
								+ originalFilename.substring(originalFilename.lastIndexOf("."));
						filePath = fileFolder + "/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
						File outDir = new File(rootPath + filePath);

						if (!outDir.exists()) {
							outDir.mkdirs();
						}
						for (int i = 0; i < Integer.valueOf(chunks); i++) {
							File temp = new File(dirName + "/" + fileUpload.getOriginalFilename() + "_" + i);
							FileCopyUtils.copy(new FileInputStream(temp),
									new FileOutputStream(rootPath + filePath + "/" + newFile, true));
							temp.delete();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			} else {
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddhhmmss");
				String fileName = sFormat.format(Calendar.getInstance().getTime()) + new Random().nextInt(1000);
				String originalFilename = fileUpload.getOriginalFilename();
				fileName += originalFilename.substring(originalFilename.lastIndexOf("."));
				String filePath = fileFolder + "/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
				String dirName = rootPath + filePath;
				LOGGER.info("<<<<<<<附件路径:{} >>>>>>>>", dirName);
				File file = new File(dirName);
				InputStream inputStream = null;
				FileOutputStream outputStream = null;
				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					inputStream = fileUpload.getInputStream();
					outputStream = new FileOutputStream(dirName + "/" + fileName);
					byte[] buffer = new byte[1024 * 1024];
					int len = 0;
					while ((len = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, len);
						outputStream.flush();
					}
					outputStream.close();
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}

		}
	}

}

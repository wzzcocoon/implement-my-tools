package cn.wzz.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {


	/**
	 * 上传多个附件
	 */
    void processPic(MultipartFile[] multipartFiles, String fileFolder, String chunk, String chunks);

}

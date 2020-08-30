package cn.wzz.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.wzz.bean.AuthorUser;
import cn.wzz.bean.ExcelEntity;

public interface UploadService {


	/**
	 * 上传多个附件
	 */
    void processPic(MultipartFile[] multipartFiles, String fileFolder, String chunk, String chunks);

    /**
     * 解析Excel，保存数据到数据库
     */
//    List<ExcelEntity> saveImport(MultipartFile file) throws IOException;
}

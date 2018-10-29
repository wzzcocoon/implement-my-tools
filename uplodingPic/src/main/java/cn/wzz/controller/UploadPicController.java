package cn.wzz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.wzz.service.UploadService;

@Controller
public class UploadPicController extends WebAction{
	
	private Logger LOGGER = LoggerFactory.getLogger(UploadPicController.class);
	
	@Autowired
	private UploadService uploadService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("uploadPic");
		return mv;
	}

	@RequestMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile[] multipartFiles, String chunk, String chunks) throws Exception {
		LOGGER.info("<<<<<<<<<<<<<<图片上传开始>>>>>>>>>>>");
		String folderName = request.getParameter("folderName");
		uploadService.processPic(multipartFiles,folderName,chunk,chunks);
		LOGGER.info("<<<<<<<<<<<<<<图片上传结束>>>>>>>>>>>");
	}
}

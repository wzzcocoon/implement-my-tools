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
public class UploadController extends WebAction{
	
	private Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
	
	@Autowired
	private UploadService uploadService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("upload");
		return mv;
	}

	@RequestMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile[] multipartFiles, String chunk, String chunks) throws Exception {
		LOGGER.info("<<<<<<<<<<<<<<附件上传开始>>>>>>>>>>>");
		String folderName = request.getParameter("folderName");
		uploadService.processPic(multipartFiles,folderName,chunk,chunks);
		LOGGER.info("<<<<<<<<<<<<<<附件上传结束>>>>>>>>>>>");
	}
	
	@RequestMapping("/success")
	public ModelAndView success() {
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}
}

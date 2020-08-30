package cn.wzz.controller.bigdata.upload.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class BigdataUploadController{
	
	

	@RequestMapping("/simple")
	public ModelAndView upload1() {
		ModelAndView mv = new ModelAndView("bigdata/simpleUpload");
		return mv;
	}
	
	@RequestMapping("/breakpoint")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("bigdata/upload");
		return mv;
	}

}

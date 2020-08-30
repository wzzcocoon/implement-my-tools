package cn.wzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import cn.wzz.controller.bigdata.upload.servlet.FileUploadServlet;
import cn.wzz.controller.bigdata.upload.servlet.UploadActionServlet;

@SpringBootApplication
public class UplodingPicApplication {

	public static void main(String[] args) {
		SpringApplication.run(UplodingPicApplication.class, args);
	}
	
	//定义servlet，注册
    @Bean
	public ServletRegistrationBean fileUploadServlet(){
		//指定访问的url
		return new ServletRegistrationBean(new FileUploadServlet(),"/FileUploadServlet");
	}
    
	@Bean
	public ServletRegistrationBean uploadActionServlet(){
		return new ServletRegistrationBean(new UploadActionServlet(),"/UploadActionServlet");
	}
	
}

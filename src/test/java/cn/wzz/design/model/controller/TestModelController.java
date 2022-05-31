package cn.wzz.design.model.controller;

import cn.wzz.design.model.service.AliAppService;
import cn.wzz.design.model.service.AliMiniService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestModelController {

    @Resource
    private AliMiniService aliMiniService;

    @Resource
    private AliAppService aliAppService;


    @RequestMapping("/ali-query")
    public String query(){

        aliMiniService.uniQuery();

        System.out.println("======");

        aliAppService.uniQuery();
        return "1";
    }

}

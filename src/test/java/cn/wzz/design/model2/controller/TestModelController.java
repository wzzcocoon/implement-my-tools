package cn.wzz.design.model2.controller;

import cn.wzz.design.model2.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController("TestModelController2")
public class TestModelController {

    @Resource
    private Map<String, BaseService> baseServiceMap;


    @RequestMapping("/ali-query2")
    public String query(){

        BaseService aliMiniService = baseServiceMap.get("PRODUCT-MINI");
        aliMiniService.uniQuery();

        System.out.println("======");

        BaseService aliAppService = baseServiceMap.get("PRODUCT-APP");
        aliAppService.uniQuery();
        return "1";
    }

}

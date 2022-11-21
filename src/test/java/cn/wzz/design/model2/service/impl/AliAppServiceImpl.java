package cn.wzz.design.model2.service.impl;

import org.springframework.stereotype.Service;

@Service("PRODUCT-APP")
public class AliAppServiceImpl extends AbstractBase{

    @Override
    public void query() {
        System.out.println("aliApp 方法 -- 执行");
    }

}

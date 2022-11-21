package cn.wzz.design.model2.service.impl;

import org.springframework.stereotype.Service;

@Service("PRODUCT-MINI")
public class AliMiniServiceImpl extends AbstractBase {

    @Override
    void query() {
        System.out.println("aliMini 方法 -- 执行");
    }
}

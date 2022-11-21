package cn.wzz.design.model.service.impl;

import cn.wzz.design.model.service.AliAppService;
import org.springframework.stereotype.Service;

@Service
public class AliAppServiceImpl extends BaseServiceImpl implements AliAppService {

    @Override
    public void query() {
        System.out.println("aliApp 方法 -- 执行");
    }

}

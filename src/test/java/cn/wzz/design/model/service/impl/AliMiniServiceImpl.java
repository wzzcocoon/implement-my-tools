package cn.wzz.design.model.service.impl;

import cn.wzz.design.model.service.AliMiniService;
import org.springframework.stereotype.Service;

@Service
public class AliMiniServiceImpl extends BaseServiceImpl implements AliMiniService {

    @Override
    public void query() {
        System.out.println("aliMini 方法 -- 执行");
    }
}

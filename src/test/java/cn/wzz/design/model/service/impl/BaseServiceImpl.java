package cn.wzz.design.model.service.impl;

import cn.wzz.design.model.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    public void uniQuery() {
        System.out.println("Base uni方法 -- 开始");
        query();
        System.out.println("Base uni方法 -- 结束");
    }

    protected void query() {
        System.out.println("Base 方法 -- 执行");
    }

}

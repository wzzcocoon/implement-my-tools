package cn.wzz.design.model2.service.impl;


import cn.wzz.design.model2.dao.DaoService;
import cn.wzz.design.model2.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public abstract class AbstractBase implements BaseService {

    @Resource
    private DaoService daoService;

    abstract void query();

    @Override
    public void uniQuery(){
        System.out.println("uni方法 -- 开始");
        query();
        daoService.select();
        System.out.println("uni方法 -- 结束");
    }

}

package cn.wzz.design.model2.dao;

import org.springframework.stereotype.Service;

@Service
public class DaoServiceImpl implements DaoService {

    @Override
    public void select() {
        System.out.println("dao select");
    }

}

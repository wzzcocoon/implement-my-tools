package cn.wzz.interview2021.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class BImpl implements B{

    @Autowired
    A a;

}

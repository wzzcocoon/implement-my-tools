package cn.wzz.design.overrideDemo;

public class BaseBean {

    protected String dao;

    public String getDao() {
        System.out.println("BaseBean getDao 方法");
        return dao;
    }

    public void setDao(String dao) {
        System.out.println("BaseBean setDao 方法");
        this.dao = dao;
    }
}

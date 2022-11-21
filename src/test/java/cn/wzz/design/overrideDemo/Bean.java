package cn.wzz.design.overrideDemo;

public class Bean extends BaseBean{

    @Override
    public String getDao() {
        System.out.println("Bean getDao 方法");
        return super.getDao();
    }

    @Override
    public void setDao(String dao) {
        System.out.println("Bean setDao 方法");
        super.setDao(dao);
    }
}

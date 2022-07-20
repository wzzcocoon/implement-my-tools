package cn.wzz.test.collectTest;

import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CollectSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                return t1-integer;
//            }
//        });

        Collections.sort(list, (integer, t1) -> t1-integer);

        ///////////////////////////////////////////////////////

        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("今天", new Date()));
        humanList.add(new Human("后天", DateUtils.addDays(new Date(), 2)));
        humanList.add(new Human("昨天", DateUtils.addDays(new Date(), -1)));
        humanList.add(new Human("明天", DateUtils.addDays(new Date(), 1)));
        System.out.println("排序前>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(humanList);
        System.out.println("排序后>>>>>>>>>>>>>>>>>>>>>>>");
        listSort2(humanList);
        System.out.println(humanList);
    }



    /**
     * 根据list列表元素的时间字段进行升序排序
     */
    public static void listSort1(List<Human> list) {
        Collections.sort(list, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getBirthday().compareTo(h2.getBirthday());
            }
        });
    }

    /**
     * 根据list列表元素的时间字段进行降序排序
     */
    public static void listSort2(List<Human> list) {
        Collections.sort(list, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getBirthday().compareTo(h2.getBirthday());
            }
        });
        Collections.reverse(list);
    }

    /**
     * 根据list列表元素的时间字段进行降序排序
     */
    public static void listSort3(List<Human> list) {
        Collections.sort(list, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                if (o1.getBirthday().compareTo(o2.getBirthday()) > 0) {
                    return -1;
                } else if (o1.getBirthday().compareTo(o2.getBirthday()) < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

}



class Human {
    private String name;
    private Date birthday;
    public Human() {
    }
    public Human(String name, Date birthday) {
        super();
        this.name = name;
        this.birthday = birthday;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "Human [name=" + name + ", birthday=" + birthday + "]";
    }
}

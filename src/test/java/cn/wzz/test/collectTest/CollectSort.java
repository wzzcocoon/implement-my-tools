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
        humanList.add(new Human(2, "今天", new Date()));
        humanList.add(new Human(1, "今天", new Date()));
        humanList.add(new Human(3,"后天", DateUtils.addDays(new Date(), 2)));
        humanList.add(new Human(4,"昨天", DateUtils.addDays(new Date(), -1)));
        humanList.add(new Human(5,"明天", DateUtils.addDays(new Date(), 1)));
        System.out.println("排序前>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(humanList);
        System.out.println("排序后>>>>>>>>>>>>>>>>>>>>>>>");
        listSort4(humanList);
        System.out.println(humanList);
    }

//    public int compareTo(Student o){} 这个方法，它返回三种 int 类型的值： 负整数，零 ，正整数。
//    负整数：当前对象的值 < 比较对象的值，位置排在前
//    零   ：当前对象的值 = 比较对象的值 ， 位置不变
//    正整数：当前对象的值 > 比较对象的值，位置排在后

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
        //降序
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

    /**
     * 先根据name字段排序，后根据id排序
     */
    public static void listSort4(List<Human> list) {
        Collections.sort(list, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                if (h1.getName().equals(h2.getName())) {
                    return h1.getId() - h2.getId();
                } else {
                    return convertType(h1.getName()) - convertType(h2.getName());
                }
            }

            public int convertType(String name){
                if ("明天".equals(name)){
                    return 1;
                }else if ("今天".equals(name)){
                    return 2;
                }else if ("后天".equals(name)){
                    return 3;
                }else {
                    return 4;
                }
            }
        });
    }

}



class Human {
    private int id;
    private String name;
    private Date birthday;
    public Human() {
    }
    public Human(int id, String name, Date birthday) {
        super();
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

package cn.wzz.test.sortList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

/**
 * list排序测试类
 */
public class Test {

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
    
    public static void main(String[] args) {
    	List<Human> list = new ArrayList<>();
		list.add(new Human("今天", new Date()));
		list.add(new Human("后天", DateUtils.addDays(new Date(), 2)));
		list.add(new Human("昨天", DateUtils.addDays(new Date(), -1)));
		list.add(new Human("明天", DateUtils.addDays(new Date(), 1)));
		System.out.println("排序前>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(list);
		System.out.println("排序后>>>>>>>>>>>>>>>>>>>>>>>");
		listSort2(list);
		System.out.println(list);
    }
}

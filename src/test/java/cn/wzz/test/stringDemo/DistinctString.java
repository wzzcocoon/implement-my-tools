package cn.wzz.test.stringDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctString {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>(
                Arrays.asList("tom","com","boss","boss","jerry","jerry"));
		
		List<String> collect = list.stream().distinct().collect(Collectors.toList());
		for (String string : collect) {
			System.out.println(string);
		}
		
	}
	
	/**
     * 将 list3 的数据进行去重操作 -- 采用 for循环判断
     * 若直接只采用 Arrays.asList进行初始化
     *      不支持 remove()操作  UnsupportedOperationException
     *
     *  这是因为 Arrays.asList返回的 ArrayList 
     *       并不是java.util.ArrayList，
     *      而是在Arrays类中重新定义的一下内部类ArrayList
     *      这个内部类 ArrayList并没有重写remove方法。
     *  解决方式：
     *      List<String> list3 =
     *          new ArrayList<String>
     *         (Arrays.asList("tom","com","jerry"));
     *
     * E remove(int index)     
     * 移除列表中指定位置的元素（可选操作）。
     *      将所有的后续元素向左移动（将其索引减 1）。
     * 返回从列表中移除的元素。
     */
    public void getDistinctByFor(List<String> list3){
    	List<String> list = list3;
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i).equals(list.get(j))){
                	list3.remove(i); //注意这里是list3
                }
            }
        }
        System.out.println(list3);
        System.out.println(list3.size());
    }
    
    /**
     * 将 list3 的数据进行去重操作 -- 采用Set去重
     */
    public void getDistinctBySet(List<String> list3){
        Set<String> set = new HashSet<>();
        set.addAll(list3);
        System.out.println(set);
        System.out.println(set.size());
    }
    
    /**
     * 将 list3 的数据进行去重操作 -- 采用 Stream 去重
     */
    public void getDistinctByStream(List<String> list3){
        System.out.println(list3.stream()
                                .distinct()
                                .collect(Collectors.toList()));

        System.out.println(list3.stream()
                                .distinct()
                                .count());
    }
}

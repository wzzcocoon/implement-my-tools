package cn.wzz.otherTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DivideList {

	/**将一个list平均分为num份
	 * @param num分的份数
	 * @param list需要分的集合
	 */
	public static Map<String, List<Object>> splitList(List<String> list, Integer num) {

		int listSize = list.size(); // list 长度

		// 用户封装返回的多个list
		Map<String, List<Object>> retMap = new HashMap<String, List<Object>>(); 
		// 用于承装每个等分list
		List<Object> divideList = new ArrayList<Object>();

		// for循环依次放入每个list中
		for (int i = 0; i < listSize; i++) { 
			// 先将对象放入list,以防止最后一个没有放入
			divideList.add(list.get(i)); 
			// 如果i+1 除以 要分的份数 为整除,或者是最后一份,为结束循环.那就算作一份list,
			if (((i + 1) % num == 0) || (i + 1 == listSize)) {
				// 将这一份放入Map中.
				retMap.put("param" + i, divideList); 
				// 新建一个list,用于继续存储对象
				divideList = new ArrayList<Object>(); 
			}
		}
		// 将map返回
		return retMap; 
	}
	
	public static void main(String[] args) throws Exception {
		//实例,新建一个96条的list集合,将他平均分成几等份
        List<Integer> list = new ArrayList<Integer>();          
        for (int i = 0; i < 96; i++) {
            list.add(i);
        }
//        List<List<Integer>> averageAssign = averageAssign(list,100);

        //	list.get(list.size())							-->		java.lang.IndexOutOfBoundsException
        //	list.subList(list.size(), list.size()).size()  	-->  0     不报错？
        //	list.subList(list.size(), list.size()+1).size()	-->		java.lang.IndexOutOfBoundsException
        List<Integer> subList = list.subList(list.size(), list.size());
        System.out.println(subList);
        System.out.println(list.subList(list.size(), list.size()).size());
        
        System.out.println(list.subList(0, 0));
        //	list.subList(0, 0).get(0)						-->		java.lang.IndexOutOfBoundsException
	}
	
	
	/**
     * 将一个list均分成n个list,主要通过偏移量来实现的
     * @param list
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> list, int n) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
//        if(list.size() < n){
//            n = list.size();
//        }
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = list.size() % n;
        int number = list.size() / n;
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = list.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = list.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }
	
	/**
	 * 将一组数据固定分组，每组n个元素
	 * @param source 要分组的数据源
	 * @param n      每组n个元素
	 * @param <T>
	 * @return
	 */
	public static <T> List<List<T>> fixedGrouping(List<T> source, int n) {

	    if (null == source || source.size() == 0 || n <= 0)
	        return null;
	    List<List<T>> result = new ArrayList<List<T>>();

	    int sourceSize = source.size();
	    int size = (source.size() / n) + 1;
	    for (int i = 0; i < size; i++) {
	        List<T> subset = new ArrayList<T>();
	        for (int j = i * n; j < (i + 1) * n; j++) {
	            if (j < sourceSize) {
	                subset.add(source.get(j));
	            }
	        }
	        result.add(subset);
	    }
	    return result;
	}

	/**
	 * 将一组数据固定分组，每组n个元素
	 *
	 * @param source 要分组的数据源
	 * @param n      每组n个元素
	 * @param <T>
	 * @return
	 */
	public static <T> List<List<T>> fixedGrouping2(List<T> source, int n) {

	    if (null == source || source.size() == 0 || n <= 0)
	        return null;
	    List<List<T>> result = new ArrayList<List<T>>();
	    int remainder = source.size() % n;
	    int size = (source.size() / n);
	    for (int i = 0; i < size; i++) {
	        List<T> subset = null;
	        subset = source.subList(i * n, (i + 1) * n);
	        result.add(subset);
	    }
	    if (remainder > 0) {
	        List<T> subset = null;
	        subset = source.subList(size * n, size * n + remainder);
	        result.add(subset);
	    }
	    return result;
	}
	
}

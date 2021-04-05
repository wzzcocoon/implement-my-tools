package cn.wzz.interview2021;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCacheDemo1<K,V> extends LinkedHashMap<K,V> {

    private int capacity;//缓存坑位

    public LRUCacheDemo1(int capacity) {
        /**
         * @param  initialCapacity the initial capacity
         * @param  loadFactor      the load factor
         * @param  accessOrder     the ordering mode - <tt>true</tt> for access-order,
         *                                            <tt>false</tt> for insertion-order
         */
        super(capacity,0.75F,false);
            this.capacity = capacity;
    }



    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo1 lruCacheDemo = new LRUCacheDemo1(3);

        lruCacheDemo.put(1,"a");
        lruCacheDemo.put(2,"b");
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4,"d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5,"x");
        System.out.println(lruCacheDemo.keySet());
    }

}

package cn.wzz.interview2021;

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

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo2{


            //map负责查找，构建一个虚拟的双向链表，它里面安装的就是一个个Node节点，作为数据载体。

            //1.构造一个node节点作为数据载体
            class Node<K, V>
            {
                K key;
                V value;
                Node<K,V> prev;
                Node<K,V> next;

                public Node(){
                    this.prev = this.next = null;
                }

                public Node(K key, V value)
                {
                    this.key = key;
                    this.value = value;
                    this.prev = this.next = null;
                }

            }

            //2 构建一个虚拟的双向链表,,里面安放的就是我们的Node
            class DoubleLinkedList<K, V>
            {
                Node<K, V> head;
                Node<K, V> tail;

                public DoubleLinkedList(){
                    head = new Node<>();
                    tail = new Node<>();
                    head.next = tail;
                    tail.prev = head;
                }

                //3. 添加到头
                public void addHead(Node<K,V> node)
                {
                    node.next = head.next;
                    node.prev = head;
                    head.next.prev = node;
                    head.next = node;
                }

                //4.删除节点
                public void removeNode(Node<K, V> node) {
                    node.next.prev = node.prev;
                    node.prev.next = node.next;
                    node.prev = null;
                    node.next = null;
                }

                //5.获得最后一个节点
                public Node getLast() {
                    return tail.prev;
                }
            }

            private int cacheSize;
            Map<Integer,Node<Integer,Integer>> map;
            DoubleLinkedList<Integer,Integer> doubleLinkedList;

            public LRUCacheDemo2(int cacheSize)
            {
                this.cacheSize = cacheSize;//坑位
                map = new HashMap<>();//查找
                doubleLinkedList = new DoubleLinkedList<>();
            }

            public int get(int key){
                if (!map.containsKey(key)){
                    return -1;
                }

                Node<Integer, Integer> node = map.get(key);
                doubleLinkedList.removeNode(node);
                doubleLinkedList.addHead(node);

                return node.value;
            }

            public void put(int key, int value)
            {
                if (map.containsKey(key)){  //update
                    Node<Integer, Integer> node = map.get(key);
                    node.value = value;
                    map.put(key, node);

                    doubleLinkedList.removeNode(node);
                    doubleLinkedList.addHead(node);
                }else {
                    if (map.size() == cacheSize)  //坑位满了
                    {
                        Node<Integer,Integer> lastNode = doubleLinkedList.getLast();
                        map.remove(lastNode.key);
                        doubleLinkedList.removeNode(lastNode);
                    }

                    //新增一个
                    Node<Integer, Integer> newNode = new Node<>(key, value);
                    map.put(key,newNode);
                    doubleLinkedList.addHead(newNode);

                }
            }

            public static void main(String[] args) {

                LRUCacheDemo2 LRUCacheDemo2 = new LRUCacheDemo2(3);

                LRUCacheDemo2.put(1,1);
                LRUCacheDemo2.put(2,2);
                LRUCacheDemo2.put(3,3);
                System.out.println(LRUCacheDemo2.map.keySet());

                LRUCacheDemo2.put(4,1);
                System.out.println(LRUCacheDemo2.map.keySet());

                LRUCacheDemo2.put(3,1);
                System.out.println(LRUCacheDemo2.map.keySet());
                LRUCacheDemo2.put(3,1);
                System.out.println(LRUCacheDemo2.map.keySet());
                LRUCacheDemo2.put(3,1);
                System.out.println(LRUCacheDemo2.map.keySet());
                LRUCacheDemo2.put(5,1);
                System.out.println(LRUCacheDemo2.map.keySet());
            }
        }
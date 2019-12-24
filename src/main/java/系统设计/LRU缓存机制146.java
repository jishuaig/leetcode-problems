package 系统设计;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRU缓存机制146 {

    private Map<Integer, Integer> keys = new HashMap<>();    //用于存储键值对
    private List<Integer> used = new LinkedList<>();         //用于记录键值对访问情况，used的第0个元素为最少访问的
    private int cap;                                        //表容量
    private int num = 0;                                    //已有元素数量

    public LRU缓存机制146(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!keys.containsKey(key)) return -1;
        used.remove((Integer) key);             //以下这两步的操作是更新键值对的使用情况
        used.add(key);
        return keys.get(key);
    }

    public void put(int key, int value) {
        if (keys.containsKey(key)) {
            used.remove((Integer) key);
        } else if (num < cap) {
            num++;
        } else {
            keys.remove(used.get(0));
            used.remove(0);
        }
        keys.put(key, value);
        used.add(key);

    }

}

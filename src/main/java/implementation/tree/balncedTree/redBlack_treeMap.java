package implementation.tree.balncedTree;

import java.util.*;

public class redBlack_treeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "a20");
        map.put(2, "a10");
        map.put(3, "a2");
        map.put(4, "a1");
        System.out.println(map.get(1));
        System.out.println("first key & map= " + map.firstKey() + " " + map.firstEntry());
        System.out.println("last key & map= " + map.lastKey() + " " + map.lastEntry());
        for (Map.Entry<Integer, String> i : map.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }
        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }
        map.comparator();
        for (Map.Entry<Integer, String> i : map.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }
        // 값으로 맵 정렬 하는 법 해보기
        // entrySet vs keySet
    }

}

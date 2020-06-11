package implementation.hashTable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class collection_hashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(10);
        hashMap.put("a", "amazon");
        hashMap.put("b", "balance");
        hashMap.put("c", "concat");
        hashMap.put("d", "demodulation");
        hashMap.put("e", "emulator");
        // 키 기반 값 출력
        System.out.println(hashMap.get("c"));
        // 모든 키 출력
        Set<String> keys = hashMap.keySet();
        keys.forEach(System.out::println);
        // 모든 값 출력
        Collection<String> values = hashMap.values();
        values.forEach(System.out::println);
        // 모든 키값 출력
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        entries.forEach(System.out::println);
    }
}

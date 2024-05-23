package map;

import java.util.HashMap;

public class MapExampleV3 {
    public static void main(String[] args) {
        // HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 요소 추가
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("David", 40);

        // 요소 출력
        System.out.println("HashMap:");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // 요소 제거
        map.remove("Bob");

        // 요소 존재 여부 확인
        boolean hasAlice = map.containsKey("Alice");
        System.out.println("Contains Alice: " + hasAlice);

        // 최종 HashMap 출력
        System.out.println("HashMap after removing Bob:");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // 크기 확인
        System.out.println("Size of the HashMap: " + map.size());
    }
}

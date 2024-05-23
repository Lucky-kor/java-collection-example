package set;

import java.util.*;

public class SetExampleV3 {
    public static void main(String[] args) {
        // HashSet 생성
        Set<String> set = new HashSet<>();

        // 요소 추가
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // 중복 요소 추가 시도

        // 요소 출력
        System.out.println("Set in HashSet:");
        for (String item : set) {
            System.out.println(item);
        }

        // 요소 제거
        set.remove("Banana");

        // 요소 존재 여부 확인
        boolean hasApple = set.contains("Apple");
        System.out.println("Contains Apple: " + hasApple);

        // 최종 HashSet 출력
        System.out.println("HashSet after removing Banana:");
        for (String item : set) {
            System.out.println(item);
        }

        // 크기 확인
        System.out.println("Size of the HashSet: " + set.size());
    }
}

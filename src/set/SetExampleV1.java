package set;

import java.util.*;

public class SetExampleV1 {
    public static void main(String[] args) {
        // List 생성
        List<String> set = new ArrayList<>();

        // 요소 추가 (중복 체크)
        if (!set.contains("Apple")) {
            set.add("Apple");
        }
        if (!set.contains("Banana")) {
            set.add("Banana");
        }
        if (!set.contains("Orange")) {
            set.add("Orange");
        }
        if (!set.contains("Apple")) {
            set.add("Apple"); // 중복 요소 추가 시도
        }

        // 요소 출력
        System.out.println("Set in list:");
        for (String item : set) {
            System.out.println(item);
        }
    }
}

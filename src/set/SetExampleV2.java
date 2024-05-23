package set;

import java.util.*;

public class SetExampleV2 {
    public static void main(String[] args) {
        // 초기 List 생성
        List<String> set = new ArrayList<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        // 새 요소 추가 (중복 체크)
        if (!set.contains("Grapes")) {
            set.add("Grapes");
        }

        // List의 요소 출력
        System.out.println("Set in list:");
        for (String item : set) {
            System.out.println(item);
        }

        // "Banana"를 제거한 새 List 생성
        List<String> smallerSet = new ArrayList<>();
        for (String item : set) {
            if (!item.equals("Banana")) {
                smallerSet.add(item);
            }
        }

        // 요소 제거 후 새 List의 요소 출력
        System.out.println("Set after removing Banana:");
        for (String item : smallerSet) {
            System.out.println(item);
        }
    }
}

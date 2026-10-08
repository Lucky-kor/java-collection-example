package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/** 순서와 중복 규칙으로 Set 구현체를 선택합니다. */
public class SetTypesExample {
    public static void main(String[] args) {
        // 중복을 제거합니다. 출력에서 보이는 순서는 앞으로도 유지된다는 보장이 없습니다.
        Set<String> hashed = new HashSet<>(Arrays.asList("banana", "apple", "banana", "cherry"));

        // 중복을 제거하되 처음 삽입한 순서를 유지합니다.
        Set<String> ordered = new LinkedHashSet<>(Arrays.asList("banana", "apple", "banana", "cherry"));

        // 기존 Set을 받아 문자열의 자연 순서로 정렬해 저장합니다.
        Set<String> sorted = new TreeSet<>(ordered);

        System.out.println("HashSet(순서 보장 없음): " + hashed);
        System.out.println("LinkedHashSet(삽입 순서): " + ordered);
        System.out.println("TreeSet(자연 순서): " + sorted);
        // 이미 있는 apple을 다시 추가하므로 false입니다. 요소 수나 순서는 바뀌지 않습니다.
        System.out.println("중복 추가 성공 여부: " + ordered.add("apple"));

        // Set에는 인덱스가 없으므로 요소를 하나씩 꺼내는 방식으로 순회합니다.
        for (String fruit : ordered) {
            System.out.println("인덱스 없이 순회: " + fruit);
        }
    }
}

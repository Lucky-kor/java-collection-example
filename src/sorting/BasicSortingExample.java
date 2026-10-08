package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** 자연 순서, 역순, 별도 결과 생성, 원본 변경을 비교합니다. */
public class BasicSortingExample {
    // 프로그램은 main에서 시작합니다. 아래 메서드를 위에서부터 차례로 호출합니다.
    public static void main(String[] args) {
        numberSortingExample();
        stringSortingExample();
    }

    // private은 이 클래스 안에서만 호출 가능, static은 객체를 만들지 않고 호출 가능하다는 뜻입니다.
    // void 메서드는 작업을 수행한 뒤 값을 반환하지 않습니다.
    private static void numberSortingExample() {
        System.out.println("\n1. 숫자 정렬과 원본 유지");

        List<Integer> original = new ArrayList<>(Arrays.asList(30, 10, 20, 10));

        // 새 목록에 복사해 정렬합니다. original의 요소 순서는 그대로 둡니다.
        List<Integer> ascending = new ArrayList<>(original);
        // Integer의 기본 순서인 숫자 오름차순으로 이 목록을 변경합니다.
        Collections.sort(ascending);

        System.out.println("오름차순: " + ascending);
        // reverseOrder는 기본 순서를 뒤집는 비교기입니다. 숫자를 큰 값부터 배치합니다.
        ascending.sort(Comparator.reverseOrder());
        System.out.println("내림차순: " + ascending);

        // 아래 연속 호출은 순서대로 수행됩니다. original 목록의 순서는 바뀌지 않습니다.
        List<Integer> sortedCopy = original.stream() // 원본 요소를 처리할 스트림을 만듭니다.
                .sorted() // 스트림에서 요소를 자연 순서로 정렬합니다.
                .collect(Collectors.toList()); // 정렬된 요소를 새 List로 모읍니다.
        System.out.println("stream 결과: " + sortedCopy);
        System.out.println("원본: " + original);
    }

    private static void stringSortingExample() {
        System.out.println("\n2. 문자열의 비교 기준");

        List<String> names = new ArrayList<>(Arrays.asList("banana", "Apple", "apple"));
        // 문자열은 문자 값에 따른 사전식 순서로 비교합니다. 대소문자를 구분합니다.
        names.sort(Comparator.naturalOrder());
        System.out.println("문자열 자연 순서: " + names);
        // 대소문자를 무시하는 비교 기준을 전달합니다.
        names.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("대소문자 무시: " + names);
    }
}

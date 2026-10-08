package collection;

import java.util.ArrayList;
import java.util.List;

/** 제네릭으로 저장할 타입을 지정하면 잘못된 타입을 컴파일 시점에 발견합니다. */
public class GenericsExample {
    public static void main(String[] args) {
        // List<String>은 문자열만 담는 목록입니다. <>는 왼쪽의 String 타입을 그대로 사용합니다.
        List<String> names = new ArrayList<>();
        // add는 목록의 맨 뒤에 값을 추가합니다.
        names.add("김러키");
        // get(0)은 첫 번째 값을 꺼내 반환합니다. String 목록이므로 형변환이 필요 없습니다.
        String firstName = names.get(0);

        // 제네릭에는 int 대신 Integer를 사용합니다. Integer는 정수를 객체로 다루는 타입입니다.
        List<Integer> scores = new ArrayList<>();
        // int -> Integer 자동 박싱
        scores.add(90);
        // Integer -> int 자동 언박싱
        int firstScore = scores.get(0);

        System.out.println("이름: " + firstName + ", 점수: " + firstScore);
    }
}

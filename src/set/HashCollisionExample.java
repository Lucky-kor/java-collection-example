package set;

import java.util.HashSet;
import java.util.Set;

/** 해시 충돌이 발생해도 Set이 서로 다른 요소를 구분하는 이유를 학습합니다. */
public class HashCollisionExample {
    public static void main(String[] args) {
        // Aa와 BB는 내용이 다르지만 Java String의 hashCode 값은 같습니다.
        String first = "Aa";
        String second = "BB";

        // hashCode는 해시 검색에 쓰는 정수입니다. 같다고 같은 내용인 것은 아닙니다.
        System.out.println("해시가 같은가: " + (first.hashCode() == second.hashCode()));
        // 문자열 equals는 내용을 비교하므로 두 문자열은 다르다고 판단합니다.
        System.out.println("내용이 같은가: " + first.equals(second));

        Set<String> words = new HashSet<>();
        words.add(first);
        // HashSet은 해시가 같아도 equals가 false이면 별개의 요소로 저장합니다.
        words.add(second);
        // 두 문자열 모두 저장되어 크기는 2입니다.
        System.out.println("충돌해도 size: " + words.size());
    }
}

package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/** 속성별 Comparator를 조합하고 매번 원본의 복사본을 정렬합니다. */
public class ObjectSortingExample {
    // 프로그램은 main에서 시작합니다. 아래 메서드를 위에서부터 차례로 호출합니다.
    public static void main(String[] args) {
        // 각 Member의 생성자 인자는 이름, 나이, 점수 순서입니다.
        List<Member> members = Arrays.asList(
                new Member("김러키", 8, 90),
                new Member("한여름", 9, 80),
                new Member("김라떼", 7, 90),
                new Member("바닐라", 7, 95),
                new Member("김러키", 7, 90));
        // Comparator는 두 객체의 순서를 정하는 기준입니다. ::는 이름을 읽는 메서드를 가리킵니다.
        Comparator<Member> byName = Comparator.comparing(Member::getName);
        // comparingInt는 getAge()로 읽은 int 값을 작은 값부터 비교합니다.
        Comparator<Member> byAge = Comparator.comparingInt(Member::getAge);
        // 점수 비교 기준을 만들어 저장합니다. 기준을 만드는 것만으로 목록이 정렬되지는 않습니다.
        Comparator<Member> byScore = Comparator.comparingInt(Member::getScore);

        // 단일 속성으로 정렬합니다.
        printSorted("이름 오름차순", members, byName);
        // reversed()는 이름 비교 기준의 방향을 반대로 만듭니다.
        printSorted("이름 내림차순", members, byName.reversed());
        printSorted("나이 오름차순", members, byAge);
        printSorted("점수 내림차순", members, byScore.reversed());

        // thenComparing은 앞 기준으로 동률일 때만 다음 비교 기준을 사용합니다.
        printSorted("나이 오름차순 -> 이름 오름차순", members, byAge.thenComparing(byName));
        printSorted("점수 내림차순 -> 나이 오름차순 -> 이름 오름차순", members,
                // 점수는 큰 값부터 비교합니다. 다음 기준은 아직 뒤집지 않았습니다.
                byScore.reversed()
                        // 점수가 같으면 나이를 작은 값부터 비교합니다.
                        .thenComparingInt(Member::getAge)
                        // 점수와 나이가 모두 같으면 이름의 오름차순으로 비교합니다.
                        .thenComparing(byName));

        System.out.println("원본 유지: " + members);
        nullSortingExample();
    }

    // private은 이 클래스 안에서만 호출 가능, static은 객체를 만들지 않고 호출 가능하다는 뜻입니다.
    // void 메서드는 작업을 수행한 뒤 값을 반환하지 않습니다.
    private static void nullSortingExample() {
        System.out.println("\nnull이 포함된 문자열 정렬");

        List<String> nullableNames = new ArrayList<>(Arrays.asList("바닐라", null, "김러키"));
        // null끼리는 동률, null과 문자열을 비교하면 null이 뒤에 오도록 처리합니다.
        nullableNames.sort(Comparator.nullsLast(Comparator.naturalOrder()));

        System.out.println("null을 마지막으로: " + nullableNames);
    }

    // 호출한 곳에서 출력 제목, 원본 목록, 정렬 기준을 받아 처리하는 보조 메서드입니다.
    private static void printSorted(String label, List<Member> source, Comparator<Member> comparator) {
        // 목록만 새로 만듭니다. 내부 Member 객체들은 원본과 공유합니다.
        List<Member> copy = new ArrayList<>(source);
        // 전달받은 비교 기준으로 복사본의 순서를 변경합니다.
        copy.sort(comparator);
        System.out.println(label + ": " + copy);
    }
}

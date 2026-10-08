package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/** 수정 가능 여부와 순회 중 안전한 삭제를 학습합니다. */
public class ListMutationExample {
    // 프로그램은 main에서 시작합니다. 아래 메서드를 위에서부터 차례로 호출합니다.
    public static void main(String[] args) {
        fixedSizeExample();
        editableCopyExample();
        safeRemovalExample();
    }

    // private은 이 클래스 안에서만 호출 가능, static은 객체를 만들지 않고 호출 가능하다는 뜻입니다.
    // void 메서드는 작업을 수행한 뒤 값을 반환하지 않습니다.
    private static void fixedSizeExample() {
        System.out.println("\n1. 고정 크기 목록의 요소 교체");

        // 요소 수가 고정된 목록입니다. set은 가능하지만 add와 remove는 지원하지 않습니다.
        List<String> fixed = Arrays.asList("A", "B", "C");
        // 크기는 고정이지만 요소 교체는 가능
        fixed.set(0, "Z");

        System.out.println("고정 크기: " + fixed);
    }

    private static void editableCopyExample() {
        System.out.println("\n2. 수정 불가능한 목록을 복사하기");

        // List.of는 추가·삭제·교체할 수 없는 목록을 만듭니다. null도 넣을 수 없습니다.
        List<String> immutable = List.of("A", "B");

        // 수정 불가능한 원본을 새 ArrayList에 복사하면 복사본은 수정할 수 있습니다.
        List<String> editable = new ArrayList<>(immutable);
        // 복사본에만 C가 추가됩니다. immutable은 [A, B] 그대로입니다.
        editable.add("C");
        System.out.println("수정 가능한 복사본: " + editable);
    }

    private static void safeRemovalExample() {
        System.out.println("\n3. 순회 중 안전하게 삭제하기");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        // Iterator는 다음 요소로 이동하고 현재 요소를 삭제할 수 있는 순회 도구입니다.
        Iterator<Integer> iterator = numbers.iterator();

        // 다음 요소가 남아 있는 동안 반복합니다. 없으면 반복을 끝냅니다.
        while (iterator.hasNext()) {
            // 다음 요소를 반환하고 순회 위치를 앞으로 이동합니다.
            int number = iterator.next();
            // %는 나머지 연산입니다. 2로 나눈 나머지가 0이면 짝수입니다.
            if (number % 2 == 0) {
                // 바로 앞의 next()로 읽은 요소를 삭제합니다. 순회 중에는 목록의 remove 대신 사용합니다.
                iterator.remove();
            }
        }
        System.out.println("짝수 삭제: " + numbers);
        // 람다의 number는 검사할 요소입니다. -> 오른쪽 조건이 true인 요소를 모두 삭제합니다.
        numbers.removeIf(number -> number >= 3);
        System.out.println("3 이상 삭제: " + numbers);
    }
}

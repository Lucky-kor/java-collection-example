package list;

import java.util.ArrayList;
import java.util.List;

/** List는 삽입 순서와 인덱스를 가지며 중복을 허용합니다. */
public class ArrayListExample {
    public static void main(String[] args) {
        // List 기능으로 ArrayList를 사용합니다. 30은 초기 저장 용량이며 요소 수가 아닙니다.
        List<Integer> numbers = new ArrayList<>(30);

        // size()는 실제로 들어 있는 요소 수를 반환합니다. 처음에는 0입니다.
        System.out.println("처음 size: " + numbers.size());

        // 1. 추가: List는 중복을 허용합니다.
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        // 첫 인자는 삽입 위치, 둘째 인자는 값입니다. 맨 앞에 3을 넣고 기존 값들을 뒤로 밉니다.
        numbers.add(0, 3);
        System.out.println("추가: " + numbers);

        // 2. 조회: 인덱스는 0부터 시작합니다.
        // get(2)는 세 번째 요소를 반환합니다. 조회만 하므로 목록은 바뀌지 않습니다.
        System.out.println("인덱스 2: " + numbers.get(2));
        // indexOf(2)는 값 2가 처음 나타나는 인덱스를 반환합니다.
        System.out.println("2의 첫 위치: " + numbers.indexOf(2));
        // 찾는 값이 없으면 indexOf는 -1을 반환합니다.
        System.out.println("없는 값 위치: " + numbers.indexOf(99));

        // 3. 교체와 삭제: 인덱스 삭제와 값 삭제를 구분합니다.
        // 인덱스 1의 값을 10으로 바꾸고, 원래 값을 반환받아 저장합니다.
        int previousValue = numbers.set(1, 10);
        System.out.println("교체 전 값: " + previousValue);
        // 정수 인자를 그대로 전달하면 값이 아니라 인덱스 0의 요소를 삭제합니다.
        numbers.remove(0);
        // 처음 발견한 2 하나만 삭제
        numbers.remove(Integer.valueOf(2));
        System.out.println("삭제 후: " + numbers);

        // 4. 순회: 위치가 필요하면 인덱스, 값만 필요하면 향상된 for문을 사용합니다.
        // i를 0부터 시작해 하나씩 늘립니다. i < size()이므로 마지막 유효 인덱스까지 방문합니다.
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("위치 " + i + ": " + numbers.get(i));
        }

        // 목록의 값을 하나씩 number에 넣습니다. 직접 인덱스를 관리하지 않아도 됩니다.
        for (int number : numbers) {
            System.out.println("값: " + number);
        }
    }
}

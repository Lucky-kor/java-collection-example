package list;

import java.util.LinkedList;
import java.util.List;

/** LinkedList는 배열이 아니라 이전/다음 노드를 연결한 구조입니다. */
public class LinkedListExample {
    public static void main(String[] args) {
        // List 사용법은 같지만, LinkedList는 값을 가진 노드를 연결해 저장합니다.
        List<Integer> numbers = new LinkedList<>();
        // 위치를 지정하지 않은 add는 맨 뒤에 추가합니다.
        numbers.add(1);
        numbers.add(2);
        // 인덱스 0에 3을 삽입합니다. 결과 순서는 [3, 1, 2]입니다.
        numbers.add(0, 3);

        System.out.println("추가: " + numbers);
        // get(2)는 세 번째 값입니다. LinkedList는 해당 위치까지 노드를 따라 이동합니다.
        System.out.println("인덱스 2: " + numbers.get(2));
        // Integer 객체로 전달하면 인덱스 3이 아니라 값 3을 삭제합니다.
        numbers.remove(Integer.valueOf(3));

        // 내부 iterator로 노드를 차례로 방문합니다. get(i)를 반복하는 것보다 순회에 적합합니다.
        for (int number : numbers) {
            System.out.println("값: " + number);
        }
    }
}

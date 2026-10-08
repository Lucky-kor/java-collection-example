package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** List에서 삽입과 교체의 차이를 비교합니다. */
public class ListInsertionAndReplacementExample {
    public static void main(String[] args) {
        // Arrays.asList로 초기값을 만들고, 추가·삭제 가능한 ArrayList에 복사합니다.
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // 인덱스 2에 10을 끼워 넣습니다. 기존 3과 4가 뒤로 이동합니다.
        numbers.add(2, 10);

        System.out.println("삽입: " + numbers);
        // 인덱스 2의 10을 20으로 바꿉니다. 다른 요소의 위치와 목록 크기는 그대로입니다.
        numbers.set(2, 20);
        System.out.println("교체: " + numbers);
        // 삽입으로 한 개 늘었고 교체로는 늘지 않았으므로 크기는 5입니다.
        System.out.println("size: " + numbers.size());
    }
}

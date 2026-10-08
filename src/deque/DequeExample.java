package deque;

import java.util.ArrayDeque;
import java.util.Deque;

/** 양 끝에서 넣고 꺼내는 작업은 Deque 인터페이스로 표현합니다. */
public class DequeExample {
    // 프로그램은 main에서 시작합니다. 아래 메서드를 위에서부터 차례로 호출합니다.
    public static void main(String[] args) {
        queueExample();
        stackExample();
    }

    // private은 이 클래스 안에서만 호출 가능, static은 객체를 만들지 않고 호출 가능하다는 뜻입니다.
    // void 메서드는 작업을 수행한 뒤 값을 반환하지 않습니다.
    private static void queueExample() {
        System.out.println("\n1. 큐: 먼저 넣은 요청부터 처리");

        // 문자열을 양 끝에서 넣고 꺼낼 수 있는 자료구조입니다. ArrayDeque는 null을 허용하지 않습니다.
        Deque<String> queue = new ArrayDeque<>();
        // 뒤쪽에 요청을 넣습니다. 나중에 앞쪽에서 꺼내면 먼저 들어온 요청부터 처리됩니다.
        queue.offerLast("첫 요청");
        queue.offerLast("둘째 요청");

        // peekFirst는 앞쪽 값을 조회합니다. 값은 제거하지 않습니다.
        System.out.println("조회만: " + queue.peekFirst());
        // pollFirst는 앞쪽 값을 반환하면서 제거합니다.
        System.out.println("FIFO: " + queue.pollFirst());
        // pollFirst는 앞쪽 값을 반환하면서 제거합니다.
        System.out.println("FIFO: " + queue.pollFirst());
        // 요소를 모두 꺼낸 뒤 pollFirst를 호출하면 null을 반환합니다.
        System.out.println("빈 큐 poll: " + queue.pollFirst());
    }

    private static void stackExample() {
        System.out.println("\n2. 스택: 마지막 작업부터 꺼내기");

        // 같은 Deque라도 앞쪽에 넣고 앞쪽에서 꺼내면 스택으로 사용할 수 있습니다.
        Deque<String> stack = new ArrayDeque<>();
        // push는 앞쪽에 값을 넣습니다. 마지막에 넣은 값이 맨 앞에 놓입니다.
        stack.push("첫 작업");
        stack.push("둘째 작업");
        // pop은 앞쪽 값을 꺼내 제거합니다. 빈 스택에서는 예외가 발생합니다.
        System.out.println("LIFO: " + stack.pop());
        // pop은 앞쪽 값을 꺼내 제거합니다. 빈 스택에서는 예외가 발생합니다.
        System.out.println("LIFO: " + stack.pop());
    }
}

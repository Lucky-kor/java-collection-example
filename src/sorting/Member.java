package sorting;

import java.util.Objects;

/** 정렬할 속성이 명확하게 보이도록 만든 불변 학습 모델입니다. */
public final class Member {
    // private은 클래스 내부에서만 접근한다는 뜻입니다. final 필드는 생성 후 다른 값으로 재대입할 수 없습니다.
    private final String name;
    private final int age;
    private final int score;

    // 생성자는 new로 객체를 만들 때 실행됩니다. 전달받은 값으로 객체의 필드를 초기화합니다.
    public Member(String name, int age, int score) {
        // this는 현재 객체입니다. 왼쪽은 필드, 오른쪽은 생성자 인자이며 null이면 예외를 던집니다.
        this.name = Objects.requireNonNull(name, "name");
        this.age = age;
        this.score = score;
    }

    // getter는 private 필드의 값을 외부에서 읽을 수 있게 하는 메서드입니다.
    public String getName() {
        return name;
    }

    // 이 getter가 반환하는 int 속성을 comparingInt에서 정렬 기준으로 사용합니다.
    public int getAge() {
        return age;
    }

    // 이 getter가 반환하는 int 속성을 comparingInt에서 정렬 기준으로 사용합니다.
    public int getScore() {
        return score;
    }

    // 상위 타입에서 물려받은 메서드를 재정의하는 메서드임을 컴파일러에 알립니다.
    @Override
    // 객체를 println으로 출력할 때 보여 줄 문자열을 정의합니다.
    public String toString() {
        return name + "(나이=" + age + ", 점수=" + score + ")";
    }
}

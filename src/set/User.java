package set;

import java.util.Objects;

/** 이 예제에서는 이름이 같으면 같은 사용자로 간주합니다. 실제 서비스에서는 고유 ID를 고려합니다. */
public final class User {
    // private은 클래스 내부에서만 접근한다는 뜻입니다. final 필드는 생성 후 다른 값으로 재대입할 수 없습니다.
    private final String name;

    // 생성자는 new로 객체를 만들 때 실행됩니다. 전달받은 값으로 객체의 필드를 초기화합니다.
    public User(String name) {
        // this는 현재 객체입니다. 왼쪽은 필드, 오른쪽은 생성자 인자이며 null이면 예외를 던집니다.
        this.name = Objects.requireNonNull(name, "name");
    }

    // getter는 private 필드의 값을 외부에서 읽을 수 있게 하는 메서드입니다.
    public String getName() {
        return name;
    }

    // 상위 타입에서 물려받은 메서드를 재정의하는 메서드임을 컴파일러에 알립니다.
    @Override
    // Object에서 물려받은 equals를 재정의합니다. 비교 상대는 어떤 객체든 받을 수 있습니다.
    public boolean equals(Object obj) {
        // 상대가 바로 현재 객체라면 나머지 검사를 하지 않고 true를 반환합니다.
        if (this == obj) {
            return true;
        }
        // instanceof는 해당 타입인지 검사합니다. !는 부정이며 null도 이 검사에서 걸러집니다.
        if (!(obj instanceof User)) {
            return false;
        }

        // 타입 확인이 끝났으므로 Object 참조를 User 타입으로 형변환해 필드를 읽습니다.
        User other = (User) obj;
        // 객체 참조가 아닌 문자열 내용을 비교해 동등성을 판단합니다.
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        // equals에 사용한 필드로 해시를 계산합니다. 동등한 객체는 반드시 같은 해시를 반환해야 합니다.
        return name.hashCode();
    }

    @Override
    // 객체를 println으로 출력할 때 보여 줄 문자열을 정의합니다.
    public String toString() {
        return "User{name='" + name + "'}";
    }
}

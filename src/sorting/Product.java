package sorting;

import java.util.Objects;

/** 제품 코드를 동등성 기준과 기본 정렬 기준으로 사용합니다. */
public final class Product implements Comparable<Product> {
    // private은 클래스 내부에서만 접근한다는 뜻입니다. final 필드는 생성 후 다른 값으로 재대입할 수 없습니다.
    private final String code;
    private final int price;

    // 생성자는 new로 객체를 만들 때 실행됩니다. 전달받은 값으로 객체의 필드를 초기화합니다.
    public Product(String code, int price) {
        // this는 현재 객체입니다. 왼쪽은 필드, 오른쪽은 생성자 인자이며 null이면 예외를 던집니다.
        this.code = Objects.requireNonNull(code, "code");
        this.price = price;
    }

    // getter는 private 필드의 값을 외부에서 읽을 수 있게 하는 메서드입니다.
    public String getCode() {
        return code;
    }

    // 이 getter가 반환하는 int 속성을 comparingInt에서 정렬 기준으로 사용합니다.
    public int getPrice() {
        return price;
    }

    // 상위 타입에서 물려받은 메서드를 재정의하는 메서드임을 컴파일러에 알립니다.
    @Override
    // Comparable의 기본 비교 메서드입니다. 음수면 앞, 0이면 동률, 양수면 뒤에 놓입니다.
    public int compareTo(Product other) {
        // 현재 코드와 상대 코드를 문자열 순서로 비교합니다. equals와 같은 코드 속성을 사용합니다.
        return code.compareTo(other.code);
    }

    @Override
    // Object에서 물려받은 equals를 재정의합니다. 비교 상대는 어떤 객체든 받을 수 있습니다.
    public boolean equals(Object obj) {
        // 상대가 바로 현재 객체라면 나머지 검사를 하지 않고 true를 반환합니다.
        if (this == obj) {
            return true;
        }
        // instanceof는 해당 타입인지 검사합니다. !는 부정이며 null도 이 검사에서 걸러집니다.
        if (!(obj instanceof Product)) {
            return false;
        }

        // 타입 확인이 끝났으므로 Object 참조를 Product 타입으로 형변환해 필드를 읽습니다.
        Product other = (Product) obj;
        // 객체 참조가 아닌 문자열 내용을 비교해 동등성을 판단합니다.
        return code.equals(other.code);
    }

    @Override
    public int hashCode() {
        // equals에 사용한 필드로 해시를 계산합니다. 동등한 객체는 반드시 같은 해시를 반환해야 합니다.
        return code.hashCode();
    }

    @Override
    // 객체를 println으로 출력할 때 보여 줄 문자열을 정의합니다.
    public String toString() {
        return code + "(" + price + "원)";
    }
}

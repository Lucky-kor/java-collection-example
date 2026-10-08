package set;

import java.util.HashSet;
import java.util.Set;

/** 객체의 동일성(==)과 동등성(equals)을 비교합니다. */
public class SetEqualityExample {
    public static void main(String[] args) {
        // new를 호출할 때마다 새로운 User 객체를 만듭니다.
        User first = new User("lucky");
        // 이름은 같지만 first와는 별개의 객체입니다.
        User second = new User("lucky");

        // ==는 두 변수가 바로 그 같은 객체를 가리키는지 확인합니다.
        System.out.println("같은 객체: " + (first == second));
        // User의 equals에서 이름이 같으면 동등한 사용자로 판단하도록 정의했습니다.
        System.out.println("같은 내용: " + first.equals(second));
        System.out.println("같은 해시: " + (first.hashCode() == second.hashCode()));

        // User 객체를 저장합니다. HashSet의 중복 판단에는 equals와 hashCode가 사용됩니다.
        Set<User> users = new HashSet<>();
        // add는 새 요소를 저장하면 true를 반환합니다.
        System.out.println("첫 추가: " + users.add(first));
        // 이미 동등한 요소가 있으므로 저장하지 않고 false를 반환합니다.
        System.out.println("중복 추가: " + users.add(second));
        System.out.println("size: " + users.size());
        // 다른 객체여도 equals가 true이면 저장된 요소를 찾을 수 있습니다.
        System.out.println("새 동등 객체 조회: " + users.contains(new User("lucky")));
        // 동등한 객체를 전달해 저장된 요소를 삭제합니다. 성공하면 true입니다.
        System.out.println("새 동등 객체 삭제: " + users.remove(new User("lucky")));
    }
}

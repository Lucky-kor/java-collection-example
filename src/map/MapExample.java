package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** Map은 Collection의 하위 타입이 아니며, 키와 값을 연결합니다. */
public class MapExample {
    // 프로그램은 main에서 시작합니다. 아래 메서드를 위에서부터 차례로 호출합니다.
    public static void main(String[] args) {
        keyValueExample();
        entryIterationExample();
    }

    // private은 이 클래스 안에서만 호출 가능, static은 객체를 만들지 않고 호출 가능하다는 뜻입니다.
    // void 메서드는 작업을 수행한 뒤 값을 반환하지 않습니다.
    private static void keyValueExample() {
        System.out.println("\n1. 키로 저장하고 조회하기");

        // 키와 값 모두 문자열인 Map입니다. HashMap은 저장 순서를 보장하지 않습니다.
        Map<String, String> profile = new HashMap<>();
        // name이라는 키에 lucky라는 값을 연결합니다.
        profile.put("name", "lucky");
        profile.put("role", "student");

        // 같은 키에 put하면 값을 교체하고 이전 값 lucky를 반환합니다.
        System.out.println("교체 전 값: " + profile.put("name", "latte"));
        // get에는 키를 전달합니다. 해당 키에 연결된 값을 반환합니다.
        System.out.println("name: " + profile.get("name"));
        // email 키를 저장하지 않았으므로 get 결과는 null입니다.
        System.out.println("없는 키: " + profile.get("email"));
        // 키가 없으면 두 번째 인자로 전달한 미등록을 반환합니다.
        System.out.println("기본값: " + profile.getOrDefault("email", "미등록"));
        // containsKey는 해당 키가 있는지 boolean으로 알려 줍니다.
        System.out.println("키 포함: " + profile.containsKey("role"));
        // containsValue는 해당 값이 하나라도 저장되어 있는지 확인합니다.
        System.out.println("값 포함: " + profile.containsValue("student"));
        // remove는 키의 항목을 삭제하고 이전 값을 반환합니다. 없는 키면 null입니다.
        System.out.println("없는 키 삭제: " + profile.remove("unknown"));
    }

    private static void entryIterationExample() {
        System.out.println("\n2. 키와 값을 함께 순회하기");

        // LinkedHashMap은 기본적으로 키를 삽입한 순서대로 순회합니다.
        Map<String, String> roles = new LinkedHashMap<>();
        roles.put("lucky", "student");
        // 키는 달라야 하지만 값 student는 여러 키에 중복으로 저장할 수 있습니다.
        roles.put("latte", "student");
        // keySet은 키들, values는 값들을 보여 줍니다. values에는 중복도 남습니다.
        System.out.println("키: " + roles.keySet());
        System.out.println("값(중복 유지): " + roles.values());

        // Entry는 키와 값 한 쌍입니다. entrySet에서 항목을 하나씩 꺼냅니다.
        for (Map.Entry<String, String> entry : roles.entrySet()) {
            // 현재 항목의 키는 getKey(), 값은 getValue()로 읽습니다.
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // lucky 키와 그에 연결된 값을 함께 삭제합니다.
        roles.remove("lucky");
        System.out.println("삭제 후 size: " + roles.size());
        // 모든 항목을 삭제합니다. Map 변수 자체가 사라지는 것은 아닙니다.
        roles.clear();
        // isEmpty는 항목 수가 0이면 true를 반환합니다.
        System.out.println("비었는가: " + roles.isEmpty());
    }
}

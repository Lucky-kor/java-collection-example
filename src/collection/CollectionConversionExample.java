package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 컬렉션 변환과 원본에 연결된 view를 구분합니다. 정렬은 sorting에서 다룹니다. */
public class CollectionConversionExample {
    // 프로그램은 main에서 시작합니다. 아래 메서드를 위에서부터 차례로 호출합니다.
    public static void main(String[] args) {
        conversionExample();
        mapViewExample();
    }

    // private은 이 클래스 안에서만 호출 가능, static은 객체를 만들지 않고 호출 가능하다는 뜻입니다.
    // void 메서드는 작업을 수행한 뒤 값을 반환하지 않습니다.
    private static void conversionExample() {
        System.out.println("\n1. 컬렉션 변환과 중복 제거");

        // Arrays.asList는 주어진 값으로 목록을 만듭니다. 여기에는 apple이 두 번 들어 있습니다.
        List<String> fruits = Arrays.asList("apple", "banana", "apple");
        // 처음 등장한 순서를 유지하면서 중복을 제거합니다.
        Set<String> uniqueFruits = new LinkedHashSet<>(fruits);
        // Set의 요소를 새 List에 담습니다. 제거된 중복은 복원되지 않습니다.
        List<String> copiedList = new ArrayList<>(uniqueFruits);

        System.out.println("원본 List: " + fruits);
        System.out.println("중복 제거 Set: " + uniqueFruits);
        System.out.println("다시 List: " + copiedList);

        // String은 키의 타입, Integer는 값의 타입입니다. 과일 이름과 길이를 연결합니다.
        Map<String, Integer> lengths = new LinkedHashMap<>();
        // Set에서 과일 이름을 하나씩 꺼내 fruit에 넣고 반복합니다.
        for (String fruit : uniqueFruits) {
            // put(키, 값)으로 저장합니다. length()는 문자열의 길이를 반환합니다.
            lengths.put(fruit, fruit.length());
        }
        System.out.println("이름 -> 길이: " + lengths);
    }

    private static void mapViewExample() {
        System.out.println("\n2. 원본에 연결된 뷰와 독립된 복사본");

        // String은 키의 타입, Integer는 값의 타입입니다. 과일 이름과 길이를 연결합니다.
        Map<String, Integer> lengths = new LinkedHashMap<>();
        lengths.put("apple", 5);
        lengths.put("banana", 6);

        // keySet()은 키를 보여 주는 뷰입니다. 원본 Map과 연결되어 있습니다.
        Set<String> keysView = lengths.keySet();
        // 새 Set에 키를 복사합니다. 이후 원본에서 키를 삭제해도 이 Set에는 남습니다.
        Set<String> keysCopy = new LinkedHashSet<>(lengths.keySet());

        // 뷰에서 삭제하면 원본 Map에서도 삭제됩니다.
        keysView.remove("apple");
        System.out.println("뷰로 삭제한 Map: " + lengths);
        System.out.println("키 복사본: " + keysCopy);
    }
}

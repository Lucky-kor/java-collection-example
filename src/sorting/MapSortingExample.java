package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** Map의 키 정렬과 값 기준 항목 정렬은 서로 다른 작업입니다. */
public class MapSortingExample {
    public static void main(String[] args) {
        // 과일 이름을 키로, 점수를 값으로 저장합니다. 삽입 순서를 유지하는 Map입니다.
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("banana", 90);
        scores.put("apple", 90);
        scores.put("cherry", 80);

        // TreeMap에 복사하면 값이 아닌 키의 자연 순서로 정렬됩니다.
        System.out.println("키 오름차순: " + new TreeMap<>(scores));

        // 키와 값 한 쌍을 Entry라고 합니다. 항목들을 정렬 가능한 목록으로 옮깁니다.
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());

        // 비교할 대상은 Integer 하나가 아니라 키·값을 가진 Entry입니다.
        Comparator<Map.Entry<String, Integer>> byScoreDescending =
                // 키 타입 String과 값 타입 Integer를 명시합니다. 값 비교를 reversed로 뒤집습니다.
                Map.Entry.<String, Integer>comparingByValue().reversed();
        // 점수 내림차순으로 정렬하고, 점수가 같으면 키의 오름차순으로 비교합니다.
        entries.sort(byScoreDescending.thenComparing(Map.Entry.comparingByKey()));

        // 정렬된 항목을 넣은 순서대로 보관할 Map을 만듭니다.
        Map<String, Integer> sorted = new LinkedHashMap<>();

        // 정렬된 목록에서 항목을 앞에서부터 하나씩 읽습니다.
        for (Map.Entry<String, Integer> entry : entries) {
            // 현재 항목의 키와 값을 새 Map에 넣어 정렬 결과 순서를 보존합니다.
            sorted.put(entry.getKey(), entry.getValue());
        }
        System.out.println("값 내림차순 -> 키 오름차순: " + sorted);
        System.out.println("원본 삽입 순서: " + scores);
    }
}

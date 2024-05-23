package map;

public class MapExampleV1 {
    public static void main(String[] args) {
        // 배열 생성 (키와 값을 각각 별도의 배열에 저장)
        String[] keys = new String[3];
        int[] values = new int[3];

        // 키-값 쌍 추가
        keys[0] = "Alice";
        values[0] = 25;

        keys[1] = "Bob";
        values[1] = 30;

        keys[2] = "Charlie";
        values[2] = 35;

        // 키-값 쌍 출력
        System.out.println("Array Map:");
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i] + ": " + values[i]);
        }
    }
}

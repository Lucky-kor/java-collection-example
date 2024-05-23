package map;

public class MapExampleV2 {
    public static void main(String[] args) {
        // 초기 배열 생성
        String[] keys = {"Alice", "Bob", "Charlie"};
        int[] values = {25, 30, 35};

        // 새 요소 추가를 위해 더 큰 배열 생성
        String[] newKeys = new String[keys.length + 1];
        int[] newValues = new int[values.length + 1];

        // 기존 배열 요소를 새 배열로 복사
        for (int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }

        // 새 키-값 쌍 추가
        newKeys[keys.length] = "David";
        newValues[values.length] = 40;

        // 새 배열의 요소 출력
        System.out.println("New Array Map:");
        for (int i = 0; i < newKeys.length; i++) {
            System.out.println(newKeys[i] + ": " + newValues[i]);
        }

        // "Bob"을 제거하기 위한 새 배열 생성
        String[] smallerKeys = new String[newKeys.length - 1];
        int[] smallerValues = new int[newValues.length - 1];
        int index = 0;
        for (int i = 0; i < newKeys.length; i++) {
            if (!newKeys[i].equals("Bob")) {
                smallerKeys[index] = newKeys[i];
                smallerValues[index] = newValues[i];
                index++;
            }
        }

        // 요소 제거 후 새 배열의 요소 출력
        System.out.println("Array Map after removing Bob:");
        for (int i = 0; i < smallerKeys.length; i++) {
            System.out.println(smallerKeys[i] + ": " + smallerValues[i]);
        }
    }
}

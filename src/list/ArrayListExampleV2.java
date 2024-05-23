package list;

public class ArrayListExampleV2 {
    public static void main(String[] args) {
        // 초기 배열 생성
        String[] fruits = {"Apple", "Banana", "Orange"};

        // 새 요소 추가를 위해 더 큰 배열 생성
        String[] newFruits = new String[fruits.length + 1];

        // 기존 배열 요소를 새 배열로 복사
        for (int i = 0; i < fruits.length; i++) {
            newFruits[i] = fruits[i];
        }

        // 새 요소 추가
        newFruits[fruits.length] = "Grapes";

        // 새 배열의 요소 출력
        System.out.println("Fruits in the new array:");
        for (String fruit : newFruits) {
            System.out.println(fruit);
        }

        // "Banana"를 제거하기 위한 새 배열 생성
        String[] smallerFruits = new String[newFruits.length - 1];
        int index = 0;
        for (int i = 0; i < newFruits.length; i++) {
            if (!newFruits[i].equals("Banana")) {
                smallerFruits[index++] = newFruits[i];
            }
        }

        // 요소 제거 후 새 배열의 요소 출력
        System.out.println("Fruits after removing Banana:");
        for (String fruit : smallerFruits) {
            System.out.println(fruit);
        }
    }
}

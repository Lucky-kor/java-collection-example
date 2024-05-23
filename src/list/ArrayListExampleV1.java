package list;

public class ArrayListExampleV1 {
    public static void main(String[] args) {
        // 배열 생성
        String[] fruits = new String[3];

        // 요소 추가
        fruits[0] = "Apple";
        fruits[1] = "Banana";
        fruits[2] = "Orange";

        // 요소 출력
        System.out.println("Fruits in the array:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
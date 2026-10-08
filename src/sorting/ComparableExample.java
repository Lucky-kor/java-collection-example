package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/** Comparable은 클래스의 기본 순서, Comparator는 용도별 외부 정렬 기준입니다. */
public class ComparableExample {
    // 프로그램은 main에서 시작합니다. 아래 메서드를 위에서부터 차례로 호출합니다.
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("B02", 1000),
                new Product("A01", 2000),
                new Product("C03", 1000));

        // 동일한 제품 목록을 각 메서드에 전달해 정렬 기준에 따른 차이를 비교합니다.
        naturalOrderExample(products);
        comparatorExample(products);
        treeSetExample(products);
    }

    // private은 이 클래스 안에서만 호출 가능, static은 객체를 만들지 않고 호출 가능하다는 뜻입니다.
    // void 메서드는 작업을 수행한 뒤 값을 반환하지 않습니다.
    private static void naturalOrderExample(List<Product> products) {
        System.out.println("\n1. Comparable: 제품 코드로 정렬");

        // 원본 대신 복사본을 정렬해 다음 사례의 시작 데이터가 바뀌지 않게 합니다.
        List<Product> sorted = new ArrayList<>(products);
        // Product에 정의된 compareTo를 이용해 기본 순서인 코드순으로 정렬합니다.
        sorted.sort(Comparator.naturalOrder());
        System.out.println("기본 순서(코드): " + sorted);
    }

    private static void comparatorExample(List<Product> products) {
        System.out.println("\n2. Comparator: 가격과 코드로 정렬");

        // 가격을 먼저 비교하는 기준을 만듭니다. 다음 줄에서 동률 처리 기준을 연결합니다.
        Comparator<Product> byPriceThenCode = Comparator.comparingInt(Product::getPrice)
                // 가격이 같을 때만 제품 코드를 비교합니다.
                .thenComparing(Product::getCode);

        // 원본 대신 복사본을 정렬해 다음 사례의 시작 데이터가 바뀌지 않게 합니다.
        List<Product> sorted = new ArrayList<>(products);
        // 클래스의 기본 순서 대신 여기서 만든 가격·코드 기준을 사용합니다.
        sorted.sort(byPriceThenCode);
        System.out.println("별도 기준(가격 -> 코드): " + sorted);
    }

    private static void treeSetExample(List<Product> products) {
        System.out.println("\n3. TreeSet: 비교 기준에 따른 중복 판정");

        Comparator<Product> byPrice = Comparator.comparingInt(Product::getPrice);
        // 이 TreeSet은 가격만 비교합니다. 비교 결과가 0이면 같은 요소로 취급합니다.
        TreeSet<Product> priceOnly = new TreeSet<>(byPrice);
        // 제품을 한꺼번에 추가합니다. 가격이 같은 두 제품 중 하나는 저장되지 않습니다.
        priceOnly.addAll(products);

        // 가격이 같아도 코드가 다르면 별개의 요소로 저장합니다.
        TreeSet<Product> withCode = new TreeSet<>(byPrice.thenComparing(Product::getCode));
        // 이번 데이터는 코드가 모두 달라 가격·코드 기준으로 세 제품이 모두 저장됩니다.
        withCode.addAll(products);

        System.out.println("가격만 비교한 TreeSet size: " + priceOnly.size());
        System.out.println("가격과 코드 비교 TreeSet size: " + withCode.size());
    }
}

# 자바 컬렉션 학습 가이드

이 프로젝트는 List, Set, Map, Deque의 특징과 사용법을 익힌 뒤, 컬렉션 변환과 정렬을 학습하는 실행 가능한 예제 모음입니다. 실행 전에 결과를 예상하고, 실행 결과와 주석을 비교한 뒤 데이터를 바꾸어 다시 실행하세요.

## 학습 목표

- 순서, 중복, 키 조회, 양 끝 삽입·삭제 요구에 맞게 자료구조를 선택한다.
- 제네릭, 인덱스, 추가·교체·삭제, 순회를 올바르게 사용한다.
- 객체 동일성과 동등성, `equals`와 `hashCode`의 관계를 설명한다.
- 고정 크기 목록, 수정 불가능한 목록, 복사본, 뷰의 차이를 구분한다.
- 자연 순서와 사용자 정의 순서를 구분하고 객체 속성별 정렬 기준을 조합한다.
- 정렬이 원본에 미치는 영향과 정렬 기준에 따른 중복 판정을 설명한다.

## 실행 방법

IntelliJ IDEA에서 프로젝트를 열고 Project SDK를 JDK 17 이상으로 설정하세요. `src` 아래 학습 파일의 `main` 메서드 옆 실행 버튼으로 개별 예제를 실행할 수 있습니다. 예제는 JDK 11 API 범위에서도 컴파일되지만 프로젝트의 기존 IDE 설정은 JDK 17입니다. Maven/Gradle이나 외부 라이브러리는 필요하지 않습니다.

터미널에서는 프로젝트 루트에서 다음 명령을 실행합니다(macOS/Linux).

```sh
mkdir -p out/learning
find src -name '*.java' -print > out/learning/sources.txt
javac -encoding UTF-8 -d out/learning @out/learning/sources.txt
java -cp out/learning list.ArrayListExample
java -cp out/learning sorting.ObjectSortingExample
```

`java` 명령의 마지막 인자를 아래 표의 패키지명과 클래스명으로 바꾸면 됩니다. `User`, `Member`, `Product`는 실행용 클래스가 아닌 데이터 모델입니다.

## 코드를 읽는 방법

각 파일은 하나의 학습 주제를 다룹니다. 여러 사례가 있는 파일은 `main`에서 실행 순서를 보여 주고, 사례별 메서드에서 데이터 준비 → 작업 → 결과 확인 순서로 읽을 수 있게 구성했습니다. 짧은 예제는 `main` 안에서 그대로 읽으면 됩니다.

이 가이드는 프로그래밍 학습 2주 차를 기준으로 작성했습니다. 코드 주석은 타입 선언, 메서드의 인자와 반환값, 반복문, 객체 비교와 정렬 문법을 해당 줄 가까이에서 설명합니다. 자세한 개념, 예상 결과, 시간 복잡도와 실습 과제는 아래 가이드에서 확인하세요. `Product` 같은 데이터 모델은 별도 파일에서 생성자, 속성, 비교 메서드를 읽습니다.

### 낯선 문법을 읽는 순서

| 문법 | 읽는 방법 | 예제 |
| --- | --- | --- |
| `List<String>` | 문자열을 담는 목록 | `GenericsExample` |
| `new ArrayList<>()` | 새로운 ArrayList 객체 생성, 요소 타입은 왼쪽 선언에서 추론 | `GenericsExample` |
| `for (String fruit : fruits)` | 목록에서 값을 하나씩 꺼내 fruit에 넣어 반복 | `CollectionConversionExample` |
| `number -> number >= 3` | number를 받아 조건의 참·거짓을 반환하는 짧은 함수(람다) | `ListMutationExample` |
| `Member::getAge` | 정렬할 Member에서 getAge()로 나이를 읽으라는 메서드 참조 | `ObjectSortingExample` |
| `.thenComparing(...)` | 앞 기준이 동률일 때 다음 기준 사용 | `ObjectSortingExample` |
| `implements Comparable<Product>` | Product가 기본 순서를 제공하도록 compareTo를 구현 | `Product` |

처음에는 1~11단계의 컬렉션 기본 사용법부터 익히세요. 정렬에서는 숫자 정렬 → 단일 속성 정렬 → 다중 조건 정렬 순서로 진행하세요. 스트림 정렬, null 처리, TreeSet의 중복 비교는 기본 예제를 이해한 뒤 다시 읽어도 됩니다. 예제의 `\n`은 출력에서 줄을 바꾸는 문자이고, `println`은 전달한 내용을 출력한 뒤 줄을 바꿉니다.

## 권장 학습 순서

| 순서 | 실행 클래스 / 학습 파일 | 주제 |
| --- | --- | --- |
| 1 | [collection.GenericsExample](src/collection/GenericsExample.java) | 인터페이스, 제네릭, 박싱·언박싱 |
| 2 | [list.ArrayListExample](src/list/ArrayListExample.java) | ArrayList 기본 동작과 인덱스 |
| 3 | [list.ListInsertionAndReplacementExample](src/list/ListInsertionAndReplacementExample.java) | 삽입과 교체 비교 |
| 4 | [list.LinkedListExample](src/list/LinkedListExample.java) | 노드 구조와 순회 비용 |
| 5 | [list.ListMutationExample](src/list/ListMutationExample.java) | 수정 가능 여부와 안전한 삭제 |
| 6 | [set.SetTypesExample](src/set/SetTypesExample.java) | Set 구현체와 순서 |
| 7 | [set.SetEqualityExample](src/set/SetEqualityExample.java), [User](src/set/User.java) | 객체 중복, equals/hashCode |
| 8 | [set.HashCollisionExample](src/set/HashCollisionExample.java) | 해시 충돌 |
| 9 | [map.MapExample](src/map/MapExample.java) | 키·값 저장과 항목 순회 |
| 10 | [deque.DequeExample](src/deque/DequeExample.java) | FIFO 큐, LIFO 스택 |
| 11 | [collection.CollectionConversionExample](src/collection/CollectionConversionExample.java) | 변환, 중복 제거, 뷰와 복사 |
| 12 | [sorting.BasicSortingExample](src/sorting/BasicSortingExample.java) | 숫자·문자열 정렬 |
| 13 | [sorting.ObjectSortingExample](src/sorting/ObjectSortingExample.java), [Member](src/sorting/Member.java) | 객체 속성과 다중 조건 정렬 |
| 14 | [sorting.ComparableExample](src/sorting/ComparableExample.java), [Product](src/sorting/Product.java) | Comparable/Comparator, TreeSet |
| 15 | [sorting.MapSortingExample](src/sorting/MapSortingExample.java) | Map 키·값 정렬 |

## 이름과 폴더 구성 규칙

패키지명은 소문자로 작성하고 학습 주제별로 묶었습니다. 클래스명과 파일명은 `UpperCamelCase`를 사용하며 서로 일치합니다. 실행 예제에는 주제를 설명하는 이름과 `Example` 접미사를 사용합니다. `User`, `Member`, `Product`는 데이터 모델입니다.

| 폴더 / 패키지 | 학습 내용 |
| --- | --- |
| `src/collection` / `collection` | 제네릭과 컬렉션 변환 |
| `src/list` / `list` | List 구현체, 삽입·교체, 수정과 삭제 |
| `src/set` / `set` | Set 구현체, 객체 동등성, 해시 충돌 |
| `src/map` / `map` | Map 기본 사용법 |
| `src/deque` / `deque` | 큐와 스택 |
| `src/sorting` / `sorting` | 기본값·객체·Map 정렬과 비교 기준 |

정렬 예제는 `sorting` 패키지에서 독립적으로 학습합니다. 실행할 때는 학습 순서 표에 있는 현재 패키지명과 클래스명을 사용하세요.

## 1. 자료구조 선택과 제네릭

| 종류 | 중복 | 순서 / 접근 | 대표 구현체 |
| --- | --- | --- | --- |
| List | 허용 | 인덱스와 목록 순서 | ArrayList, LinkedList |
| Set | 허용하지 않음 | 인덱스 없음, 구현체별 순서 차이 | HashSet, LinkedHashSet, TreeSet |
| Map | 키 중복 불가, 값 중복 가능 | 키로 값 조회 | HashMap, LinkedHashMap, TreeMap |
| Deque | 허용 | 양 끝에서 삽입·조회·삭제 | ArrayDeque, LinkedList |

`List`, `Set`, `Queue`는 `Collection` 계열입니다. `Deque`는 `Queue`를 확장하고, `Map`은 `Collection`을 상속하지 않습니다. `Collections`는 `sort` 등의 정적 유틸리티 메서드를 제공하는 클래스입니다.

```java
List<String> names = new ArrayList<>();
List<Integer> scores = new ArrayList<>();
```

왼쪽은 필요한 기능을 표현하는 인터페이스이고 오른쪽은 실제 구현체입니다. 제네릭에는 원시 타입 `int` 대신 참조 타입 `Integer`를 씁니다. `scores.add(90)`에서는 자동 박싱, `int score = scores.get(0)`에서는 언박싱이 일어납니다. `null`인 `Integer`를 언박싱하면 `NullPointerException`이 발생합니다. 타입 인자 없는 raw type은 타입 검사 효과를 잃습니다.

직접 해보기: `names.add(1)`을 주석으로 추가하고 왜 컴파일되지 않는지 설명하세요. `List<String>`의 구현체를 `LinkedList`로 바꾸고 동일한 메서드를 호출할 수 있는지 확인하세요.

## 2. List: 추가, 교체, 삭제와 순회

`add(value)`는 뒤에 추가하고, `add(index, value)`는 지정 위치에 삽입합니다. `set(index, value)`는 기존 요소를 교체하고 이전 값을 반환합니다. 삽입은 크기를 늘리고 교체는 크기를 유지합니다.

- `get`, `set`, `remove(index)`의 인덱스 범위: `0`부터 `size() - 1`
- `add(index, value)`의 인덱스 범위: `0`부터 `size()`
- `indexOf`는 첫 일치 위치를 반환하며 없으면 `-1`
- `remove(2)`는 인덱스 2 삭제, `remove(Integer.valueOf(2))`는 값 2를 처음 발견한 위치에서 삭제

`ArrayListExample`의 핵심 결과는 처음 크기 `0`, 추가 후 `[3, 1, 2, 2]`, 교체·삭제 후 `[10, 2]`입니다. `new ArrayList<>(30)`은 저장 공간의 초기 용량을 지정할 뿐 요소 30개를 생성하지 않습니다. 기본 생성자의 실제 배열 할당 시점과 용량 증가 방식은 구현 세부 사항이므로 요소 수와 혼동하지 마세요.

| 작업 | ArrayList | LinkedList |
| --- | --- | --- |
| 인덱스 조회 | O(1) | O(n) |
| 중간 삽입·삭제 | 요소 이동 O(n) | 위치 탐색 O(n), 찾은 노드 연결 변경 O(1) |
| 뒤에 추가 | 분할 상환 O(1) | O(1) |
| iterator로 전체 순회 | O(n) | O(n) |

ArrayList에서 인덱스 for문 자체가 잘못된 것은 아닙니다. 인덱스가 필요하면 사용하세요. LinkedList에서 `get(i)`를 반복하면 전체 순회 비용은 O(n²)이므로 향상된 for문이나 iterator가 적합합니다. LinkedList는 노드 저장 공간과 연결 참조도 필요하며 중간 삽입이 항상 더 빠르지는 않습니다.

직접 해보기: `ListInsertionAndReplacementExample`의 `add(2, 10)`을 `set(2, 10)`으로 바꾸고 크기와 결과를 비교하세요. 값 2를 두 개 넣은 뒤 값 기반 삭제가 몇 개를 삭제하는지 예상하세요.

## 3. 수정 가능 여부와 안전한 삭제

| 생성 방식 | add/remove | set | null 요소 |
| --- | --- | --- | --- |
| new ArrayList<>(...) | 가능 | 가능 | 허용 |
| Arrays.asList(...) | 크기 변경 불가 | 가능 | 허용 |
| List.of(...) | 불가 | 불가 | 불허 |

`Arrays.asList`는 전달한 배열을 바탕으로 만든 고정 크기 뷰입니다. 배열과 목록의 요소 교체가 서로 반영됩니다. `List.of`는 수정 불가능한 목록을 만들지만, 담긴 객체가 가변 객체라면 그 객체의 속성까지 불변이 되지는 않습니다. `new ArrayList<>(source)`는 별도 컨테이너를 만들되 요소 참조는 공유하는 얕은 복사입니다.

순회 중 구조 변경에는 iterator의 `remove` 또는 `removeIf`를 사용하세요.

```java
numbers.removeIf(number -> number % 2 == 0);
```

향상된 for문 안에서 목록의 `remove`를 직접 호출하면 `ConcurrentModificationException`이 발생할 수 있습니다. 이것은 반드시 여러 스레드가 있어야 발생하는 예외가 아닙니다. 예외 감지에 기대지 말고 올바른 삭제 방식을 사용하세요. 예제에서는 `[1, 2, 3, 4, 5]`가 `[1, 3, 5]`, 다시 `[1]`이 됩니다.

직접 해보기: 삭제 조건을 홀수로 변경하세요. `fixedSizeExample`에서 `fixed.add("D")`, `editableCopyExample`에서 `immutable.set(0, "Z")`를 각각 추가해 예외를 확인한 후 제거하세요.

## 4. Set: 순서, 동등성, 해시 충돌

- HashSet: 순서 보장 없음. 특정 실행에서 보인 순서를 규칙으로 해석하지 않습니다.
- LinkedHashSet: 처음 삽입한 순서 유지. 중복 재추가는 순서를 이동시키지 않습니다.
- TreeSet: 자연 순서 또는 전달한 Comparator에 따른 정렬 순서 유지.

`SetTypesExample`에서 LinkedHashSet은 `[banana, apple, cherry]`, TreeSet은 `[apple, banana, cherry]`입니다. Set의 `add`는 새 요소가 들어가면 `true`, 중복이면 `false`를 반환합니다.

`SetEqualityExample`에서는 서로 다른 `new User("lucky")` 객체가 `==`로는 다르지만 `equals`로는 같습니다. `User`는 이름을 동등성 기준으로 정했기 때문에 HashSet에는 하나만 남고 새 동등 객체로 조회·삭제해도 성공합니다.

**equals가 true이면 hashCode도 같아야 합니다. hashCode가 같다고 equals까지 true인 것은 아닙니다.** `HashCollisionExample`의 `"Aa"`와 `"BB"`는 해시가 같지만 내용이 달라 Set에 둘 다 남습니다.

해시 컬렉션에 저장한 뒤 동등성·해시에 사용하는 속성을 바꾸면 검색이나 삭제가 실패할 수 있습니다. 그래서 User의 이름을 `final`로 지정했습니다. 실제 사용자 모델에서는 이름 중복을 고려해 고유 ID 등을 기준으로 정해야 합니다.

직접 해보기: 이름이 다른 User를 추가하세요. `equals`와 `hashCode` 중 하나만 이름 기준으로 구현하면 왜 문제가 되는지 설명하세요. TreeSet의 중복 판정은 14단계에서 따로 확인합니다.

## 5. Map과 Deque

Map의 `put`은 같은 키가 있으면 값을 덮어쓰고 이전 값을 반환합니다. `get`은 없으면 `null`을 반환합니다. HashMap은 null 값도 허용하므로 `get` 결과만으로 키 존재를 판정할 수 없고 `containsKey`로 확인해야 합니다. `getOrDefault`는 키가 없을 때 기본값을 사용하며, 키가 존재하고 값이 null이면 null을 반환합니다.

키와 값을 함께 읽을 때는 `entrySet`을 순회하세요. `values`는 값 중복을 유지하므로 Set이 아닌 Collection입니다. HashMap은 순서를 보장하지 않고 LinkedHashMap은 기본적으로 삽입 순서를 유지합니다. `MapExample`의 역할 값 목록은 `[student, student]`입니다.

Deque에서는 FIFO(먼저 넣은 값을 먼저 꺼냄)를 `offerLast`/`pollFirst`, LIFO(마지막에 넣은 값을 먼저 꺼냄)를 `push`/`pop`으로 표현할 수 있습니다. `peekFirst`는 제거하지 않고 조회합니다. 빈 Deque에서 `pollFirst`는 null을 반환하고 `pop`/`removeFirst`는 예외를 던집니다. ArrayDeque는 null을 허용하지 않습니다.

직접 해보기: Map의 동일 키에 세 번 값을 넣고 크기가 증가하는지 확인하세요. 요청 세 개를 큐와 스택에 넣고 처리 순서를 비교하세요.

## 6. 컬렉션 변환과 뷰

`CollectionConversionExample`은 List → LinkedHashSet → List로 중복을 제거하면서 처음 등장한 순서를 유지합니다. Set → Map에서는 과일 이름을 키, 이름 길이를 값으로 저장합니다. 서로 다른 이름의 길이가 같아도 값은 중복 가능하므로 문제가 없습니다.

```java
Set<String> keysView = lengths.keySet();
Set<String> keysCopy = new LinkedHashSet<>(lengths.keySet());
```

`keySet`, `values`, `entrySet`은 원본 Map에 연결된 뷰입니다. 예제의 `keysView.remove("apple")`는 원본 Map에서도 apple을 제거하지만 keysCopy에는 apple이 남습니다. 수정 불가능한 Map의 뷰는 삭제도 허용하지 않습니다. 키 뷰에는 값 없이 항목을 만들 수 없으므로 `add`를 지원하지 않습니다.

직접 해보기: 뷰와 복사본을 만든 뒤 원본 Map에 새 키를 추가하세요. 어느 쪽에서 새 키가 보이는지 예상하세요. 가변 객체를 담은 List의 복사본에서 객체 속성을 바꾸면 원본에서도 보이는 이유를 설명하세요.

## 7. 정렬 기초: 숫자와 문자열

정렬 예제는 컬렉션 기본 동작과 분리한 `sorting` 패키지에 있습니다.

| 방식 | 의미 | 원본 변경 |
| --- | --- | --- |
| Collections.sort(list) | 자연 순서로 정렬 | 변경 |
| list.sort(comparator) | 지정 기준으로 정렬 | 변경 |
| stream().sorted() / sorted(comparator) | 정렬한 스트림 생성 | 목록 순서는 유지 |

별도 결과가 필요하면 복사본을 정렬하거나 정렬 스트림을 새 목록으로 수집합니다. 복사본도 기본적으로 얕은 복사입니다. `List.of`는 직접 정렬할 수 없고 ArrayList로 복사해야 합니다. Arrays.asList는 요소 교체를 지원하므로 정렬할 수 있습니다.

Integer의 자연 순서는 숫자 오름차순입니다. String의 자연 순서는 UTF-16 값에 기반한 사전식 순서이므로 대소문자를 구분하며 사람이 기대하는 언어별 사전 순서와 항상 같지는 않습니다. 예제는 `[Apple, apple, banana]`를 출력합니다.

직접 해보기: 음수와 같은 숫자를 추가하세요. 대소문자 무시 비교에서 `Apple`과 `apple`의 기존 상대 순서가 유지되는지 확인하세요.

## 8. 객체의 속성으로 정렬하기

`ObjectSortingExample`은 같은 Member 원본에서 복사본을 만들어 기준별 결과를 비교합니다. Member에는 이름(String), 나이(int), 점수(int)가 있습니다.

| 기준 | Comparator 표현 |
| --- | --- |
| 이름 오름차순 | Comparator.comparing(Member::getName) |
| 이름 내림차순 | Comparator.comparing(Member::getName).reversed() |
| 나이 오름차순 | Comparator.comparingInt(Member::getAge) |
| 점수 내림차순 | Comparator.comparingInt(Member::getScore).reversed() |
| 나이 오름차순, 동률이면 이름 오름차순 | Comparator.comparingInt(Member::getAge).thenComparing(Member::getName) |

`Member::getAge`는 해당 객체의 나이를 꺼내는 메서드 참조입니다. `member -> member.getAge()`와 같은 역할을 합니다. `comparingInt`는 int 속성을 직접 비교합니다. long에는 `comparingLong`, double에는 `comparingDouble`을 사용할 수 있습니다.

```java
Comparator<Member> ranking = Comparator.comparingInt(Member::getScore)
        .reversed()
        .thenComparingInt(Member::getAge)
        .thenComparing(Member::getName);
```

위 기준은 점수 내림차순 → 같은 점수면 나이 오름차순 → 둘 다 같으면 이름 오름차순입니다. **reversed를 체인 전체 끝에 붙이면 전체 기준의 방향이 뒤집힙니다.** 일부 기준만 내림차순이면 해당 비교기에 reversed를 붙인 다음 연결하세요.

예제 데이터의 점수 순위는 `바닐라(7,95)` → `김라떼(7,90)` → `김러키(7,90)` → `김러키(8,90)` → `한여름(9,80)`입니다(괄호는 나이, 점수). 나이만 정렬하면 나이 7인 세 사람의 기존 상대 순서가 유지됩니다. List 정렬은 안정 정렬이므로 비교 결과가 0인 요소의 상대 순서를 보존합니다.

비교 결과는 음수(앞에 배치), 0(해당 기준 동률), 양수(뒤에 배치)로 해석합니다. 정확히 -1과 1만 반환해야 하는 것은 아닙니다. `(a, b) -> a.getAge() - b.getAge()`는 정수 오버플로우로 잘못된 순서를 만들 수 있어 `Integer.compare` 또는 `comparingInt`를 사용하세요. 비교기는 일관된 기준과 추이성을 만족해야 합니다.

### null을 허용하는 데이터 정렬

```java
// 목록의 요소 자체가 null인 경우
Comparator<Member> nullMembersLast = Comparator.nullsLast(
        Comparator.comparing(Member::getName));

// 객체는 존재하지만 이름 속성이 null인 모델을 사용하는 경우
Comparator<Member> nullNamesLast = Comparator.comparing(
        Member::getName, Comparator.nullsLast(Comparator.naturalOrder()));
```

현재 Member는 null 이름을 거부하므로 속성 null 코드는 다른 모델을 위한 참고입니다. 실행 예제에서는 null이 포함된 문자열 목록을 정렬합니다. `nullsLast` 비교기 전체를 reversed하면 null 위치도 앞쪽으로 바뀝니다. 내림차순에서도 null을 마지막에 두려면 `Comparator.nullsLast(Comparator.reverseOrder())`처럼 내부 기준을 뒤집으세요.

직접 해보기:

1. 나이 내림차순 → 점수 내림차순 → 이름 오름차순을 작성하세요.
2. 같은 점수·나이를 가진 사람을 추가하고 이름 기준이 적용되는지 확인하세요.
3. reversed를 전체 체인 끝으로 옮겨 결과를 비교하세요.
4. 원본 목록을 직접 sort하는 경우와 복사본을 sort하는 경우를 비교하세요.

## 9. Comparable과 Comparator, 정렬된 Set의 중복

`Comparable<T>`의 `compareTo`는 클래스가 제공하는 기본 순서입니다. `Comparator<T>`는 클래스 밖에서 여러 목적에 맞는 기준을 제공합니다. Member는 기본 순서를 강제하지 않고 Comparator로만 정렬합니다. `ComparableExample`의 Product는 코드로 자연 순서를 정의하고, 가격 정렬에는 별도 Comparator를 사용합니다.

TreeSet과 TreeMap은 비교 결과 0을 같은 요소/키로 취급합니다. Product 세 개의 가격이 1000, 2000, 1000일 때 가격만 비교하는 TreeSet에는 두 개만 남습니다. 가격 다음 코드까지 비교하면 세 개가 남습니다. List에서는 동률이어도 요소가 사라지지 않습니다.

정렬된 Set/Map을 일반적인 Set/Map 계약에 맞게 쓰려면 비교 결과 0과 equals의 동등성이 일치하도록 기준을 설계해야 합니다. Product의 기본 순서와 equals는 모두 코드를 사용합니다. 가격 비교기는 학습용이며 코드가 같은데 가격이 다른 객체까지 고려하면 equals와 일치하지 않을 수 있습니다. 단순 출력 순서만 바꾸려는 목적이라면 List 정렬을 사용하세요.

직접 해보기: 모든 Product 가격을 같게 바꾸고 가격만 비교한 TreeSet 크기를 예상하세요. 기본 순서와 별도 가격 순서를 말로 설명하세요.

## 10. Map의 키·값 정렬

`new TreeMap<>(scores)`는 키의 자연 순서로 정렬합니다. 값으로 정렬하려면 `entrySet`을 목록으로 옮겨 정렬한 다음 LinkedHashMap에 순서대로 넣습니다.

```java
Comparator<Map.Entry<String, Integer>> byScoreDescending =
        Map.Entry.<String, Integer>comparingByValue().reversed();
entries.sort(byScoreDescending.thenComparing(Map.Entry.comparingByKey()));
```

예제 결과는 값 내림차순 → 같은 값이면 키 오름차순인 `{apple=90, banana=90, cherry=80}`입니다. HashMap에 다시 넣으면 이 순서를 보장하지 않습니다. LinkedHashMap은 넣은 순서를 유지할 뿐 이후 추가·값 변경 시 정렬을 자동으로 다시 수행하지 않습니다. Map.Entry 목록 복사는 원본 항목과 완전히 독립된 객체 복사가 아니므로 `entry.setValue` 같은 변경에도 주의하세요.

직접 해보기: 키 내림차순 TreeMap을 만들어 보세요. 값 오름차순 → 키 내림차순으로 기준을 바꾸세요. 정렬한 LinkedHashMap에 높은 점수의 새 항목을 넣고 위치를 확인하세요.

## 최종 점검 질문

1. Collection, Collections, Map은 어떻게 다른가요?
2. List와 Set의 중복·인덱스 규칙은 무엇인가요?
3. ArrayList의 capacity와 size는 어떻게 다른가요?
4. add(index, value)와 set(index, value)는 크기에 어떤 영향을 주나요?
5. List<Integer>에서 인덱스가 아닌 값으로 삭제하려면 어떻게 하나요?
6. LinkedList에서 get(i) 반복 순회의 비용은 왜 커지나요?
7. Arrays.asList와 List.of는 어떤 변경을 허용하나요?
8. 얕은 복사와 원본에 연결된 뷰는 어떻게 다른가요?
9. 순회 중 요소 삭제에는 어떤 방법을 사용하나요?
10. equals가 true인데 hashCode가 다르면 왜 문제가 되나요?
11. 해시 충돌이 발생해도 서로 다른 객체를 저장할 수 있는 이유는 무엇인가요?
12. Map에서 없는 키와 null 값인 키를 어떻게 구분하나요?
13. FIFO와 LIFO는 꺼내는 순서가 어떻게 다른가요?
14. sort와 stream.sorted는 원본 목록에 어떤 영향을 주나요?
15. Comparable과 Comparator는 각각 어디에 정렬 기준을 두나요?
16. thenComparing은 언제 다음 기준을 사용하나요?
17. reversed의 위치에 따라 다중 조건의 방향은 어떻게 달라지나요?
18. 정수 비교에 뺄셈을 쓰면 어떤 문제가 생길 수 있나요?
19. TreeSet에서 가격만 비교하면 왜 서로 다른 제품이 빠질 수 있나요?
20. Map을 값으로 정렬한 결과의 순서를 보존하려면 어떤 구현체를 쓰나요?

답하기 어렵다면 해당 파일로 돌아가 출력 예상 → 실행 → 이유 설명 → 값 변경 순서로 반복하세요.

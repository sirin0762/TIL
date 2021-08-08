## java.util.function 패키지

- java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
- 제네릭 메서드로 정의되어 타입에 얽메이지 않는다.
- 자주 쓰이는 함수형 인터페이스들

  | 함수형 인터페이스 | 메서드            | 설명                                                                |
  | ----------------- | ----------------- | ------------------------------------------------------------------- |
  | Runnable          | void run()        | 매개변수(X), 반환값(X)                                              |
  | Suppiler`<T>`     | T get()           | 매개변수(X), 반환값(O)                                              |
  | Consumer`<T>`     | T accept()        | 매개변수(O), 반환값(X)                                              |
  | Function`<T, R>`  | R apply(T t)      | 하나의 매개변수를 받아서 결과를 반환, 가장 일반적임                 |
  | Predicate`<T>`    | boolean test(T t) | 조건식을 표현하는데 사용됨(if랑 연계), 매개변수(O), 반환값(boolean) |

  > 타입문자 T는 Type을, R은 Return을 의미한다

```java
public class Main {

    public static void main(String[] args) {
        // 내부에 get 함수
        Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;

        // 내부에 accept 함수
        Consumer<Integer> c = (i) -> System.out.print(i + " ");

        // 내부에 test 함수
        Predicate<Integer> p = (i) -> i % 2 == 0;

        // 내부에 apply 함수
        Function<Integer, String> f = (i) -> i.toString();

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<String> newList = doSomething(f, list);
        System.out.println(newList);

    }

    private static <T, R> List<R> doSomething(Function<T, R> f, List<T> list) {
       List<R> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            newList.add(f.apply(list.get(i)));
        }

        return newList;
    }

    private static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            if(p.test(list.get(i))){
                c.accept(list.get(i));
            }
        }
    }

    private static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
```

## 스트림

- 데이터 소스마다의 다른 방식으로 다루는 것을 통합함
- 데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메서드 들을 정의함

```java
public class Main {

    public static void main(String[] args) {
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        // 스트림의 사용 예시
        Stream<String> strStream1 = strList.stream();
        Stream<String> strStream2 = Arrays.stream(strArr);
    }
}
```

### 특징

- 스트림은 데이터 소스를 변경하지 않는다(깊은 복사같은 건가?).
- 스트림은 일회용이다(Iterator 처럼).

```java
public class Main {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList(strArr);
        Stream<String> strStream1 = strList.stream();
        strStream1.forEach((i) -> System.out.println(i));
        strStream1.forEach((i) -> System.out.println(i));   // 에러, 스트림은 일회용이라서 닫힘

    }
}
```

- 스트림은 작업을 내부 반복으로 처리한다.
- 지연된 연산(Lazy Evaluation)
- 병렬 스트림
  - parallel() 메서드 : 병렬 처리
  - sequential() 메서드(default) : 직렬처리
- Stream<Integer>와 IntStream : 박싱의 비효율을 줄이기 위해 primitive 요소를 기본형으로 다루는 Int, Long, Double 스트림이 존재

### 스트림 만들기 : 컬렉션

- 컬렉션의 최고 조상인 Collection에 stream()이 정의되어 있음
- stream()은 해당 컬렉션을 소스로 하는 스트림을 반환함

```java
public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // forEach 가 스트림의 요소를 소모하기 때문에 다시 호출하려면 새로 stream을 만들어야함.
        list.stream().forEach(System.out::println);
    }
}
```

### 스트림 만들기 : 배열

- 배열을 소스로 스트림을 생성하는 메서드는 Stream과 Arrays에 static 메서드로 정의되어있다.

```java
public class Main {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1);
        Stream<Integer> stream1 = Stream.of(new Integer[]{1, 2, 3});
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3});
    }
}
```

- IntStream과 LongStream은 특정 범위의 연속된 정수를 스트림으로 생성해서 반환하는 range()와 rangeClosed()를 가지고 있다.

```java
public class Main {

    public static void main(String[] args) {
        IntStream intStream1 = IntStream.of(new int[]{1, 2, 3});
        IntStream intStream2 = Arrays.stream(new int[]{1, 2, 3});

        // start ~ end - 1
        IntStream intStream3 = IntStream.range(1, 3);

        // start ~ end
        IntStream intStream4 = IntStream.rangeClosed(1, 3);

        intStream3.forEach(System.out::println);
        intStream4.forEach(System.out::println);

    }
}
```

### 스트림 만들기 : 람다식 iterate(), generate()

- iterate()와 generate()는 람다식을 매개변수로 받아서 람다식에 의해 계산되는 값을 요소로 하는 무한 스트림을 생성

```java
public class Main {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, n -> n + 2)
                .limit(10);

        Stream<Double> stream1 = Stream.generate(() -> Math.random()*10)
                .limit(10);

        // 에러 : Int, Long, DoubleStream은 iterate, generate 사용불가
        IntStream stream2 = Stream.generate(() -> 3);

        // OK :` 바꾸려면 mapping을 해주어야함
        IntStream intStream = Stream.generate(() -> 3)
                .mapToInt(i -> i);

    }
}
```

### 스트림의 중간 연산 - Comparator의 메서드

- JDK 1.8 부터 Comparator 인터페이스에 생긴 static 메서드와 default 메서들을 사용
- 가장 기본적인 메서드는 comparing() 이다. comparing의 매게 변수는 Function 인터페이스를 이용하여(apply 함수) 정렬 할 키에 관한 람다식을 만들어서 주면 된다.

```
public class Main {

    public static void main(String[] args) {
        Stream<Student> students = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 2, 250),
                new Student("신자바", 1, 323),
                new Student("박자바", 1, 322),
                new Student("민자바", 3, 390),
                new Student("송자바", 4, 400),
                new Student("여자바", 2, 180),
                new Student("강자바", 1, 70),
                new Student("류자바", 4, 310)
        );

        // ban에 관해서 정렬
        students.sorted(Comparator.comparing(new Function<Student, Integer>() {
            @Override
            public Integer apply(Student student) {
                return student.getBan();
            }
        })).forEach(i -> System.out.println(i.toString()));


    }
}
```

- 여러번의 기준이 필요할 때는 thenComparing() 메서드를 사용

```java
public class Main {

    public static void main(String[] args) {
        Stream<Student> students = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 2, 250),
                new Student("신자바", 1, 323),
                new Student("박자바", 1, 322),
                new Student("민자바", 3, 390),
                new Student("송자바", 4, 400),
                new Student("여자바", 2, 180),
                new Student("강자바", 1, 70),
                new Student("류자바", 4, 310)
        );

        students.sorted(Comparator.comparing((Student student) -> student.getBan())
                .thenComparing(Comparator.reverseOrder()))
                .forEach(i -> System.out.println(i.toString()));

    }
}
```

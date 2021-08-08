
## Optional

- Optional`<T>`는 `T 타입의 객체`를 감싸는 레퍼클래스이다. 따라서 Optional 타입의 객체에는 모든 타입의 객체를 담을 수 있다.

```java
// Optional 클래스
public final class Optional<T> {
    private final T value;  // T 타입의 참조변수
    ...
}
```

- Optional 객체로 반환하기 때문에 내부 데이터가 없어도 NPE가 일어나지 않는다.

### Optional`<T>` 객체 생성하기

- Optional 객체를 생성할 때는 of() 또는 ofNullable()을 사용한다.

```java
public class Main {

    public static void main(String[] args) {
        String str = "abc";
        Optional<String> optVal = Optional.of(str);
        Optional<String> optVal = Optional.of("str");
        Optional<String> optVal = Optional.of(new String("abc"));
    }
}
```

- 참조변수의 값이 null 일 가능성이 있으면 of 대신 ofNullable()을 사용해야한다.

```java
public class Main {

    public static void main(String[] args) {
        Optional<String> optVal = Optional.of(null);    // NPE 발생
        Optional<String> optVal2 = Optional.ofNullable(null);    // OK
    }
}
```

### Optional`<T>` 객체의 값 가져오기

- Optional 객체에 저장된 값을 가져올 때는 get() 메서드를 사용한다.
- 값이 null 일 때는 NoSuchElementException 이 발생한다. 이를 대비해서 orElse()로 대체할 값을 지정할 수 있다.

```java
public class Main {

    public static void main(String[] args) {
        Optional<String> optVal = Optional.of("abc");
        String str1 = optVal.get();
        String str2 = optVal.orElse("");    // optVal 내부 객체가 없으면 "" 전달

    }
}
```

- isPresent() 메서드로 값이 있는지 없는지 검사할 수 있다.

### collect() 와 Collectors

- collect()는 스트림의 요소를 수집하는 최종 연산으로, 어떻게 요소를 수집하는가에 대한 방법이 정의 되어 있어야한다.
- 위에서 말한 방법을 정의 한 것이 collector이다.
- collector는 Collector 인터페이스를 구현 한 것으로, 직접 구현 할 수도 있고, 미리 작성된 것을 사용할 수도 있다.
  > collect() : 스트림의 최종연산, 매개변수로 컬렉터를 필요로한다.  
  > Collector : 인터페이스, 컬렉터는 이 인터페이스를 구현해야한다.  
  > Collectors : 클래스, static 메서드로 미리 작성된 컬렉터를 제공한다.

### 스트림을 컬렉션, 배열로 반환

- 스트림의 모든 요소를 컬렉션에 수집하려면, Collectors 클래스의 toList() 같은 메서드를 사용하면 된다.

```java
public class Main {

    public static void main(String[] args) {
        Stream<Student> students = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 2, 250),
                new Student("류자바", 4, 310)
        );

        List<String> names = students.map(student -> student.getName())
                .collect(Collectors.toList());

        ArrayList<String> list = names.stream().collect(Collectors.toCollection(() -> new ArrayList<>()));

        Student[] stuNames = students.toArray(Student[]::new);

    }
}
```

### Todo : 스트림의 메서드

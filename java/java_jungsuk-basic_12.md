# 12강 : 제네릭스, 열거형, 에너테이션

## 제네닉스

- 제네릭스는 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일시의 타입 체크를 해주는 기능이다.
- 객체의 타입을 컴파일 시에 치크하기 때문에 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어든다.

### 용어 정리
```java
class Box<T> {}
```
  - Box<T> : 제네릭 클래스, `T Box`라고 읽는다.
  - T : 타입 변수, 타입 매개변수.
  - Box : 원시타입

  
  
```java
  Box<String> b = new Box<String>();
  Box<Integer> b2 = new Box<Integer>
```
  - 서로 다른 타입을 대입하여 호출함
  - 컴파일 후에 Box<String>, Box<Integer>는 이들의 '원시타입'인 Box로 바뀐다. 즉, 지네릭 타입이 제거된다.
  
### 제네릭 타입과 다형성
- 참조변수의 제네릭 타입과, 생성자의 제네릭 타입은 일치해야한다.
```java
ArrayList<Tv> tvList = new ArrayList<Tv>(); 

// 에러 : Tv와 Product가 상속 관계라도 에러
ArrayList<Product> tvList2 = new ArrayList<Tv>();   

// 에러 X : 클래스간의 다형성은 당연히 됨
List<Tv> tvList = new ArrayList<Tv>();
```

### 제네릭의 제약
- 제네릭은 모든 객체에 적절한 형변환은 도와준다
- 허나 static은 모든 객체에 동일한 메서드, 필드이기 때문에 제네릭을 활용한 표현은 불가능하다.
```java
class Box<T> {
    static T item // 에러
    static int compare(T t1, T t2){}    // 에러
}
```

- new 연산자와 instanceof 연산자는 제네릭과 같이 사용될 수 없다.
- 위의 2개의 연산자는 컴파일 시점에 타입 T가 뭔지 알아야하나, 컴파일 시점에서의 T가 어떤 타입이 될지 알 수 없다.
```java
class Box<T> {
    T[] itemArr;

    T[] toArray(){
        T[] temArr = new T[itemArr.length]; // 에러

        return temArr;
    }
}
```

### 와일드 카드
- 와일드 카드 기호 `?` 는 제네릭 타입에 다형성을 불어넣어 준다

    > `<? extends T>` : 와일드 카드의 상한 제한, T와 그 자손들만 가능   
    > `<? super T>` : 와일드 카드의 하한 제한, T와 그 조상들만 가능   
    > `<?>` : 제한 없음, 모든 타입이 가능, `<? extends Objects>` 와 동일

```java
public class Main {

    public static void main(String[] args) {
        System.out.println(Juicer.makeJuice(new FruitBox<Banana>()));   // Ok
        System.out.println(Juicer.makeJuice(new FruitBox<Apple>()));    // Ok
    }

    static Juice makeJuice(FruitBox<? extends Fruit> box){
        //
    }
}
```

### 제네릭 메서드
- 지네릭 메서드는 static 메서드에 지네릭을 사용하게 만들어 준다.
```java
static <T> void sort(List<T> list, Comparator<? super T> c)
```

## 6장 : 객체 지향 프로그래밍(1)
- 객체가 가지고 있는 속성과 기능을 그 객체의 `멤버` 라고 한다.
```java
public class User {

    // 속성 = 맴버 변수, 필드 등의 이름으로 불림
    private String user;
    private String id;
    private int age;

    public User(String user, String id, int age) {
        this.user = user;
        this.id = id;
        this.age = age;
    }


    // 기능 = 메서드
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
```
- 객체 VS 인스턴스 : 객체는 인스턴스를 포함하는 개념, 클래스를 사용한 결과물이다. 인스턴스는 메모리에 올라간 객체를 말한다
```java
public class Main {
    public static void main(String[] args) {
        // 객체 선언
        User user;
        
        // 인스턴스화(메모리에 올라감)
        user = new User("yongjin", "sirin", 26);
    }
}
```
- 한 파일에 여러 클래스를 작성할 경우, public class의 이름은 소스파일명과 같아야한다. 
  
작성 예시 | 설명
---|:---:
`Main.java` | public class가 있는 경우, 소스파일의 이름은 반드시 public 클래스의 이름과 일치해야한다.
`Main.java` | public class가 없는 경우, 소스파일의 이름은 가지고 있는 클래스 중 하나와 일치해야한다.

### 객체의 생성과 사용
```java
public class Main {
    public static void main(String[] args) {
        Tv t;                     // Tv 인스턴스를 참조하기 위한 변수 t를 선언(메모리 주소를 들고있는 친구)
        t = new Tv("Samsung");    // Tv 인스턴스를 생성 후 해당 메모리 주소를 t에게 전달
        t.channel = 7;                  
        t.channelDown();
        System.out.println(t.channel);     // 7

        Tv t2;
        t2 = new Tv("LG");
        System.out.println(t2.channel);     // 0

    }
}

class Tv {
    String maker;
    boolean power;
    int channel;

    public Tv(String maker) {
        this.maker = maker;
    }

    void power(){
        power = !power;
    };

    void channelUp(){
        this.channel++; // this 안써도 됨 : this 주로 필드(전역변수)와 메소드 또는 생성자의 매개변수가 동일할 때 
                                        // 인스턴스 필드임을 명확히 하기 위해 사용한다.
    }

    void channelDown(){
        this.channel--;
    }
}
```

### 선언 위치에 따른 변수의 종류
```java
class Tv {
    String maker;   // 인스턴스 변수
    boolean power;
    int channel;

    static int width = 100;   // 클래스 변수

    void method() {
        int cv = 0; // 지역변수
    }
}
```

변수의 종류 | 선언 위치 | 생성 시기
:---:|:---:|:---:
클래스 변수 | 클래스 영역 | 클래스가 메모리에 올라갈 때
인스턴스 변수 | 클래스 영역 | 인스턴스가 생성되었을 때
지역변수 | 클래스 영역 이외의 영역(메서드, 생성자, 초기화 블럭 내부) | 변수 선언문이 수행되었을 때

### 호출 스택
호출 스택은 메서드의 작업에 필요한 메모리 공간을 제공한다. 메서드가 호출 되면 호출스택에 호출된 메서드를 위한 메모리가 할당되며, 이 메모리를 메서드가 작업을 수행하는 동안 지역변수(매개변수 포함)들과 연산의 중간 결과등을 저장하는데 사용된다. 그리고 메소드가 작업을 마치면 메모리공간이 반환되어 비어진다.   
```java
public class Main {
    // 1.
    public static void main(String[] args) {
        // 2.
        System.out.println("Hi");
        // 3.
    }
}
```
1. JVM에 위해서 main 메소드가 호출되며 프로그램이 시작된다. 이 때 main메서드를 위한 메모리 공간이 할당되고 main메서드의 코드가 수행되기 시작한다.
2. main메소드에서 println을 호출한 상태이다. 아직 main메서드가 끝난 것은 아니므로 main메서도는 호출스택에 대기상태로 남아있고 println이 수행된다.
3. println 메서드의 수행이 완료되어 호출스택에서 반환되고 main 메서드로 되돌아간다. 이후 더 이상 수행할 코드가 없기에 호출스택은 완전히 비워지게 되고 프로그램은 종료한다.

### 기본형 매개변수
자바에서는 메서드를 호출할 때 매개변수로 지정한 값을 메서드의 매개변수에 복사해서 념겨준다. 매개변수의 타입이 기본형일 때는 기본형 값이 복사되겠지만, 참조형이라면 인스턴스 주소가 복사된다.
- _기본형 매개변수_ : 변수의 값을 릭기만 할 수 있다.(Read only)
- _참조형 매개변수_ : 변수의 값을 읽고 변경할 수 있다.(Read & write)

### Static을 언제 붙여야할까?
1. 클래스를 설계할 때, 맴버변수 중 모든 인스턴스에 공통으로 사용되는 것에 static을 붙인다.
    - 생성된 각 인스턴스는 서로 독립적, 즉 각 인스턴스의 변수들은 서로 다른값을 유지한다. 하지만 같은 값을 유지해야하는 변수는 static을 붙여서 클래스 변수로 정의해야한다.
2. 클래스 변수는 인스턴스를 생성하지 않아도 사용할 수 있다.
3. 클래스 메서드는 인스턴스 변수를 사용할 수 없다.
    - 인스턴스를 생성해서 메모리에 올려야 인스턴스 변수를 사용할 수 있는데, static은 그전에 메모리에 올리기 때문에 메모리에 없는 변수를 쓰려고 하는 것과 같다.
    - 인스턴스 변수나 인스턴스 메서드에서는 static이 붙은 멤버들을 사용하는 것이 언제나 가능하다. 인스턴스가 생성되기 이전에 클래스 멤버가 메모리에 올라가있기 때문이다.
4. 메서드에서 인스턴스 변수를 사용하지 않는다면 static을 사용하는 것을 고려한다.
```java
class testClass {
    void instanceMethod(){}
    static void staticMethod(){}
    
    void instanceMethod2(){
        instanceMethod();
        staticMethod();
    }
    
    static void staticMethod2(){
        staticMethod();
        instanceMethod();   // 에러 : 인스턴스 메서드 호출 불가
    }
}

```

### 오버로딩
*오버로딩이란?* : 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것을 메서드 오버로딩이라고 함
- 조건
    1. 메서드 이름이 같아햐한다.
    2. 매개변수의 개수 or 타입이 달라야한다.
    3. 반환 타입은 관계없다.

### 생성자
생성자는 인스턴스가 생성될 때 호출되는 `인스턴스 초기화 메서드`이다. 따라서 인스턴스변수의 초기화 작업에 주로 사용되며, 인스턴스 생성 시에 실행되어야 하는 작업을 위해서도 사용된다.   
생성자의 조건은 다음과 같다.
1. 생성자의 이름은 클래스의 이름과 같아야한다.
2. 생성자는 리턴값이 없다.

연산자 new가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것이 아니다. 생성자는 단순히 인스턴스변수들의 초기화에 사용되는 조금 특별한 메서드일 뿐이다.

### 기본 생성자
모든 클래스에는 하나 이상의 생성자가 정의되어 있어야한다.허나 클래스에 생성자를 정의하지 않고도 인스턴스를 생성할 수 있었던 이유는 컴파일러가 제공하는 `기본 생성자` 덕분이다.   

컴파일 할 때, 소스파일의 클래스에 생성자가 하나도 정의되지 않은 경우 컴파일러는 자동적으로 아래와 같은 내용의 기본 생성자를 추가하여 컴파일한다.
```java
class Data_1{
    int value;
    // 기본생성자 Data_1(){} 가 컴파일시 생성
}

class Data_2 {
    int value;
    
    Data_2(int value){
        this.value = value;
    }
}
```

### 생성자에서 다른 생성자 호출하기 - this()
같은 클래스의 ㅁ매버들 간에 서로 호출할 수 있는 것 처럼 생성자 간에도 서로 호출이 가능하다. 단, 다음의 두 조건을 만족 시켜야한다.
1. 생성자의 이름으로 클래스이름 대신 this를 사용한다.
2. 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.
```java
    public Car(String color) {
        door = 5;
        Car(color, "auto". 4);  // 에러 1. 생성자의 두 번째 줄에서 다른 생성자 호출
                                // 에러 2. this를 사용해야함
    }
```
_예시_
```java
public class Car {
    String color;
    String gearType;
    int door;

    public Car() {
        this("white", "auto", 4);
    }

    public Car(String color) {
        this(color, "auto", 4);
    }

    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car("blue");
        Car c3 = new Car("black", "manual", 2);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}

// 결과값
Car{color='white', gearType='auto', door=4}
Car{color='blue', gearType='auto', door=4}
Car{color='black', gearType='manual', door=2}

```

### this
this는 인스턴스 자신을 가리키는 참조변수로 인스턴스의 주소가 저장되어있다. 생성자를 포함한 모든 인스턴스메서드에는 자신이 관련된 인스턴스를 가리키는 참조변수 this가 지역변수로 숨겨진 채 존재한다.
- this : 인스턴스 자신을 가리키는 참조변수
- this(), this(매개변수) : 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.

### 멤버 변수의 초기화
멤버 변수의 초기화 순서는 다음과 같다
1. 클래스 변수 초기화 -> 인스턴스 변수 초기화
2. 자동 초기화(각 타입의 기본값) -> 명시적 초기화 -> 초기화 블록, 생성자)
_예시_
```java
public class Main {

    static {
        System.out.println("static {}");
    }

    {
        System.out.println("{}");
    }

    public static void main(String[] args) {
        System.out.println("---------------------");
        Main m = new Main();

        System.out.println("---------------------");
        Main m2 = new Main();
    }
}
// 결과값
static {}
---------------------
{}
---------------------
{}

```
예시가 실행되면서 Main이 메모리에 로딩될 때, 클래스 초기화 블럭이 가장 먼저 수행되어 `static {}`이 화면에 출력된다. 그 다음에 인스턴스가 생성되면서 `{}`가 출력된다.

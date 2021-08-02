## 객체 지향 프로그래밍(2)

### 포함
상속이외에도 클래스를 재사용하는 또 다른 방법이 있는데, 그것은 클래스 안에 포함관계를 맺어 주는 것이다. 클래스 간의 포함관계를 맺어 주는 것은 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻한다.
```java
class Point {
    int x;
    int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 포함
class Circle {
    Point p = new Point();
    int r;
}
```

### 클래스 간의 관계 결정하기
클래스간의 관계를 설계 할 때, 포함을 할지 상속을 할지를 고민해야한다. 그럴 때는 아래와 같이하면 된다.
- 상속관계 : ~은 ~이다.
- 포함관계 : ~은 ~을 가지고 있다.

> `원은 점이다` 보단 `원은 점을 가지고 있다`가 어울리기 때문에 포함관계로 작성하는 것이 좋다.   

> `SportsCar는 Car이다`는 `SportsCar는 Car를 가지고 있다` 보다 어울리기 때문에 상속관계로 작성하는 것이 좋다.

### Object 클래스
Object 클래스는 모든 클래스 상속계층도의 최상위에 있는 조상 클래스이다. 다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동적으로 Object클래스로부터 상속받게 함으로써 이것을 가능하게 한다.   
```java
// 컴파일러가 Class Point extends object 로 바꾼다.
class Point {
    int x;
    int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```
Object 클래스에 주요 메서드로는 toString(), equals() 등이 있다.

### 오버라이딩
부모가 가진 메서드를 자식클래스에서 변경하여 사용하는 것을 오버라이딩이라고 한다.
```java
class Point2D {
    int x;
    int y;

    public Point2D() {
        x = 0;
        y = 0;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation(){
        return "x : " + this.x + ", y : " + this.y;
    }
}

class Point3D extends Point2D {
    int z;

    public Point3D(int z) {
        this.z = z;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    
    // 오버라이딩(override)
    String getLocation(){
        return "x + " + this.x + ", y : " + this.y + ", z : " + this.z;
    }
}
```
오버라이딩을 위한 조건으로는
1. 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경 할 수 없다.
2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.
3. 선언부가 조상 클래스의 메서드와 일치해야 한다. 

### 참조 변수 super
super는 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수이다. 멤버변수와 지역변수의 이름이 같을 때 this를 붙여서 구별했듯이 상속받은 멤버와 자신의 멤버와 이름이 같을 때는 super를 붙여서 구분할 수 있다.
```java
public class Main {

    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    }
}

class Parent {
    int x = 10;
}

class Child extends Parent {
    int x = 20;

    void method(){
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x);
    }
}
```

### super() 생성자
super() 는 조상의 생성자를 호출하는데 사용된다.(this()는 같은 클래스 내의 다른 생성자를 참조할 때 사용) 참고로 생성자는 상속되지 않는다.
```java
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
```
### 다형성
다형성이란 `여러가지 형태를 가질 수 있는 능력`을 의미하며, 자바에서는 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함으로써 구현했다.
```java
public class Main {

    public static void main(String[] args) {
        Tv t = new SmartTv("Samsung", true, 3, "Samsung TV");
        SmartTv s = new Tv("Lg", false, 0); // 에러 : 자손타입의 참조변수는 부모 인스턴스 생성 불가
    }
}

class Tv {
    String maker;
    boolean power;
    int channel;

    public Tv(String maker, boolean power, int channel) {
        this.maker = maker;
        this.power = power;
        this.channel = channel;
    }
}

class SmartTv extends Tv {
    String caption;

    public SmartTv(String maker, boolean power, int channel, String caption) {
        super(maker, power, channel);
        this.caption = caption;
    }
    
    void setCaption(){
        //
    }
}

```

### 참조변수의 형변환
자손 - 조상 타입의 경우라면, 형변환이 가능하다. 직접 부모 자식간의 관계가 아닐지라도 형변환이 가능하다.
```java
public class Main {
    public static void main(String[] args) {
        // Car의 인스턴스 생성
        Car c = new Car();
        // FireEngine 인스턴스 생성
        FireEngine fe = new FireEngine();
         
        // fe의 인스턴스 주소를 c에 배정
        c = fe;
        
        // fe의 인스턴스 주소를 가지고 있기 때문에 형변환하여 fe2에게 주는 것 가능
        FireEngine fe2 = (FireEngine)c;
        
        // FireEngine의 멤버 사용가능
        fe2.water();

    }
}

class Car {
    String color;
    int door;

    void drive(){
        System.out.println("Drive");
    }

    void stop(){
        System.out.println("Stop");
    }
}

class FireEngine extends Car {
    void water(){
        System.out.println("water~");
    }
}
```

### 인터페이스
인터페이스는 추상클래스보다 추상화 정도가 높아서 추상클래스와 달리 몸통을 갖춘 일반 메서드 또는 맴버변수를 구성원으로 가질 수 없다. 또한, 오직 추상메서드와 상수만을 멤버로 가질 수 있다.   
인터페이스를 작성하는 것은 클래스를 작성하는 것과 같다. 다만 접근제어자로 public 또는 default만 사용할 수 있다. 다음과 같은 제약사항이 있다.
- 모든 멤버변수는 public static final 이어야 하며, 이를 생략할 수 있다.
- 모든 메서드는 public abstract 이어야하며, 이를 생략할 수 있다.(단, static 메서드와 디폴트 메서드는 예외)
```java
public interface PlayingCard {
    public static final int SPADE = 4;
    final int DIAMOND = 3;
    static int HEART = 2;
    int CLOVER = 1;

    public static String getCardNumber() {
        return null;
    }

    String getCardKind();
}
```
아래 [참고자료](https://limkydev.tistory.com/197) 
- 상수 : 인터페이스에서 값을 정해줄테니 함부로 바꾸지 말고 제공해주는 값만 참조해라 (절대적)
- 추상메소드 : 가이드만 줄테니 추상메소드를 오버라이팅해서 재구현해라. (강제적)
- 디폴트메소드 : 인터페이스에서 기본적으로 제공해주지만, 맘에 안들면 각자 구현해서 써라. (선택적)
- 정적메소드 : 인터페이스에서 제공해주는 것으로 무조건 사용 (절대적)

### 인터페이스의 상속
인터페이스는 인터페이스로 부터만 상속을 받을 수 있다. 클래스와는 달리 다중 상속이 가능하다.
```java
interface Movable {
    void move(int x, int y);
}

interface Attackable {
    void attack(Unit u);
}

public interface Fightable extends Movable, Attackable{
}
```
클래스의 상속과 마찬가지로 부모가 가지고 있는 모든 맴버를 가지게 된다. 그래서 Fightable 인터페이스는 두 개의 추상메서드(move, attack)을 가진다.

### 인터페이스의 구현
만약 구현하는 인터페이스의 메서드 중 일부만 구현한다면, abstract를 붙여서 추상클래스로 선언해야한다.
```java
// 인터페이스의 메서드 모두 구현
public class Fighter extends Unit implements Fightable{
    @Override
    public void move(int x, int y) {
        
    }

    @Override
    public void attack(Unit u) {

    }
}
// 인터페이스의 메서드 일부 구현
abstract public class Fighter extends Unit implements Fightable{
    
    @Override
    public void attack(Unit u) {

    }
}
```

### 디폴트 메서드와 static 메서드
디폴트 메서드는 추상클래스와는 달리 기본적인 구현을 제공하는 메더으이다. 추상 메서드가 아니기 때문에 디폴트 메서드가 새로 추가되어도 해당 인터페이스를 구현한 클래스를 변경하지 않아도 된다.
```java
interface Attackable {
    // 추상 메서드
    void attack(Unit u);
    
    // 디폴트 메서드
    default void defaultMethod(){}
}
```
대신 새로 추가된 디폴트 메서드가 기존의 메서드와 이름이 중복되어 충돌하는 경우가 발생했다. 이 충돌을 해결하는 방법은 다음과 같다.
1. 여러 인터페이스의 디폴트 메서드 간의 충돌
    - 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩 해야한다.
2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
    - 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.

### 익명 클래스
익명클래스는 이름이 없다. 클래스의 선언과 객체의 생성을 동시에 하기 때문에 단 한번만 사용할 수 있고 오직 하나의 객체만을 생성할 수 있는 일회용 클래스이다.   
```java
new 조상클래스이름(){
    // 멤버 선언
}

new 구현인터페이스이름(){
    // 멤버 선언
}
```

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

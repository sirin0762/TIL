## 싱글톤
싱글톤은 클래스의 인스턴스를 하나만 생성되도록 보장하는 방식이다. 예를 들면 설정 파일의 경우, 여러 곳에서 다른 객체로 생성되면 설정이 뒤얽힌다. 이럴 때 싱글톤 패턴을 쓰면 된다. 아래는 싱글톤 패턴을 구현하는 몇가지 방법을 제시한다.

### 1. Eager Initialization(이른 초기화, Thread-safe)
```java
public class Singleton {
    private static Singleton singleton = new Singleton();

    // 생성자 잠금
    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }
}
```
이른 초기화 방식은, static의 특징을 이용하여 컴파일 때 해당 인스턴스를 메모리에 등록해서 사용하는 방식이다. 컴파일로 인해 최초로 로딩 될때만 객체가 생성되기 때문에 Thread-safe 하다.  

### 2. Lazy Initialization with synchronized(동기화 블럭, Thread-safe)
```java
public class Singleton {
    private static Singleton singleton;

    // 생성자 잠금
    private Singleton(){}
    
    public static synchronized Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
```
동기화 블록 방식은 인스턴스를 미리 생성하는 것이 아니라, 동기화 키워드를 이용해 Thread-safe를 보장한다. 단, 동기화 키워드는 성능이 약 100배 가량 떨어진다고 한다... 동기화 키워드를 잘 모른다면 
[여기!](https://tourspace.tistory.com/54) 를 참고하면 좋다.

### 3. Lazy Initialization, Double Checking Locking(DCL, Thread-safe)
```java
public class Singleton {
    private static volatile Singleton singleton;

    // 생성자 잠금
    private Singleton(){}

    public Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        
        return singleton;
    }
}
```
2번의 동기화 블럭 방식을 개선한 방식이다. 인스턴스가 생성되지 않은 경우에만 동기화를 하여 실행된다. volatile 키워드를 이용하여 CPU-cache 에서의 변수값 불일치 문제를 막는다. volatile 키워드는 
[여기](https://nesoy.github.io/articles/2018-06/Java-volatile)

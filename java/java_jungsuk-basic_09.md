# 9장. java.lang 패기지와 유용한 클래스
java.lang 패키지는 자바프로그래밍에 가장 기본이 되는 클래스들을 포함하고 있다. 그렇게 때문에 java.lang 패키지는 import문 없이도 사용가능하다.

## Object 클래스의 메서드
Object클래스는 모든 클래스의 최고 조상이기 때문에 Object클래스의 맴버들은 모든 클래스에서 바로 사용가능하다.

### equals()
매게변수 객체의 참조변수를 받아서 비교하는 기능이다. 바로 아래의 코드는 Object 클래스의 equals() 메서드 이다.
```java
public boolean equals(Object obj){
  return(this==obj);
}
```
코드를 보면, 정말 참조변수를 비교하는 기능밖에 없다. 따라서 Value 를 비교하고 싶다면 오버라이딩해서 사용해야한다.
```java
class Student {
    int id;
    
    // id 값으로 비교하기 위해 오버라이딩
    @Override
    public boolean equals(Object o) {
        // 형병환이 되는가?
        if(o instanceof Student)
            return id == ((Student)o).id;
        else
            return false;
    }

    public Student(int id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(26);
        Student s2 = new Student(26);
        
        // 객체의 id 값으로 비교하기 때문에 true
        if(s1.equals(s2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
```
### hashCode()
객체의 주소값을 이용해서 해시코드를 만들어 주는 기능. 주소가 아닌, 인스턴스 변수값으로 객체의 같고 다름을 판단해야하는 경우라면 equal 메소드 뿐만아니라 hashCode메서드도 적절히 오버라이딩 해야한다. 같은 객체라면 hashCode메서드를 호출했을 때의 결과값인 해시코드도 같아야 하기 때문이다.
```java
public class Main {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");
        
        // String 클래스의 equals() 메서드는 문자열의 값을 비교하도록 오버라이딩 되어있음
        System.out.println(str1.equals(str2));
        
        // String 클래스는 같은 문자열이면 해시코드도 같게 오버라이딩 되어있음
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
    }
}

// 결과값
true
96354
96354
366712642
1829164700
```
```java
class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Member){
            Member member = (Member) o;
            return name.equals(member.name) && (age == member.age
            ); 
        }
        else {
            return false;
        }
    }
    
    // 이렇게 Value가 같으면 hashCode도 같게 설정
    @Override
    public int hashCode(){
        Objects.hash() : 주어진 인자들로 배열을 만들어 Arrays.hashCode()의 인자로 해시코드 생성
        return Objects.hash(name, age);
    }
}
```
### toString()
인스턴스에 대한 정보를 문자열로 제공하기 위한 메서드이다. 바로 밑의 코드는 Object 클래스의 toString() 메서드로, 클래스 이름과 해시코드를 합쳐 리턴하는 기능이다. 일반적인 객체의 값을 보기위해서는 오버라이딩해서 객체의 필드(속성)을 보여주는 방식으로 바꿔줘야한다.
```java
public String toString(){
  return getClass().getName()+"@"+Integer.toHexString(hashCode());
}
```
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        
        // 두 객체의 주소값이 다르니 해시코드도 다르게 나옴
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}

// 결과(@ 이후 값 : )
com.programmers.java.Student@15db9742
com.programmers.java.Student@6d06d69c
```
```java
class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // 객체의 필드(속성)이 리턴되도록 오버라이딩
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

## StringBuffer와 StringBuilder

### StringBuffer
StringBuffer 는 내부적으로 문자열 편집을 위한 buffer를 가지고 있다. 인스턴스 생성시에 그 크기 지정이 가능하다.
```java
public class TestStringBuffer {
    public static void main(String[] args) {
        // default(buffer의 기본 크기값은 16이다)
        StringBuffer sb = new StringBuffer();
        
        // 문자열을 바로 StringBuffer 클래스로(버퍼의 크기는 문자열의 길이 + 16이다)
        StringBuffer sb = new StringBuffer(String str);
        
        // 버퍼 크기 지정
        StringBuffer sb = new StringBuffer(int length);
        
        // 버퍼 크기 확인
        System.out.println(sb.capacity());

    }
}
```
아래의 코드는 StringBuffer클래스의 일부인데, 버퍼의 크기를 변경하는 내용의 코드이다. 만약 버퍼의 크기보다 더 많은 문자열 연산이 들어온다면, 내부적으로 버퍼의 크기를 증가시키는 작업이 수행된다. 배열의 길이는 변경될 수 없으므로 새로운 배열을 생성하여 이전 배열의 값을 복사한다.
```java
char newValue[] = new char[newCapacity];

System.arraycopy(value, 0, newValue, 0 , count);
value = newValue;
```

### StringBuffer의 비교
String 클래스에서는 equals 메서드를 오버라이딩해서 문자열의 내용을 비교하도록 구현되어 있지만, StringBuffer 클래스는 equals메서드를 오버라이딩 하지않아서 equals 메서드와 등가비교연산자(==)가 같은 결과를 얻는다. 따라서 StringBuffer를 비교하려면, toString 메서드로 문자열로 바꾼뒤 String클래스의 equals() 메서드로 비교해야한다.
```java
public class HelloWorld {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");

        // 두 인스턴스의 주소가 다르기 때문에 둘다 false
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        System.out.println(sb1.toString() == sb1.toString());

        // 두 인스턴스의 주소는 다르나, String 클래스는 Value로 비교하기 때문에 true
        System.out.println(sb1.toString().equals(sb2.toString()));
    }
}
// 결과값
false
false
false
true
```
### StringBuilder
StringBulilder 는 StringBuffer에서 동기화 키워드를 빼 싱글쓰레드 환경에서 더 빠르게 동작하도록 만들어진 클래스이다. 정리하면
- String : 문자열 연산(X)
- StringBuffer : 문자열 연산(O), 멀티쓰레드 환경
- StringBulider : 문자열 연산(O), 싱글쓰레드거나 동기화를 고려하지 않을 경우

### 성능차이 확인
```java
class Timer {
    private long startTime;
    private long endTime;

    public void startClock(){
        startTime = System.currentTimeMillis();
    }

    public void endClock(){
        endTime = System.currentTimeMillis();
    }

    public void printClock(String prompt){
        System.out.println(prompt + ": " + (endTime - startTime) + " ms");
    }
}

public class Main {
    private static final int LOOP_TIME = 50_000;

    public static void main(String[] args) {
        //
        Timer timer = new Timer();
        StringBuilder stringBuilder = new StringBuilder();

        timer.startClock();
        for (int i = 0; i < LOOP_TIME; i++) {
            stringBuilder.append("count").append(i).append("end");
        }
        timer.endClock();
        timer.printClock("StringBuilder");

        //
        StringBuffer stringBuffer = new StringBuffer();

        timer.startClock();
        for (int i = 0; i < LOOP_TIME; i++) {
            stringBuilder.append("count").append(i).append("end");
        }
        timer.endClock();
        timer.printClock("StringBuffer");


        String str = "";

        timer.startClock();
        for (int i = 0; i < LOOP_TIME; i++) {
            str += "count" + i + "end";
        }
        timer.endClock();
        timer.printClock("String");


    }
}

// 결과값
StringBuilder: 11 ms
StringBuffer: 7 ms
String: 5006 ms
```
---

## 래퍼(Wrapper) 클래스
기본형 변수도 객체로 다룰 때 사용한다. 예를 들면 매개변수로 객체를 요구할 때, 기본형 값이 아닌 객체로 저장해야할 때, 객체간의 비교가 필요할 때 등등의 경우에는 기본형 값들을 객체로 변환하여 작업을 수행해야한다. 이 때 사용하는 것이 Wraaper 클래스이다.
![image](https://user-images.githubusercontent.com/60607880/127960207-a1214916-462b-4551-917a-77ecb184700c.png)

- BigInteger : long을도 다룰 수 없는 큰 범위의 정수
- BigDecimal : double로도 다룰 수 없는 큰 범위의 부동 소수점수

### AutoBoxing 과 UnBoxing
- Boxing : Primitive -> Wrapper
- UnBoxing : Wrapper -> Primitive

JDK 1.5 이후부터 primitive와 Wrapper의 자동 변환을 통한 덧셈이 가능해졌지만, 성능면을 고려할 때, 개발자가 직접 명시해주는 것이 좋다.
- 명시적 선언 : 직접 타입에 대해 케스팅함
- 묵시적 선언 : AutoBoxing 이라고 하며, 캐스팅하지 않아도 알아서 타입변환이 일어남

```java
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);  // 오토박싱
        
        int value = arrayList.get(0);   // 언박싱

    }
}
```

### 성능확인
- autoBoxing이라고 하나, 개발자가 명시해준것과 프로그램이 변환해주는 것은 성능차이가 생길 수 밖에 없다.
```java
public class Main {
    private static final int LOOP_TIME = 100_000_000;

    public static void main(String[] args) {
        Timer timer = new Timer();

        // 명시적
        timer.startClock();
        long sum = 0L;

        for (long i = 0; i < LOOP_TIME; i++) {
            sum += i;
        }
        timer.endClock();
        timer.printClock("명시적");

        // 묵시적
        Long sum2 = 0L;
        timer.startClock();

        for (long i = 0; i < LOOP_TIME; i++) {
            sum2 += i;
        }
        timer.endClock();
        timer.printClock("묵시적");
    }
}

//결과값
명시적: 32 ms
묵시적: 536 ms
```


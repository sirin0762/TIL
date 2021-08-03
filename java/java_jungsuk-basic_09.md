#9장. java.lang 패기지와 유용한 클래스
java.lang 패키지는 자바프로그래밍에 가장 기본이 되는 클래스들을 포함하고 있다. 그렇게 때문에 java.lang 패키지는 import문 없이도 사용가능하다.

## object 클래스
Object클래스는 모든 클래스의 최고 조상이기 때문에 Object클래스의 맴버들은 모든 클래스에서 바로 사용가능하다.

## Object 클래스의 메서드

### equals()
매게변수 객체의 참조변수를 받아서 비교하는 기능이다.
```java
public boolean equals(Object obj){
  return(this==obj);
}
```
코드를 보면, 정말 참조변수를 비교하는 기능밖에 없다. 따라서 Value 값을 비교하고 싶다면 Overriding해서 사용해야한다.
```java
package com.programmers.java;

class Student {
    int id;
    
    // id 값으로 비교하기 위해 오버라이딩
    @Override
    public boolean equals(Object o) {
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

        if(s1.equals(s2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
```
### hashCode()
객체의 주소값을 이용해서 해시코드를 만들어 주는 기능. 클래스의 주소가 아닌, 클래스의 인스턴스 변수값으로 객체의 같고 다름을 판단해야하는 경우라면 equal 메소드 뿐만아니라 hashCode메서드도 적절히 오버라이딩 해야한다.
같은 객체라면 hashCode메서드를 호출했을 때의 결과값인 해시코드도 같아야 하기 때문이다.
```java
public class Main {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");
        
        // String 클래스는 같은 문자열이면 해시코드도 같게 오버라이딩 되어있음
        System.out.println(str1.equals(str2));
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
        return age + name.hashCode();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
```
### toString()
인스턴스에 대한 정보를 문자열로 제공하기 위한 메서드이다.
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

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```


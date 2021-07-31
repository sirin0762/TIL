## 자바의 정석 1 ~ 5 장 모르는 것만

### 1장
- 자바는 JVM을 통해서 java를 실행시킨다. 즉 운영체제에 종속되있지 않고 JVM에 종속되어있다. 따라서 어느 운영체제이든 그 운영체제에 맞는 JVM이 필요하다.
- 자바를 실행하기 위해선 일단 자바 컴파일러를 통해 바이너리 파일을 만든 뒤, 이를 JIT 컴파일을 통해 컴퓨터 언어로 변환, 실행 한다.
- javac.exe : 소스파일을 클래스 파일로(바이너리 파일)
- java.exe : 클래스 파일을 기계어로 변역 후 실행

### 2장
- 리터럴 : 그 자체로 값을 의미하는 것
```java
public class Main {
    public static void main(String[] args) {
        
        // CONST : 상수, var : 변수, 100_000_000 : 리터럴(값 그 자체, 일상생활에서 말하는 상수 개념)
       final int CONST = 100_000_000;
       int var = 100_000_000;
    }
}
```
- 8진수는 0을 붙인다.
```java
public class Main {
    public static void main(String[] args) {
        
        // 8진수로 10, 10진수로 8
       int octNum = 010;

       System.out.println(octNum);
    }
}
```
- float는 뒤에 f를 붙여줘야한다. double은 스킵할 수 있다.
```java
public class Main {
    public static void main(String[] args) {

        // float는 리터럴 뒤에 f를 붙여야한다.
        float wrongFloat = 1.234;   // 오류 발생
        float rightFloat = 1.234f;

        // double은 스킵할 수 있다.
        double d1 = 1.234;
        double d2 = 1.234d;
    }
}
```
- 기본형 8개를 제외한 나머지를 참조형이라고 한다. 참조형이라 부르는 이유는 실제 값을 가지고 있는것이 아닌 값의 주소를 가지고 있기 때문이다.
- 타입간의 변환방법
  - 숫자 -> 문자 : 숫자에 '0'을 더한다.
  - 문자 -> 숫자 : 문자에 '0'을 뺸다.
  - 숫자 -> 문자열 : 숫자에 ""를 더한다.
  - 문자열 -> 숫자 : Integer.parseInt() 또는 Double.parseDouble()을 사용한다.
  - 문자열 -> 문자 : charAt() 메서드를 활용한다.
  - 문자 -> 문자열 : 빈 문자열을 더한다.
```java
    public class Main {
    public static void main(String[] args) {
        // 숫자 -> 문자
        System.out.println(5 + '0');
        
        // 문자 -> 숫자
        System.out.println('5' - '0');
        
        // 숫자 -> 문자열
        System.out.println(3 + "");
        
        // 문자열 -> 숫자
        System.out.println(Integer.parseInt("5"));
        
        // 문자열 -> 문자
        System.out.println("512".charAt(0));
        
        // 문자 -> 문자열
        System.out.println('5' + "");
    }
}
```
  
### 3장 : 연산자
- 자동 형변환 : 서로 다른 타입간의 대입이나 연산을 할 때, 사용자가 형변환을 하지 않아도 기존의 값을 최대한 보존할 수 있는 타입으로 자동 형변환 된다. 즉, 보통은 더 큰 타입의 타입으로 형변환 된다.
  - 규칙 1. 두 피연산자의 타입을 같게 일치시킨다(보다 큰 타입으로 일치).
  - 규칙 2. 두 피연산자의 타입 모두 int 보다 작은 타입이면 int로 변환되어 더해진다.

### 5장 : 배열
- 배열은 기본형이 아니다. 따라서 배열의 변수명은 메모리 주소를 들고있다.
- String 클래스는 char배열에 여러가지 기능을 추가하여 확장한 것이다. 객체지향개념이 나오기 이전의 언어들은 데이터와 기능을 따로 다뤘지만, 객체지향부터는 클래스로 같이 다루기 때문에 이와같이 되었다.
- String 클래스는 변경 불가하다(immutable);
  

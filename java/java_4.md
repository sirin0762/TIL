## 연산자

### 자료형 다시 정리
- 기본적으로 정수를 나타내는 자료형이 많은 이유는 각 자료형이 차지하는 메모리 공간의 크기가 다르기 때문
- double형이라도 너무 큰 수를 저장하고자 하면 잘못된 계산 결과가 나올 수 있음
- 소수점 표기형식을 지수 형식으로 출력하고 싶으면 %e를 사용하면됨
- 자바에서 String은 내부적으로 char의 배열로 이루어져있음 그렇다면 String의 최대 크기는 어떻게 될까(답 : 약 4Gbyte 정도 담을 수 있음)
- String은 클래스 기반의 비원시 자료형임

### 작은 따옴표와 큰 따옴표 차이
- 큰따옴표의 경우 문자열로 인식하여 두 문자가 합쳐져서 결과가 표시됩니다.
- 작은따옴표의 경우는 + 연산자를 사용하면 H와 a는 Integer 형으로 형변환 되어 169가 출력됩니다.

```java
        System.out.println("H" + "a");
        System.out.println('H' + 'a');
        System.out.println('H'+0);
        System.out.println('a'+0)
[출처] [JAVA] 큰따옴표와  작은따옴표의 차이|작성자 오픈소스 Factory

// 출력
Ha
169
72
97
```

### 산술 연산자
- + : 덧셈
- - : 뺄셈
- * : 곱
- / : 몫
- % : 나머지

### 증감 연산자
- ++ : 해당 변수에 +1 
- -- : 해당 변숭에 -1
- a++ : 먼저 더함
- ++a : 변수를 사용이후 1을 더함

### 그 외의 연산자
- [대입 연산자](http://tcpschool.com/java/java_operator_assignment)
- [비교 연산자](http://tcpschool.com/java/java_operator_comparison)
- [논리 연산자](http://tcpschool.com/java/java_operator_logic)
- [비트 연산자](http://tcpschool.com/java/java_operator_bitwise)
- [기타 연산자(삼항, instanceof)](http://tcpschool.com/java/java_operator_etc)

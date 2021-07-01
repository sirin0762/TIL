## 자바 배열 선언
```java
//크기 할당 & 초기화 없이 배열 참조변수만 선언 
int[] arr; 
int arr[]; 

// 선언과 동시에 배열 크기 할당 
int[] arr = new int[5]; 
String[] arr = new String[5]; 

// 기존 배열의 참조 변수에 초기화 할당하기 
int[] arr; arr = new int[5]; //5의 크기를 가지고 초기값 0으로 채워진 배열 생성 

// 선언과 동시에 배열의 크기 지정 및 값 초기화 
int[] arr = {1,2,3,4,5}; 
int[] arr = new int[] {1,3,5,2,4}; 
int[] odds = {1,3,5,7,9}; 
String[] weeks = {"월","화","수","목","금","토","일"}; 

// 2차원 배열 선언 
int[][] arr = new int[4][3]; //3의 크기의 배열을 4개 가질 수 있는 2차원 배열 할당 
int[][] arr9 = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3}, {3, 4, 5}}; //arr[0] >> {2, 5, 3}; //arr[1] >> {4, 4, 1}; //arr[2] >> {1, 7, 3}; //arr[3] >> {3, 4, 5};

출처: https://ifuwanna.tistory.com/231 [IfUwanna IT]
```

## Java 컬렉션 정리
[Java 컬렉션 정리](https://gangnam-americano.tistory.com/41?category=976803)

## Java 오름차순 내림차순 정리
[Java 오름차순, 내림차순 정리](https://lifelife7777.tistory.com/112)

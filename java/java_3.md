## 자료형

### 변수에 관한 기본 상식
- 자바에서는 변수 초기화를 하지 않으면 사용할 수 없다.
- 정수를 나타내는 타입만 해도 short, int, long으로 다양하다.
- 정수 변수안에 실수를 넣으면 정부 부분만 변수에 저장된다.
- 실수 값을 반올림 하고 싶으면 변수에 0.5를 더한 뒤에 정수형으로 형변환 하면 된다(ex : (int)(실수 + 0.5)).

### 형변환
```java
public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 오류 발생
		int a = 0.5;
		
	}

}

-------------------------------------------------
public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0.5를 정수형으로 형변환, 정수부분만 변수에 들어감. 따라서 a
		int a = (int)(0.5);
		
	}

}
```
### 자료형
![image](https://user-images.githubusercontent.com/60607880/123044919-4ae7ea00-d435-11eb-9a4f-7ad4c3a2e961.png)    
[float과 double의 차이](https://devlog-wjdrbs96.tistory.com/254)   
char의 경우 ascii 코드를 따르므로 숫자를 더해주면 해당 ascii 코드에 맞는 문자가 된다. 아래 예를 보자
```java
public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(char i = 'a'; i <= 'z'; i++) {
			System.out.print(i + " ");
		}
		
	}

}
// 출력
a b c d e f g h i j k l m n o p q r s t u v w x y z 
```

### 진수 변경 출력
자바에서는 c언어와 같이 printf 기능이 있다. 또한 System.out.format 이라는 함수도 존재하는데 이 둘은 완전히 같다고 보면된다. 문자열에 들어가는 % 개수만큼 `,` 이후의 매개변수의 개수가 같아야 한다().   
```java
public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 200;
		
		System.out.println("10진수 : " + a);
		System.out.printf("8진수 : %o\n", a);
		System.out.format("16진수 : %x", a);
		
	}

}
```

### String
String은 비원시값으로 내부적으로 메소드를 가지고 있다(클래스임) 따라서 String의 메소드를 몇가지 알아두면 좋다.
```java
public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // substring(정수) : 정수인덱스부터 ~ 문자열 끝까지 잘라줌.
		String name = "용진";
		System.out.println(name.substring(1));
		
	}

}
```








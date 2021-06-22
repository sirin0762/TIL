## 변수, 상수

### 변수
String은 원시값이 아님
```java
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int int_type = 100;
		double double_type = 150.5;
		String string_type = "신용진";
		
		System.out.println(int_type);
		System.out.println(double_type);
		System.out.println(string_type);
	}
}
```

### 상수
상수는 final 키워드를 통해서 정의한다(js로 치면 const)   
```java
public class Main {
	
	final static double PI = 3.141592;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
```

### static
스태틱은 모든 객체가 공유하는 자원으로 만들겠다는 의미
```java
public class HousePark  {
    String lastname = "박";

    public static void main(String[] args) {
        HousePark pey = new HousePark();
        HousePark pes = new HousePark();
    }
}
// --------------------------------------------

public class HousePark  {
    static String lastname = "박";

    public static void main(String[] args) {
        HousePark pey = new HousePark();
        HousePark pes = new HousePark();
    }
}
```  
위와 같은 예제에서는 생성된 모든 객체가 '박' 이라는 값을 각각 메모리에 저장하고 있지만, 밑과 같이 static을 붙여버리면 모든 객체가 해당 값을 들고 있는 것이 아닌 '박' 문자열은 하나의 메모리에만 존재하고 참조하는 형식으로 바뀐다.   
즉, 모든 객체에서 공유하고 있기 때문에 섣불리 변경하면 안된다. 이를 위해서 final키워드로 변경 불가능 하게 만드는 방법이 있다.

### 오버플로우
각각의 자료형은 byte 수가 지정되어 있기 때문에 범위가 유한함 만약 범위를 넘은 값이 들어오면 원하지 않는 값으로 변함
```java
public class Main {
	
	final static int INT_MAX = 2147483647;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = INT_MAX;
		System.out.println(a);
    // 순환 구조라서 가장 큰 값에서 가장 작은 값으로 넘어감
		System.out.println(a + 1);
		
	}

}
// 출력
2147483647
-2147483648

```


## 기본 입출력
자바에서는 대표적으로 Scanner 클래스를 이용하여 사용자와 상호작용 할 수있음.   

```java
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
    // 정수 입력
    int i = sc.nextInt();
    sc.close();
		
	}

}
```   

- 기본적으로 모듈을 들고와야함(java.util.scanner)
- System.in : [System.in 내부를 파고들자](https://st-lab.tistory.com/41)

### 파일 입출력

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 파일클래스로 파일 들고옴
		File file = new File("input.txt");
		// scanner 입력의 파일넣기
		try {
			Scanner sc = new Scanner(file);
			// 다음에 읽어올 정수가 있으면 반복문 돔
			while(sc.hasNextInt()) {
				System.out.println(sc.nextInt() * 100);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 읽어오는 도중에 오류가 발생했습니다.");
		}
				
	}

}
```

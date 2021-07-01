// Comparable 사용방법
// 비교할 객체에 Comparable을 상속
// 클래스 내부에 compareTo 메소드를 오버라이드
// return 값이 -1 이면 비교값 앞, 0이면 비교값과 동일, 1이면 비교값 뒤로 정렬됨
// Collection.sort()를 이용하여 가능
// 당연히 컬렉션 프레임워크 내의 자료구조만 가능

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public String get_name() {
		return this.name; 
	}
	
	@Override
	public int compareTo(Student other) {
		if(this.score < other.score) {
			return -1;
		}
		
		return 1;
	}
	
}

public class Main {
	
	public static Integer[] arr;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<Student> students = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String name = sc.next();
			int score = sc.nextInt();
			students.add(new Student(name, score));
		}
		
		Collections.sort(students);
		
		for(int i = 0; i < n; i++) {
			System.out.print(students.get(i).get_name() + " ");
		}
    }
	
}

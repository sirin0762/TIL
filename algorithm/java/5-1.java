// 스택 사용방법

import java.util.Stack;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// <> : 제네릭이라 부름, 자료구조내의 데이터를 명시하여 형변환을 하지 않게 해주는 효과로 인해 속도 향상
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		while(!s.empty()) {
			System.out.println(s.peek());
			s.pop();
		}
	}
}

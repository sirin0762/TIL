// q 사용법
// enqueue 동작 처리를 위해서 데이터를 추가해야하는데 이미 큐가 꽉 찬경우 add는 예외를 발생시키지만 offer는 추가 실패를 의미하는 false를 리턴한다.

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// q 생성
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 입력 : offer, add  삭제 : poll, remove  초기화 : clear
		q.offer(2);
		q.offer(3);
		q.offer(7);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		
	}
}

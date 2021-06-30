// 재귀함수 사용법

public class Main {
	
	
	public static void recursiveFunction(int i) {
    // 반드시 종료조건 명시
		if(i == 100) {
			return;
		}
		System.out.println(i + "번쨰 재귀 함수에서 " + (i + 1) + "번째 재귀 함수를 호출합니다");
		recursiveFunction(i + 1);
		System.out.println(i + "번째 재귀 함수를 종료합니다");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 재귀
		
		recursiveFunction(1);
	}
}

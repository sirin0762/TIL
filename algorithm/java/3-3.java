import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			int min_value = 100001;
			for(int j = 0; j < m; j++) {
				int input = sc.nextInt();
				min_value = Math.min(input, min_value);
			}
			result = Math.max(result, min_value);		
		}		
		System.out.println(result);		
		
	}

}

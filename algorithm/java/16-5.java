// 어려움(아래 코드는 답지)
// 알고리즘 : 매번 2의 배수 3의 배수 5의 배수를 계산, 단, 배수에 들어가는 값은 각각 다르게 설계해야함
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] arr;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
    // i2, i3, i5를 통해 곱해지는 값을 다르게 만듬
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		int next2 = 2;
		int next3 = 3;
		int next5 = 5;
		
		arr[0] = 1;
		
		for(int i = 1; i < n; i++) {
			arr[i] = Math.min(next2, Math.min(next3, next5));
			
			if(arr[i] == next2) {
				i2 += 1;
				next2 = arr[i2] * 2;
			}
			if(arr[i] == next3) {
				i3 += 1;
				next3 = arr[i3] * 3;
			}
			if(arr[i] == next5) {
				i5 += 1;
				next5 = arr[i5] * 5;
			}
		}
		
		System.out.println(arr[n - 1]);
			
	}
}

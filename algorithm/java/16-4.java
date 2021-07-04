// LIS의 전형적인 예, 어려움
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] arr, dp;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));
	}
}

// 퇴사(난이도 어려움)
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] t, p, dp;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		t = new int[n];
		p = new int[n];
		dp = new int[n];
		int maxValue = 0;
				
		for(int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(t));
		System.out.println(Arrays.toString(p));
		
		for(int i = n - 1; i >= 0; i--) {
			if(i + t[i] <= n) {
				dp[i] = Math.max(p[i] + dp[t[i] + i], maxValue);
				maxValue = dp[i];
			}
			else {
				dp[i] = maxValue;
			}
		}
		
		System.out.println(maxValue);
	}
}

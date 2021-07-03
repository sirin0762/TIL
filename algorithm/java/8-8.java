
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static long[] d;
	public static int[] coins;
	
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		d = new long[m + 1];
		coins = new int[n];
		
		for(int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		
		Arrays.sort(coins);
		
		for(int i = 0; i <= m; i++) {
			d[i] = 10001;
		}
		
		for(int i = 0; i < n; i++) {
			d[coins[i]] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = coins[i]; j <= m; j++) {
				d[j] = Math.min(d[j], d[j - coins[i]] + 1);
			}
		}
		
		System.out.println(d[m]);
	}
}

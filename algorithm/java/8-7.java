//개미 전사
import java.util.Scanner;

public class Main {
	
	public static long[] d;
	public static long[] k;
	
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new long[n];
		k = new long[n];
			
		for(int i = 0; i < n; i++) {
			k[i] = sc.nextInt();
		}
		
		d[0] = k[0];
		d[1] = Math.max(k[0],  k[1]);
		
		for(int i = 2; i < n; i++) {
			d[i] = Math.max(d[i - 2] + k[i], d[i - 1]);
		}
		
		System.out.println(d[n - 1]);

		
	}
}

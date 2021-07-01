import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Integer[] a = new Integer[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Integer[] b = new Integer[n];
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		
		Arrays.sort(b, Collections.reverseOrder());
		Arrays.sort(a);
		
		for(int i = 0; i < k; i++) {
			if(a[i] < b[i]) {
				a[i] = b[i];
			}
			else {
				break;
			}
		}
		
		long result = 0;
		for(int i = 0; i < n; i++) {
			result += a[i];
		}
		
		System.out.println(result);	
    }
	
}

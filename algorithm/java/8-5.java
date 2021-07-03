// 반복문을 통한 botton-up 방식

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static long[] d = new long[100];
	
	public static long fibo(int n) {
		for(int i = 1; i <= n; i++) {
			if(i == 1 || i == 2) {
				d[i] = 1;
			}
			else {
				d[i] = d[i - 1] + d[i - 2];
			}
		}
		
		return d[n];
	}
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		System.out.println(fibo(50));    
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// n, m, k 입력	
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int result;
		
		// array 생성	
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		// 배열 출력하는 방법
		System.out.println(Arrays.toString(array));
		
		// 배열 오름차순 정렬
		Arrays.sort(array);
		
		int first = array[n - 1];
		int second = array[n - 2];
		
		int share = m / (k + 1);
		int reminder = m % (k + 1);
		
		result = share * (first * k + second) + reminder * first;
		
		System.out.println(result);
		
		
	}

}

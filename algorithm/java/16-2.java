// 정수 삼각형
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[][] arr;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i + 1; j++) {
				if(j == 0) {
					arr[i][j] = arr[i][j] + arr[i - 1][j];
				}else if(j == i) {
					arr[i][j] = arr[i][j] + arr[i - 1][j - 1];
				}else {
					arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
				}
			}
		}
		
		int result = 0;
		for(int j = 0; j < n; j++) {
			result = Math.max(result, arr[n - 1][j]);
		}
		
		System.out.println(result);
	}
}

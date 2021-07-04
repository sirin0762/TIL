// 금광
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[][] arr;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int j = 1; j < m; j++) {
			for(int i = 0; i < n; i++) {
				if(i == 0) {
					arr[i][j] = arr[i][j] + Math.max(arr[i][j - 1], arr[i + 1][j - 1]);
				}
				else if(i == n - 1) {
					arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j - 1], arr[i][j - 1]);
				}
				else {
					int temp = Math.max(arr[i - 1][j - 1], arr[i][j - 1]);
					arr[i][j] = arr[i][j] + Math.max(temp, arr[i + 1][j - 1]);
				}
			}
		}
		
		System.out.println(Arrays.deepToString(arr));
	}
}
